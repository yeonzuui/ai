# pip install fastapi
# pip install uvicorn
# pip install jinja2           # template 으로 rendering
# pip install python-multipart # POST 로 전달 시 필수
from os import access

from Tools.scripts.win_add2path import modify
# template 사용
from fastapi import FastAPI, Request
# 파일 첨부
from fastapi import File, UploadFile
# static mounting
from fastapi.staticfiles import StaticFiles
# template 지정
from fastapi.templating import Jinja2Templates
# redirect: 사용자가 처음 요청한 URL이 아닌, 다른 URL로 가라고 지시
from starlette.responses import RedirectResponse
# 예외 발생
from starlette.exceptions import HTTPException
# 파일 다운로드
from fastapi.responses import FileResponse

import os
import datetime

# FastAPI 객체 생성
app = FastAPI()
# static mounting
app.mount('/static', StaticFiles(directory = 'static'), name = 'static')
# template 지정
templates = Jinja2Templates(directory = "templates")

UPLOAD_FOLDER = './upload/'
# 디렉토리가 없을 때만 생성
os.makedirs(UPLOAD_FOLDER,
            exist_ok = True)

def stamp2real(stamp):
    return datetime.datetime.fromtimestamp(stamp)

def info(filename):
    create   = stamp2real(os.path.getctime(filename))
    modify   = stamp2real(os.path.getmtime(filename))
    access   = stamp2real(os.path.getatime(filename))
    tempsize = os.path.getsize(filename)
    size = ''
    if tempsize < 1024 * 1024:
        size = '{:.2f}KB'.format(tempsize / 1024)
    else:
        size = '{:.2f}MB'.format(tempsize / (1024 * 1024))
    return create, modify, access, size

@app.get('/')
@app.post('/')
async def index(request:Request):
    # 업로드 폴더에 있는 파일 list
    filelist = os.listdir(UPLOAD_FOLDER)
    infos = []
    for filename in filelist:
        create, modify, access, size = info(UPLOAD_FOLDER + filename)
        infos.append({
            'name':filename,
            'create':create,
            'modify':modify,
            'size':size
        })
    return templates.TemplateResponse("home.html",
                                      {'request':request,
                                       'infos':infos})

# 파일 업로드
@app.post('/upload')
async def upload(request:Request,
                 file:UploadFile = File()): # 파라미터 이름은 input 태그의 name="file"과 같아야 함
    # 파일 첨부했을 경우
    if file.filename:
        # file_path = UPLOAD_FOLDER + file.filename
        file_path = os.path.join(UPLOAD_FOLDER, file.filename)
        with open(file_path, 'wb') as buffer: # stream
            # await: 비동기적으로 read() 함수 수행하고 저장
            buffer.write(await file.read())
        create, modify, access, size = info(file_path)
        fileinfo = {'ctime':create,
                    'size':size}
        return templates.TemplateResponse('check.html',
                                          {'request': request,
                                           'fileinfo':fileinfo})
    # 파일 첨부 안 했을 경우
    else:
        # 405 Error: '/' 경로로 redirect 시 POST 방식을 찾을 수 없다고 뜰 수 있음, POST 방식 추가해주기
        return RedirectResponse(url = '/',
                                status_code = 307)

# 파일 다운로드 FileResponse
@app.get('/download/{filename}')
async def download_file(filename):
    return FileResponse(UPLOAD_FOLDER + filename,                # 다운받을 파일 경로
                        media_type = 'application/actet-stream', # 브라우저에서 열지 말고 다운로드만
                        filename = filename)                     # 생략 가능(파일 이름 지정 가능)


# 삭제는 반드시 DELETE 방식으로 전달

# @app.get('/del/{filename}')
# async def delete(filename:str):
#     os.remove(UPLOAD_FOLDER + filename)
#     return RedirectResponse('/')

@app.delete('/del/{filename}')
async def delete_file(filename:str):
    # 파일이 존재하지 않으면 메세지 출력
    if not os.path.exists(UPLOAD_FOLDER + filename):
        return f'{filename}은 없는 파일입니다'
    # 파일 존재하면 제거
    os.remove(UPLOAD_FOLDER + filename)
    return f'{filename} 삭제 성공'
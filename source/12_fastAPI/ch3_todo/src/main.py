# src → 소스 루트
# pip install fastapi
# pip install uvicorn
# pip install jinja2
# pip install python-multipart # POST 사용 위함

# template 사용
from fastapi import FastAPI, Request
# 특정 요청경로에서 template로 갈 핸들러 함수
from fastapi import Request
# static mounting
from fastapi.staticfiles import StaticFiles
# template 지정
from fastapi.templating import Jinja2Templates
# redirect: 사용자가 처음 요청한 URL이 아닌, 다른 URL로 가라고 지시
from starlette.responses import RedirectResponse
# 자동 타입 체크
from pydantic import BaseModel
from models import ToDoRequest
# create(POST 방식) 때 사용
from fastapi import Form
# 예외 발생
from fastapi import HTTPException

import os
app = FastAPI()

filepath = os.path.abspath(__file__)
# 현재 파일의 절대 경로
print(filepath) # D:\ai\source\12_fastAPI\ch3_todo\src\main.py

# 현재 폴더의 절대 경로
BASE_DIR = os.path.dirname(filepath)
print(BASE_DIR)

# static 폴더의 절대 경로
static_folder = os.path.join(BASE_DIR, '../static')
print(static_folder)

app.mount('/static',
          StaticFiles(directory = static_folder),
          name = 'static')

templates = Jinja2Templates(directory = os.path.join(BASE_DIR,
                                                     '../templates'))
# cd src에서 실행


todo_data = {
    1:{
        'id'       : 1,
        'contents' :'딥러닝 공부',
        'is_done'  : True
    },
    2:{
        'id'       : 2,
        'contents' : 'FastAPI 공부',
        'is_done'  : False
    },
    3:{
        'id'       : 3,
        'contents' : '머신러닝 공부',
        'is_done'  : False
    },
    4:{
        'id'       : 4,
        'contents' : 'Django 공부',
        'is_done'  : False
    }
}
@app.get('/')
# async def health_check_handler():
#     return {'status':'ok'}
# /todos(할 일 1부터 출력) 또는 /todos?order=desc(할 일 역순으로 출력)
@app.get('/todos')
@app.post('/todos')
async def get_todos_handler(request:Request,
                            order:str | None = None):
    # dict → list로 변환
    todos = list(todo_data.values())
    # order가 오름차순이면 끝에서부터 -1씩 출력(슬라이싱 이용)
    if order and order.upper() == 'DESC':
        todos = todos[::-1]
    next_id = max(todo_data.keys()) + 1
    return templates.TemplateResponse('todos.html',  # todo 목록, todo 입력 form
                                      {'request': request,
                                       'todos': todos,
                                       'next_id': next_id,
                                       'order':order.upper() if order else ''})

# 상세보기 페이지
@app.get('/todos/{todo_id}')
# HTML로 rendering
async def get_todo_detail_handler(request:Request,
                                  todo_id:int):
    # 없는 id 들어오면 빈 Dict
    todo = todo_data.get(todo_id, {}) # todo_data[todo_id]
    return templates.TemplateResponse('todo.html',
                                      {'request': request,
                                       'todo': todo})

# 할 일 등록 페이지
@app.post('/create')
async def create_todo_handler(todo:ToDoRequest = Form()):
    # print('form 태그로부터 입력된 todo: ', todo)
    todo_data[todo.id] = todo.dict()
    # {'id'      : todo.id,
    #  'contents': todo.contents,
    #  'is_done' : todo.is_done}
    # todos를 POST 방식으로 전송
    return RedirectResponse('/todos')

# 삭제
@app.delete('/delete/{todo_id}', status_code = 200)
async def delete_todo_handler(todo_id:int):
    # todo_id가 없는 key 값일 경우 Error -> 불안정함
    # del todo_data[todo_id]

    # todo_id가 없는 key 값일 경우 None
    todo = todo_data.pop(todo_id, None)

    if todo:
        return f'{todo_id}번 todo 삭제 성공'
    return f'{todo_id}는 등록되지 않는 todo여서 삭제 실패'
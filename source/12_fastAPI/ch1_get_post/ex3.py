# pip install jinja2
from fastapi import FastAPI
# static 폴더 지정
from fastapi.staticfiles import StaticFiles
# template 지정
from fastapi.templating import Jinja2Templates
# HTML로 rendering 하기 위함
from fastapi import Request
# form 데이터 자동 검증 시스템
from pydantic import BaseModel
# POST 방식으로 들어온 form 데이터 받을 때 필요
from fastapi import Form

# 유효성 검사
# BaseModel 로부터 상속받은 User
class User(BaseModel):
    name : str
    id : str
    pw : int

# FastAPI 객체 생성
app = FastAPI()

# POST 방식일 때 아래 2개 과정 필수
# 1. template 지정
templates = Jinja2Templates(directory = "templates")
# 2. static 폴더 지정
app.mount("/static",
          StaticFiles(directory = "static"),
          name = "static")

@app.get('/')

@app.get('/html1')
# ex3-1.html에 rendering
# 매개변수로 request 전달
async def html1(request:Request): # Type Hint
    return templates.TemplateResponse("ex3-1.html",
                                      {'request':request})

@app.get('/html2')
# ex3-2.html에 rendering
# 매개변수로 request 전달
async def html2(request:Request): # Type Hint
    return templates.TemplateResponse("ex3-2.html",
                                      {'request':request,
                                       'name':'홍길동'})

# @app.get('/html3')
# # json 으로 return
# # 매개변수 request 불필요
# async def html3(name:str, id:str, pw:int):
#     return {'name':name, 'id':id, 'pw':pw}

# POST 방식으로 받기
# pip install python-multipart # 필수
@app.post('/html3')
# = Form(): Form 태그로부터 받음
async def html3(user:User = Form()):
    # return user.dict()
    return {'name':user.name,
            'id':user.id,
            'pw':user.pw}
# Postman 에서 post 방법으로 검증 시, [Body] - [form-data]로 바꾸고 parameter 입력

# async def html3(name:str = Form(),
#                 id:str = Form(),
#                 pw:int = Form()):
#     return {'name': name, 'id': id, 'pw': pw}



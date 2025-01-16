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
async def html1(request:Request):
    # ex3-1.html에 rendering
    # 매개변수로 request 전달
    return templates.TemplateResponse("ex3-1.html",
                                      {'request':request})


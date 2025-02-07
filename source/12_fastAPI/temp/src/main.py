from fastapi import FastAPI, Request
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from starlette.responses import RedirectResponse

from models import ToDoRequest
from fastapi import Form #create시 필요
from database.repository import get_todos, get_todo, create_todo, update_todo, delete_todo
import os

app = FastAPI()
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
app.mount('/static',
          StaticFiles(directory = os.path.join(BASE_DIR, '../static')),
          name = 'static')
templates = Jinja2Templates(directory = os.path.join(BASE_DIR, '../templates'))

# Decoration 데코레이션
# 뒤에 C(post), R(get)), U(put, patch), D(delete) 올 수 있음
@app.get('/') # get 방식으로 '/' 요청경로 들어오면
@app.get('/todos')
# FastAPI는 비동기를 기본으로 지원하는 파이썬 웹 프레임워크
# Django는 MVT 기반의 강력한 파이썬 웹 프레임워크
# 비동기 함수 정의(비동기 처리)를 위한 예약어
# request:Request -> html로 rendering
async def get_todos_handler(request:Request): # type hint

    todos = get_todos()
    return templates.TemplateResponse('todos.html',
                                      {'request':request,
                                       'todos':todos})

# 경로의 매개변수에 type을 int로 지정
@app.get('/todos/{todo_id:int}')
async def get_todo_handler(request:Request, todo_id):
    todo = get_todo(todo_id)
    return templates.TemplateResponse('todo.html',
                                      {'request':request,
                                       'todo':todo})
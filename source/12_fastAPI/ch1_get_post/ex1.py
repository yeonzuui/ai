# 파이썬 웹 프로그램
    # django(Framework), flask, fastAPI(Micro Framework)

# fastAPI
# 1. 비동기 restAPI 서버(웹) 프로그램을 만드는 데 특화
    # HTTP 방식: GET(read), POST(create), PUT(update), DELETE(delete)
    # /empsch/scott → /empsch?ename=scott
# 2. 자동 데이터 검증 및 문서화
# 3. 빠른 개발 속도, 높은 생산성 및 성능

# 서버 프로그램을 만들기 위한 Micro Framework
# pip install fastapi
# 서버
# pip install uvicorn

from fastapi import FastAPI

# app 객체 만들기
app = FastAPI()

@app.get('/')
# async: 비동기 처리 (안 쓰면 동기 함수)
async def index():
    return {'message':'Hello, Fastapi. 안녕, 한글'}
    # 실행 방법: 터미널에서 uvicorn 파일명:fastapi객체명 --port=8000 --reload

@app.get('/test1')
async def test1():
    return ['둘리', '또치', '도우너']

@app.get('/test2')
async def test2():
    return '<h1>안녕, FastAPI</h1>'

@app.get('/test3')
async def test3():
    return 1000

# docs
# Try it out - execute 통해 실행 결과 미리 검증 가능
# 주소창에 127.0.0.1:8000/docs
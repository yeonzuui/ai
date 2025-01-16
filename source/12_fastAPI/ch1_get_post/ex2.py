# RestAPI parameter 전달 방식
    # /items/item_id, /items?skip=10
from fastapi import FastAPI
app = FastAPI()
item_db = [{'name':'홍길동', 'age':30},
           {'name':'신길동', 'age':20},
           {'name':'김길동', 'age':10}]

# link 내 item_id가 read_item의 매개변수로 적용
@app.get('/items/{item_id}')
async def read_item(item_id:str,           # type hint 지정 가능
                    pw:str | None = None): # None = None 파라미터 없을 수도 있음
    # pw 들어오면 id/pw 둘 다 return, pw 안 들어오면 id만 return (Dict 형태)
    if pw: # /items/abc?pw=111
        return {'item_id':item_id, 'pw':pw}

    else: # /items/abc
        return {'item_id':item_id}

# /items?skip=1&limit=5
@app.get('/items')
# 매개변수 skip과 limit는 정수
# limit 기본값은 10
async def read_items(skip:int, limit:int=10):
    # DB 내용을 skip ~ limit 슬라이싱
    return item_db[skip:skip+limit]

# item/hong/33
@app.get('/item/{name}/{age}')
async def item(name:str, age:int):
    return {'이름':name, '나이':age}

# docs
# Try it out - execute 통해 실행 결과 미리 검증 가능
# 주소창에 127.0.0.1:8000/docs
# postman 프로그램을 통해 더 편하게 검증 가능
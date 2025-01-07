# 함수에 커서 갖다 대면 document 사이트 참고 가능
# shift + F10 실행
# ctrl + space: 자동 완성
from flask import Flask

# App Instance 생성
app = Flask(__name__)

# @는 decorator
# decorator의 기능은 ex2에서 다룸 
@app.route('/')
def hello():
    return "<h1>HELLO WORLD</h1>"

# app.run() 해야만 실행됨
if __name__ == '__main__': # 현재 실행 중인 모듈 이름이 __main__이면(현재 메인 모듈 실행 중이면)
    app.run(debug = True,) # source 수정, 저장 시 서버 자동 재시작
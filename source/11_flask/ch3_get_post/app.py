# request
# URL의 파라미터를 받는 방식과 관련: get, post
from flask import Flask, render_template, request
app = Flask(__name__)

# 요청 경로 2개 추가
# 회원가입 페이지, 회원가입 폼

# /user/hong
# 여기선 불가능
# @app.route('/user/<name>')
# def user(name):

# /user?name=hong
@app.route('/user')
def user():
    # get 방식 파라미터 값 받기
    name = request.args.get("name")
    return "<h1>User Name =" + name + "</h1>"

@app.route('/')
def index():
    return render_template("join_get/index.html")

@app.route('/join_form')
def join_form():
    return render_template("join_get/join.html")

if __name__ == '__main__':
    app.run()
# app.py 파일일 경우 터미널에서 flask run 입력 시, app.py 파일 자동 실행
# ctrl + c 시 종료되고 PowerShell로 이동
# cmd → 다시 가상환경 들어가려면 .venv\Scripts\activate
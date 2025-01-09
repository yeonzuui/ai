# request
# URL의 파라미터를 받는 방식과 관련: get, post
from flask import Flask, render_template, request
from models import Member
from filters import mask_password # 필터 함수
app = Flask(__name__)
# 필터 추가
# template_filter("필터명")(함수명)
app.template_filter("mask_password")(mask_password) 

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

@app.route('/join')
def join():
    name = request.args.get("name") # get
    id   = request.args.get("id")
    pw   = request.args.get("pw")
    addr = request.args.get("address")
    member = Member(name, id, pw, addr)
    return render_template("join_get/result.html",
                           member = member)

@app.route('/welcome')
def welcome():
    name  = request.args.get("name") # GET 방식으로 받은 파라미터 값
    value = request.args.get("value")
    print(type(value))
    return render_template('welcome.html',
                           name = name,
                           value = value)

# result.html에서 비밀번호를 *로 변환하는 필터 추가
# @app.template_filter("mask_password")
# def mask_password(password):
#     return '*'*len(password)

if __name__ == '__main__':
    app.run(debug = True,
            port  = 8090)
# app_get.py 파일일 경우 터미널에서 flask run --reload 입력 시, app_get.py 파일 자동 실행
# ctrl + c 시 종료되고 PowerShell로 이동
# cmd → 다시 가상환경 들어가려면 .venv\Scripts\activate
    # py파일이 변경될 떄마다 서버 자동 재시작
    # templates나 static 파일이 변경될 때 서버 자동 재시작이 안 되기도 함
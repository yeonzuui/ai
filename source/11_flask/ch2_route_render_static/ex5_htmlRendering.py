# Rendering
# html로 보내기
from flask import Flask, render_template, url_for

app = Flask(__name__)

# 경로 2개 추가
@app.route('/')
def hello():
    return render_template("05_index1.html") # 대소문자 구분 # html 파일 생성

# /profile/홍길동/33
@app.route('/profile/<name>/<int:age>') # age는 반드시 숫자로
def get_profile(name, age):
    return render_template("05_profile.html",
                           name = name,
                           age  = age)

# if __name__ == '__main__':
#     app.run(debug = True)
# # html 경로 올바르지 않을 때 TemplateNotFound 에러
# app.run(debug = True)

if __name__ == '__main__':
    with app.test_request_context():
        print('※', url_for('hello'))
        print('※', url_for(endpoint = 'get_profile',
                            name = 'HONG',
                            age  = 30))
    app.run(debug = True)
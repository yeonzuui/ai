# 정적 경로(Static Route)
# http://localhost:8090/join?id=abc&pw=111
# 동적 경로(Dynamic Route)
# http://localhost:8090/join/abc/111 (RESTFull)

from flask import Flask, url_for
app = Flask(__name__)

# Routing
# URL을 특정 함수에 연결하는 작업
# 1) Static Routing
@app.route('/hello')
def hello():
    return "<h1>Hello, World!</h1>"
# 2) Dynamic Routing
# 상황에 따라 변화하는 URL을 함수와 연결
@app.route('/profile/<username>')
def get_profile(username):
    return "<h1>profile: " + username + "</h1>"

if __name__ == '__main__':
    # test_request_context(): 테스트 모드에서 출력
    with app.test_request_context():
        print('※※※', url_for('hello'))
        print('※※※', url_for('get_profile',
                               username = 'hong')) # username 입력 필수
        app.run(debug = True, # source 수정, 저장 시 서버 자동 재시작
                port  = 80)

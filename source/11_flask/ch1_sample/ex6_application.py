from flask import Flask
from ex5_predict import loaded_model, predict_apt_price

# 웹 프로그램 만들기 위한 Flask 객체 생성
application = Flask(__name__)


@application.route('/')
def hello():
    return "<h1>Hello, Flask!</h1>"

# 2010년 105m² 8층의 아파트 가격을 예측
@application.route('/apt/<year>/<square>/<floor>') # /apt/2010/105/8
def aptPrice(year, square, floor):
    answer = predict_apt_price(year, square, floor)
    return "<h1>예측금액은 {}</h1>".format(answer)

if __name__ == '__main__':
    # debug = True: 코드가 변경, 저장될 때마다 서버를 자동 재시작
    application.run(host = "127.0.0.1",
                    port = 80, # JSP 때 썼던 port 번호는 8090
                    debug = True)
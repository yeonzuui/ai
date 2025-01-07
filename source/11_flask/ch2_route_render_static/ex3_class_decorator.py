# instance를 만들어 decorator 사용
class SampleFlask:
    # 매개변수 있어도 없어도 무관하도록 default 값 부여
    def __init__(self, arg = ''):
        pass
    def check(self, func):
        def wrapper():
            print(func.__name__, '함수 전처리')
            func()
            print(func.__name__, '함수 후처리')
        return wrapper

# SampleFlask 객체 생성
app = SampleFlask(__name__)

# decorator로 구현
@app.check
def hello():
    print('hello')

if __name__ == '__main__':
    hello()
    # app.run()

# def hello():
#     print('hello')
# trace_hello = app.check(hello)
# trace_hello()
# decorator 정의
# 함수 안 함수
# check()는 함수를 매개변수로 받아 wrapper()를 정의하고 return 하는 것 말고는 아무 기능 X
def check(func):
    def wrapper():
        print(func.__name__, '함수 전처리')
        func()
        print(func.__name__, '함수 후처리')
    return wrapper

# @는 decorator
# hello()만 실행해도 check() 실행됨
@check
def hello():
    print('Hello')

# world()만 실행해도 check() 실행됨
@check
def world():
    print('world')

if __name__ == '__main__':
    hello()
    world()
# def hello():
#     print('Hello')
# def world():
#     print('WORLD')
#
# # trace_hello와 trace_world는 함수
# trace_hello = check(hello)
# trace_hello()
# trace_world = check(world)
# trace_world()
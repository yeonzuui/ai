# yield 문법
# return의 경우 첫 번째 코드만 출력됨
# yield는 결과값 여러 개 출력 가능
# generator는 Java에서의 iterator와 같은 기능
def test_yield():
    try:
        yield '세션 객체'
    finally:
        print('세션 객체 닫기')

ret = test_yield()
while True:
    value = next(ret, None) # 다음 데이터 없으면 None
    if value is None:
        break
    print(value)
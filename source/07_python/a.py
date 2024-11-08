def test():
    """
    독스트링 테스트
    함수의 도움말
    """
    print('모듈(*.py) 테스트입니다')
    print('주말 잘 보내세요')

if __name__ == '__main__': # 현재 실행 모듈 main일 때만 test() 실행
    test()
else:
    print("__name__= {}".format(__name__)) # 현재 모듈명 출력
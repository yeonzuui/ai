import sys
# 명령문을 요소로 갖는 리스트 반환
# print(sys.argv) 
# 터미널에서 실행시 태어난 해를 파이썬 파일과 같이 입력: python argv_test.py 2000
if len(sys.argv) == 1:
    birth = int(input('태어난 년도를 입력하세요: '))
else:
    birth = int(sys.argv[1])
age = 2024 - birth
if age >= 19:
    group = '성인'
elif 13 <= age < 19:
    group = '청소년'
else:
    group = '아동'
print('{}년도 생이신 당신은 {}살이고, {}입니다'.format(birth, age, group))
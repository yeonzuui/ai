# sample_pac/cd/c.py
# ab/a.py 참조
from ..ab import *
# .. 상위폴더
# .  현재폴더

def nice():
    print('sample_pac/cd안의 c모듈 안의 nice')
    a.hello() # a모듈 hello() 불러옴

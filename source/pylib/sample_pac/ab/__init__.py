"""
sample_pac/ab/__init__.py
ab 패키지를 import할 때 자동 실행되는 파일

[from sample_pac.ab import *]
위의 명령문 수행시 a모듈만 자동 import 되도록 하기 위해
__all__ 셋팅
"""

__all__ = ['a']
print('sample_pac 패키지 안의 ab패키지가 로드되었습니다')
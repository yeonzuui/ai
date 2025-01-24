from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

# 오라클 url
DATABASE_URL = 'oracle+cx_oracle://scott:tiger@localhost:1521/?service_name=xe'

# 엔진 생성
engine = create_engine(DATABASE_URL, echo = True)
# 세션 클래스 생성
SessionFactory = sessionmaker(autocommit = False,
                              autoflush  = False,
                              bind       = engine)

# yield 문법을 이용한 세션 자동 종료 함수
# test_yield.py 참고
def get_db():
    # session 객체 생성
    session = SessionFactory()
    try:
        yield session
    finally:
        session.close()

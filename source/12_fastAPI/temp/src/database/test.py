# ORM 지원(DB 연동)
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, Session

# 테이블 정의 시 필요
from sqlalchemy.orm import declarative_base
from sqlalchemy import Column, Integer, String, Boolean

# 데이터베이스는 Oracle XE
DATABASE_URL = 'oracle+cx_oracle://scott:tiger@localhost:1521/?service_name=xe'

# 엔진 생성
engine = create_engine(DATABASE_URL, echo = True)
# SQL 공장
SessionFactory = sessionmaker(autocommit = False,
                              autoflush  = False,
                              bind       = engine)
# Todo 테이블 정의
Base = declarative_base()
class ToDo(Base): # Base 클래스로부터 상속
    __tablename__ = 'todo'
    id      = Column(Integer, primary_key = True)
    content = Column(String(256), nullable = False) # VARCHAR2(256), NOT NULL
    is_done = Column(Boolean, default = False)      # 디폴트 값은 0

# import 시에는 실행 X, 애플리케이션의 시작점이 이 파일일 때만 실행
if __name__ == '__main__':
    # 테이블 생성
    Base.metadata.create_all(bind = engine)
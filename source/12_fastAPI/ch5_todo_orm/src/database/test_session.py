from sqlalchemy.orm import Session
from sqlalchemy import select
from database.connection import SessionFactory
from database.orm import ToDo

# 세션 객체 생성
session = SessionFactory()
# 디버깅
print(session.scalars(select(ToDo).order_by(ToDo.id)).all())
session.close()
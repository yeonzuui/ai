from typing import List
from sqlalchemy.orm import Session
from models import ToDoRequest
from database.orm import ToDo
from sqlalchemy import select, update, delete
from database.connection import SessionFactory

# ALT + ENTER - [이름 가져오기]
def get_todos(session:Session) -> List[dict]:
    return session.scalars(select(ToDo).order_by(ToDo.id)).all()

# first(): 결과 1개 받음. id는 PK이니까 조건에 맞는 데이터는 1건 출력됨
def get_todo(session:Session, todo_id:int) -> dict:
    return session.scalars(select(ToDo).where(ToDo.id == todo_id)).first()

def create_todo(session:Session, todo:ToDoRequest) -> str:
    new_todo = ToDo(contents = todo.contents,
                    is_done  = todo.is_done)
    print('★ 입력할 데이터: ', new_todo)
    # DB에 insert
    session.add(new_todo)
    # print('★ commit 전 데이터의 id: ', new_todo.id) # id = None
    # 커밋하면 SQL문 생성되고, id 생성됨
    session.commit()
    # print('★ commit 후 데이터의 id:: ', new_todo.id,)
    if new_todo.id:
        return f'[{new_todo}] → "입력 성공"'
    return ''


def update_todo(session:Session, id:int, contents:str, is_done:bool) -> str:
    stmt = update(ToDo).where(ToDo.id == id).values(contents = contents,
                                                    is_done  = is_done)
    # update문 실행 결과를 result에 할당
    result = session.execute(stmt)
    session.commit()
    # 성공 여부 확인
    if result.rowcount:
        return f'[{id} - {contents}] → "수정 성공"'
    return ''

def delete_todo(session:Session, todo_id : int) -> str:
    stmt = delete(ToDo).where(ToDo.id == todo_id)
    # delete문 실행 결과를 result에 할당
    result = session.execute(stmt)
    # 성공 여부 확인
    if result.rowcount:
        return f'[{todo_id}] → "삭제 성공"'
    return ''

if __name__ == '__main__':
    # session 객체 생성
    session = SessionFactory()
    print('1. 목록: ', get_todos(session))
    print('2. 상세: ', get_todo(session, 1))
    print('3. 상세: ', get_todo(session, 9))

    # todo 객체 생성
    todo = ToDoRequest()
    todo.contents = '할 일 256자 이내'
    todo.is_done = True
    result = create_todo(session, todo)
    print('4. 추가: ', result if result else '추가 실패')

    result = update_todo(session, 1, '바꿔', False)
    print('5. 수정: ', result if result else '수정 실패')
    result = delete_todo(session, 1)
    print('6. 삭제: ', result if result else '삭제 실패')
    session.close()
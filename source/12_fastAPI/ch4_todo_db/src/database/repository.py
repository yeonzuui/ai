# connection 변수 필요
from traceback import print_tb
from typing import List

from database.connection import conn
from models import ToDoRequest

# READ - 전체 가져오기
def get_todos() -> List[dict]:
    cursor = conn.cursor()
    sql    = 'SELECT * FROM TODO ORDER BY ID'
    # SQL문 실행
    cursor.execute(sql)
    # SQL 결과를 tuple list로 받음
    results = cursor.fetchall()
    # INSERT, UPDATE, DELETE 경우 close 필수
    cursor.close()
    todos = []
    for result in results:
        todos.append({'id'      :result[0],
                      'contents':result[1],
                      'is_done' :result[2]})
    return todos

# READ - ID로 검색
def get_todo(todo_id:int)->dict:
  cursor = conn.cursor()
  sql = 'SELECT * FROM TODO WHERE ID = :id';
  cursor.execute(sql, {'id':todo_id})
  result = cursor.fetchone() # 결과를 한행 튜플로 받음
  cursor.close()
  if result:
    return {'id':result[0],
            'contents':result[1],
            'is_done':result[2]}
  return {}

def create_todo(todo:ToDoRequest)->str:
  cursor = conn.cursor()
  print('추가될 내용 :', todo.contents, todo.is_done)
  sql = '''INSERT INTO TODO (ID, CONTENTS, IS_DONE) 
            VALUES (TODO_SQ.NEXTVAL, :contents, :is_done)'''
  cursor.execute(sql, {'contents':todo.contents,
                       'is_done':todo.is_done})
  conn.commit()
  result = cursor.rowcount # sql문이 수행된 행수
  cursor.close()
  if result:
    return '추가성공'
  return '추가 실패'

def update_todo(id:int, contents:str, is_done:bool)->str:
    cursor = conn.cursor()
    sql = 'UPDATE TODO SET CONTENTS = :contents, IS_DONE = :is_done WHERE ID=:id'
    cursor.execute(sql, {'id':id,
                          'contents':contents,
                          'is_done':is_done})
    conn.commit()
    result = cursor.rowcount # sql 수행 함수
    cursor.close()
    if result:
        return f'{id} - {contents} 수정 성공'
    return '수정 실패'

def delete_todo(todo_id : int) -> str:
  cursor = conn.cursor()
  sql = 'DELETE FROM TODO WHERE ID=:id'
  cursor.execute(sql, {'id':todo_id})
  conn.commit()
  result = cursor.rowcount
  cursor.close()
  if result:
    return f'{todo_id} 삭제 성공'
  return ''

if __name__ == '__main__':
    todo = ToDoRequest()
    todo.contents = '추가할 todo'
    todo.is_done = True
    print('3. create:', create_todo(todo))
    print('1. 목록: ', get_todos())
    print('2. 상세: ', get_todos(1))
    print('2. 상세: ', get_todos(9))
    print('4. update: ', update_todo(1, '이걸로 바꿔', True))
    print('5. delete :', delete_todo(1))
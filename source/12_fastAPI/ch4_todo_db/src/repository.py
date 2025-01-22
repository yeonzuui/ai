# connection 변수 필요
from connection import conn

# READ - 전체 가져오기
def get_todos():
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

if __name__ == '__main__':
    print(get_todos())
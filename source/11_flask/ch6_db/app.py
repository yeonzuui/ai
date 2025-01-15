# 요청경로를 html로 응답
from flask import Flask, render_template
# 요청경로를 json으로 응답
from flask import jsonify
# json으로 응답 시, 한글 깨짐 해결
from flask import Response, json
# 오라클 연동
import cx_Oracle

app = Flask(__name__)

dsn = cx_Oracle.makedsn("localhost", 1521, "xe")
conn = cx_Oracle.connect(user = 'scott', password = 'tiger', dsn = dsn)

@app.route('/')
def get_emps():
    # cursor 객체 생성
    cursor = conn.cursor()
    sql = "SELECT * FROM EMP"
    # sql문 전송
    cursor.execute(sql)
    # tuple list로, 결과 한 행도 없으면 []
    emps = cursor.fetchall()
    cursor.close()
    return render_template("emps.html", emps = emps)

@app.route('/detail_json/<ename>')
def json_response(ename):
    # cursor 객체 생성
    cursor = conn.cursor()
    sql = "SELECT * FROM EMP WHERE ENAME = UPPER(:ENAME)"
    # sql문 전송
    cursor.execute(sql, {'ename':ename})
    # tuple list로, 결과 한 행도 없으면 []
    emps = cursor.fetchall()
    # descriptoin에서 key(컬럼명)만 추출
    keys = [desc[0] for desc in cursor.description]
    cursor.close()
    # 결과 담을 딕셔너리
    result = {}
    # 검색한 이름이 DB에 있으면
    if emps:
        for key, data in zip(keys, emps[0]):
            result[key] = data
        # result 변수를 json 타입으로
        return jsonify(result)
    else:
        # return jsonify({'result':'해당 이름 없음'})
        # response 객체 생성
        # ensure_ascii = False: 아스키 코드
        response = Response(json.dumps({'result':'해당 이름 없음'}, 
                                       ensure_ascii = False),
                                       mimetype = 'application/json')
        return response
        
if __name__ == "__main__":
    app.run(debug = True)

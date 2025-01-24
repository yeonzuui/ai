import cx_Oracle
from click import password_option

# 라이브러리 추가될 때마다 [pip freeze > requirements.txt]로 업데이트 해주기

dsn  = cx_Oracle.makedsn('localhost', 1521, 'xe')
conn = cx_Oracle.connect(user     = 'scott', # Dict 매개변수 자동완성 불가
                         password = 'tiger',
                         dsn      = dsn)

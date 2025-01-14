# Form 유효성 검사
# pip install flask_wtf
# 쉽고 유연한 폼 적용하여 유효성 검증
# CSRF 보호 (스크립트가 form 데이터를 날렸는지, 사람이 날렸는지 감지)

from flask import Flask, render_template#, request

# 유효성 검사를 위한 form 객체
from flask_wtf import FlaskForm
from flask_wtf.file import FileField, FileRequired

# 파일 첨부 시, 서버에 영향을 미칠 수 있는 파일명 내 특수 문자를 "_"로 변경
from werkzeug.utils import secure_filename
import os
import datetime

app = Flask(__name__)
# print(app.config)
# 유효성 검사 중 CSRF 공격을 방지하기 위한 토큰 생성
app.config['SECRET_KEY'] = 'secret' # 유추하기 어려운 임의의 문자로 설정

# FlaskForm으로부터 상속받은 클래스(객체) 생성
class FileForm(FlaskForm):
    # 파일이 들어왔는지 확인
    files = FileField(validators = [FileRequired()])

# ms → datetime 형으로 변환
def stamp2real(stamp):
    'stamp(1970.01.01 ~ 특정 시점까지의 초수)를 입력받아 특정 시점을 가독성 높은 문자로 변환'
    return datetime.datetime.fromtimestamp(stamp)

# 파일 정보를 return
def info(filename):
    '''
    파일 생성 시각, 마지막 수정 시간, 마지막 액세스 시간, 파일 사이즈를 return
    시간의 단위는 밀리세컨
    '''
    ctime = stamp2real(os.path.getctime(filename))
    mtime = stamp2real(os.path.getmtime(filename))
    atime = stamp2real(os.path.getatime(filename))
    size  = os.path.getsize(filename)
    return ctime, mtime, atime, size

@app.route('/', methods = ['GET', 'POST'])
def upload_file():
    form = FileForm()
    # validate_on_submit(): form 데이터 유효한지, POST 요청으로 들어왔는지 검사
    # if request.method == 'POST': ←-- 필요 없음
    if form.validate_on_submit():
        'form에서 받은 파일을 저장하고 check.html로'
        # upload 된 데이터 받기
        f = form.files.data
        safe_filename = secure_filename(f.filename)
        f.save('./upload/' + safe_filename)
        '저장된 파일 f에 대한 정보(create, modify, access, size)'
        ctime, mtime, atime, size = info('./upload/' + safe_filename)
        # 딕셔너리 형태로
        fileinfo = {'ctime':ctime,
                    'mtime':mtime,
                    'atime':atime}
        # 파일 크기가 1MB 이하면
        if size <= 1024*1024:
            # KB 단위로 출력(소수점 3자리)
            fileinfo['size'] = '{:.3f}KB'.format(size / 1024)
        # 파일 크기가 1MB 초과면
        else:
            # MB 단위로 출력(소수점 3자리)
            fileinfo['size'] = '{:3f}MB'.format(size / (1024*1024))

        return render_template('check.html',
                               fileinfo = fileinfo) # 파일 정보 전달
    else:
        return render_template('upload.html',
                               form = form)

if __name__ == '__main__':
    app.run(debug = True, port = 80)


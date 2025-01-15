# 파일 첨부 화면(home.html)
# form 태그 + upload 에 첨부된 파일 list(파일 다운로드, 파일 삭제)
from os import access

from flask import Flask, render_template
# 다운로드 시 필요
from flask import send_file
# 삭제 후 '/' 요청 경로로 redirect
from flask import redirect, url_for
from flask_wtf import FlaskForm
from flask_wtf.file import FileField, FileRequired
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
    create   = stamp2real(os.path.getctime(filename))
    modify   = stamp2real(os.path.getmtime(filename))
    access   = stamp2real(os.path.getatime(filename))
    tempsize = os.path.getsize(filename)
    size     = ''
    # 파일 크기가 1MB 이하면
    if tempsize < 1024 * 1024:
        # KB 단위로 출력(소수점 3자리)
        size = '{:.3f}KB'.format(tempsize / 1024)
    # 파일 크기가 1MB 초과면
    else:
        # MB 단위로 출력(소수점 3자리)
        size = '{:.3f}MB'.format(tempsize / (1024 * 1024))
    return create, modify, access, size

@app.route('/', methods = ['GET', 'POST'])
def main_page():
    # form 객체 생성
    form = FileForm()
    # POST 요청 방식으로 form 데이터가 유효하게 들어왔는지
    if form.validate_on_submit():
        'form에서 받은 파일을 저장하고 check.html로'
        # upload 된 데이터 받기
        f = form.files.data
        filepath = './upload/' + secure_filename(f.filename)
        f.save(filepath)
        '저장된 파일 f에 대한 정보(create, modify, access, size)'
        create, modify, access, size = info(filepath)
        # 딕셔너리 형태로
        fileinfo = {'ctime':create,
                    # 'modify':modify,
                    # 'access':access,
                    'size':size}
        return render_template('check.html',
                               fileinfo = fileinfo) # 파일 정보 전달
    # GET 요청 방식이거나 form 데이터가 유효하지 않은 경우
    # upload 폴더의 파일 list를 home.html로 render
    filelist = os.listdir('upload')
    # print(['upload/' + filename for filename in filelist])
    infos = []
    for filename in filelist:
        create, modify, access, size = info('upload/' + filename)
        fileinfo = {
            'name':filename,
            'create':create,
            'modify':modify,
            'size':size
        }
        infos.append(fileinfo)
    return render_template('home.html',
                           form  = form,
                           infos = infos)

@app.route('/download/<filename>')
def download_file(filename):
  return send_file('upload/'+filename,
                   as_attachment=True) # 브라우저에서 파일이 열리지 않고 다운로드만

@app.route('/del/<filename>')
def del_file(filename):
  os.remove('upload/'+filename)
  #return redirect(url_for('main_page')) # url_for('main_page')='/'
  return redirect('/')

if __name__ == '__main__':
    app.run(debug = True)
    


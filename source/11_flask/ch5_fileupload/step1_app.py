from flask import Flask, render_template, request
# 파일 첨부 시, 서버에 영향을 미칠 수 있는 파일명 내 특수 문자에 관여
from werkzeug.utils import secure_filename
import os

# 업로드 폴더 경로 설정(폴더 없으면 생성)
UPLOAD_FOLDER = './upload/'
if not os.path.exists(UPLOAD_FOLDER):
    print('폴더 생성함')
    os.makedirs(UPLOAD_FOLDER)

app = Flask(__name__)
# 파일 업로드 용량 제한(단위:byte)
# 용량 제한이 없을 경우
# 서버에서 매우 큰 용량을 업로드 할 경우, 403 Error
# print(app.config)
app.config['MAX_CONTENT_LENGTH'] = 1024*1024*10 # 최대 업로드 용량

# 파일 첨부는 반드시 'POST' 방식으로만 전달 가능
@app.route('/', methods = ['get', 'post']) # 대소문자 가능
def upload_file():
    if request.method == 'POST':
        '''
        파라미터로 전달받은 파일을 upload 폴더에 저장하고 완료 페이지로 가기
        '''
        f = request.files['file']
        # 파일명 내 서버에 영향을 미칠 문자가 포함된 경우 "_"로 교체
        safe_filename = secure_filename(f.filename)
        # 파일 저장
        f.save(UPLOAD_FOLDER + safe_filename)
        return render_template("check.html")
    return render_template("upload.html")

if __name__ == "__main__":
    app.run(debug = True)
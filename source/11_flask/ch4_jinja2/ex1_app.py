# Jinja2 템플릿 문법
from operator import length_hint

# 1. 변수 표기
# {{ var }} 또는 {{var: filter}}
# 기본 제공 필터: lower, upper, title(첫 글자만 대문자), length, trim
#               {{number|int}} (형변환)

# 2. 제어 구조 {% .. %}

# 2-1. if
# {% if 조건 %} A 태그 {% elif 조건 %} B 태그 {% else %} C태그 {% endif %}

# 2-2. for
# {% for var in vars %} # vars는 나열 가능한 데이터 구조 ex) range(1, 10)
#   <태그>{{loop.index}} - {{var}}</태그>
#       loop 변수를 태그 안에서 사용 가능한 것이 특징
#       loop.index: 1부터 인덱스 /  loop.index0: 0부터 인덱스 
#       loop.first: 첫 번째면 True / loop.last: 마지막이면 True
# {% endfor %}

# 3. 주석
# {# Jinja2 주석 #}
# <!--HTML 주석-->

# 4. header나 footer include: {% include "header.html" %}

from flask import Flask, render_template, request
app = Flask(__name__,
            # templates, static 폴더명 변경 가능하나 변경하는 경우가 극히 드물다
            template_folder = "templates",
            static_folder = "static")
lst = []

@app.route('/', methods = ["get", "post"])
# name = request.args.get('name')   # get방식 파라미터값
def index():
    if request.method == 'GET':
        name = None
    else:
        name = request.form["name"].strip()  # post방식 파라미터 값 # strip: 공백 제거
    length = 0
    if name:
        lst.append(name)
        length = len(name)
    price = 12000
    return render_template("1_index.html",
                           name   = name,
                           length = length,
                           names  = lst,
                           price  = price)
 
# 예외처리 페이지와 로깅
# Not Found 등의 에러 대비
@app.errorhandler(404)
def page_not_fount(error):
    # 특정 에러 코드 발생 시 출력할 에러메시지를 로깅으로
    app.logger.error("없는 페이지입니다")
    # 에러 시 띄울 html 창
    return render_template("page_not_found.html"), 404 # 콘솔에 404 출력

if __name__ == "__main__":
    app.run(debug = True)

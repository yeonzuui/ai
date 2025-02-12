from django.shortcuts import render
from django.http import HttpResponse, HttpRequest

# Create your views here.
def index(request):
    context = {'msg':'WordCount Welcome Page',
               'greeting':'Hello, Django(장고)',}
    return render(request       = request,
                  template_name = 'home/index.html',
                  context       = context)

def test(request):
    return HttpResponse('''<h1>테스트 페이지</h1>
            <button onclick="location='/'">뒤로가기</button>
    ''')

# ★ urls.py의 요청경로와 똑같이 파라미터명 지정
def showIntId(request:HttpRequest, id:int):
    # 자바는 str + int 가능한데, 파이썬은 불가능
    msg     = "숫자 ID는 " + str(id)
    id_type = '숫자입니다'
    return render(request,
                  'home/showId.html',
                  {'msg':msg,
                          'type':id_type})

# Type Hint는 기본적으로 Str, 생략 가능
def showStrId(request:HttpRequest, id:str):
    msg = '문자 ID는 ' + id
    id_type = '문자입니다'
    return render(request,
                  'home/showId.html',
                  {'msg':msg,
                          'type':id_type})

from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.
def wordinput(request):
    return render(request,
                  'wordcnt/wordinput.html')

def about(request):
    return render(request,
                  "wordcnt/about.html")

def result(request):
    # POST 방식으로 전달될 fulltxt 파라미터 받아 글자수, 단어수, 단어당 출현 빈도 계산
    # print(request.POST['fulltxt'], request.POST.get('fulltxt', ''))
    #                                fulltxt 내용 없으면 빈 스트링 대체
    # fulltxt    = request.POST['fulltxt']
    
    # GET 방식으로 변경
    fulltxt = request.GET['fulltxt']
    # fulltxt = request.GET.get['fulltxt', '']
    str_length = len(fulltxt)    # 글자수
    words      = fulltxt.split() # space 단위로 단어 분리 ['홍', '홍', '화이팅']
    wordcnt    = len(words)      # 단어 개수
    words_dic  = dict()          # 빈 딕셔너리
    for word in words:
        if word in words_dic.keys(): # 앞에서 출현했던 단어
            words_dic[word] += 1
        else:
            words_dic[word] = 1
    context = {
        'fulltxt'   : fulltxt,
        'str_length':str_length,
        'wordcnt'   :wordcnt,
        'dict'      :words_dic.items()
    }
    return render(request,
                  "wordcnt/result.html",
                  context)
# wordcnt/ 경로만 모아놓은 파일
# ch02 패키지 안의 urls 모듈로 연결됨
# :는 '밑에'라는 뜻
# /wordcnt    (name = wordcnt:wordinput) 단어 입력
# /wordcnt/about (name = wordcnt:about) 도움말
# /wordcnt/result (name = wordcnt:result) 결과

from django.urls import path
from wordcnt import views # wordcnt 안의 views
app_name = 'wordcnt'      # 경로명 복잡해지는 것 방지, wordcnt:wordinput

urlpatterns = [
    path('', views.wordinput, name = "wordinput"),
    path('about/', views.about, name = "about"),
    path('result/', views.result, name = "result"),
]
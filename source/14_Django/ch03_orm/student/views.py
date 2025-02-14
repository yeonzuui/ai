from django.shortcuts import render
from student.models import Student

# Create your views here.
def index(request):
    # 테이블 전체 읽기
    students = Student.objects.all()
    return render(request,
                  'student/list.html',
                  {'students':students})
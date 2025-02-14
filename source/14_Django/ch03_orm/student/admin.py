from django.contrib import admin
from student.models import Student

# Register your models here.
admin.site.register(Student) # admin 페이지에서 Student 테이블 확인 용도

 # [python manage.py makemigrations] 변경사항이 있는지 models 검색



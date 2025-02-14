from django.db import models

# Create your models here.

class Student(models.Model): # 테이블명: 앱명_클래스명(student_student)
    id    = models.AutoField(primary_key = True)
    name  = models.CharField(max_length = 100, unique = True)
    major = models.CharField(max_length = 100, null = True)
    age   = models.IntegerField(default = 0)
    grade = models.IntegerField(default = 1)
    def __str__(self):
        return "{}. {} ({} {}학년 {}살)".\
            format(self.id, self.name, self.major, self.grade, self.age)

# create
# [python manage.py shell]
# from student.models import Student
# st = Student(name='kim', major='computer', age=21, grade=2)
# st.save()

# read
# qs = Student.object.all() # 테이블 전체 읽기
# for student in qs:        # for문 이용한 출력
#     print(student)
# qs[0], qs[1]
# qs = Student.objects.order_by('name') # 이름순
# qs = Student.objects.order_by('-age') # 나이순(내림차순)
# qs = Student.objects.get(name='oh')   # 조건(이름이 '오')
# print(qs)

# 필터로 read
# qs = Student.objects.filter(name__contains='o') # 이름에 'o'포함
# qs = Student.objects.filter(name__contains='o')
# qs = Student.objects.filter(age__lt = 30) # 30살 미만
# qs = Student.objects.filter(age__lte = 30) # 30살 이하
# qs = Student.objects.filter(grade__gt = 3) # 3학년 초과

# update
# qs = Student.objects.get(name = 'oh')
# qs.major = 's/w'
# qs.grade = 7
# qs.save()

# delete
# qs = Student.objects.get(id = 5)
# qs.delete()



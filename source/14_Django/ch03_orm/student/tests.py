from django.test import TestCase
from student.models import Student

# Create your tests here.
st = Student(name  = 'kim',
             major = 'ai',
             age   = 22,
             grade = 3)
st.save()
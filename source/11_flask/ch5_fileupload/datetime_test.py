# 날짜/시간형 데이터를 원하는 format으로 출력
# Python, Jinja2
import datetime
dt = datetime.datetime.now()
print(dt)
print(dt.year)
print(dt.month)
print(dt.day)
print(dt.hour)
print(dt.minute)
print(dt.second)

# strftime(): 원하는 스타일로 출력
print(dt.strftime("%Y-%m-%d"))
print(dt.strftime("%H:%M:%S"))
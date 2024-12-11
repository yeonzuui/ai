import schedule
import time

def job():
    print('작업이 실행되었습니다.')
    

schedule.every(10).seconds.do(job)

while True:
    schedule.run_pending()
    time.sleep(1)
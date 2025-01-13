# 특정 폴더(upload/) 내 파일들의 정보
import os
import datetime
from distutils.archive_util import make_tarball


# ms → datetime 형으로 변환
def stamp2real(stamp):
    'stamp(1970.01.01 ~ 특정 시점까지의 초수)를 입력받아 특정 시점을 가독성 높은 문자로 변환'
    return datetime.datetime.fromtimestamp(stamp)

# 파일 정보를 return
def info(filename):
    '''
    파일 생성 시각, 마지막 수정 시간, 마지막 액세스 시간, 파일 사이즈를 return
    단위는 밀리세컨
    '''
    ctime = os.path.getctime(filename)
    mtime = os.path.getmtime(filename)
    atime = os.path.getatime(filename)
    size  = os.path.getsize(filename)
    return ctime, mtime, atime, size

# upload 파일 안에 들어있는 리스트
filelist = os.listdir('./upload/')
# print(filelist)

for filename in filelist:
    ctime, mtime, atime, size = info('./upload/' + filename)
    print('파일명:', filename)
    print('파일 생성 시각:', stamp2real(ctime))
    print('파일 수정 시각:', stamp2real(mtime))
    print('파일 접근 시각:', stamp2real(atime))
    # size(단위:byte)가 1MB 이하
    if size <= 1000000:
        # KB 단위로 표시, 소수점 둘째 자리까지
        print("{:.2f}KB".format(size/1024))
    else:
        # MB 단위로 표시, 소수점 둘째 자리까지
        print("{:2f}MB".format(size/ (1024*1024) ))
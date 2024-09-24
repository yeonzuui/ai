-- scott2 화면 --
SELECT * FROM TAB; -- 테이블 확인
SELECT * FROM USER_TABLES; -- 현 계정이 가지고 있는 테이블들

SELECT * FROM ALL_TABLES WHERE TABLE_NAME = 'EMP'; -- 가지고 있지 않지만 접근 가능한 테이블들
SELECT * FROM scott.EMP;
EXIT; -- 빠져나가기









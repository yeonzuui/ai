-- [IV] 단일행함수
-- 함수 = 단일행함수(4장) + 그룹함수(5장)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD HH24:MI:SS') FROM EMP; -- 단일행 적용

SELECT AVG(SAL) FROM EMP; -- 그룹함수(INPUT 14행 -> OUTPUT 1행)
--싱글라인필드와 그룹함수 같이 사용 불가
SELECT DEPTNO, AVG(SAL) FROM EMP; -- INPUT N행 -> OUTPUT 1행
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;

-- ★ 단일행함수 = 숫자관련함수, 문자관련함수, 날짜관련함수, 형변환함수, NVL, etc..
-- 1. 숫자 관련 함수
    -- DUAL테이블: 오라클에서 제공한 1행1열짜리 DUMMY TABLE
SELECT * FROM DUAL;
DESC DUAL;
SELECT FLOOR(34.567) FROM DUAL; --소수점에서 내림(버림)
SELECT FLOOR(34.567*10)/10 FROM DUAL; --정수/정수=>실수
SELECT TRUNC(34.567, 1) FROM DUAL;
SELECT TRUNC(34.567, -1) FROM DUAL;
    -- EX. EMP에서 이름, 급여(십의 자리에서 내림)
    SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;
SELECT CEIL(34.567) FROM DUAL; --소수점에서 올림
SELECT ROUND(34.567) FROM DUAL; --소수점에서 반올림
SELECT ROUND(34.567, 2) FROM DUAL; --소수점 두자리에서 반올림
SELECT ROUND(34.567, -1) FROM DUAL; --일의 자리에서 반올림
SELECT MOD(9,2) FROM DUAL; --9/2의 나머지
    -- 홀수년도에 입사한 사원의 모든 정보 출력
    SELECT * FROM EMP
        WHERE MOD(TO_CHAR(HIREDATE, 'RR'), 2) = 1;
-- 2. 문자 관련 함수
-- (1) 대소문자 관련
SELECT UPPER('abcABC') FROM DUAL; --대문자로
SELECT LOWER('abcABC') FROM DUAL; --소문자로
SELECT INITCAP('welcom to oracle') FROM DUAL; -- 어절의 첫 문자만 대문자
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL; -- 어절의 첫 문자만 대문자
    -- EX. 이름이 SCOTT인 직원의 모든 필드
    SELECT * FROM EMP WHERE UPPER(ENAME)='SCOTT';
    SELECT * FROM EMP WHERE INITCAP(ENAME) = 'Scott';
    SELECT * FROM EMP WHERE LOWER(ENAME) = 'scott';
-- (2) 문자 연결(CONCAT 함수, || 연산자)
SELECT 'AB' || 'CD' || 'EF' || 'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB', 'CD'), CONCAT('EF', 'GH')) FROM DUAL;
    -- "SMITH는 MANAGER다" 포맷으로 EMP 테이블 데이터를 출력
    SELECT ENAME || '는 ' || JOB || '다' FROM EMP;
    SELECT CONCAT(CONCAT(ENAME, '는 '), CONCAT(JOB, '다')) FROM EMP;
-- (3) SUBSTR(STR, 시작위치, 문자갯수): STR을 시작위치부터 문자갯수만큼 문자 추출
--     SUBSTRB(STR, 시작바이트위치, 바이트갯수): STR을 시작부터 바이트갯수만큼 문자 추출
                    --  O R A C L E
                    --  1 2 3 4 5 6
                    -- -6-5-4-3-2-1
SELECT SUBSTR('ORACLE', 4, 2) FROM DUAL;
SELECT SUBSTRB('ORACLE', 4, 2) FROM DUAL;
SELECT SUBSTR('데이터베이스', 4, 2) FROM DUAL;
SELECT SUBSTRB('데이터베이스', 4, 3) FROM DUAL; --한글은 3byte
    -- 9월에 입사한 사원의 모든 필드 (날짜형 표기 'RR/MM/DD')
    SELECT * 
        FROM EMP 
        WHERE SUBSTR(HIREDATE, 4, 2) = '09'; --DATE(날짜)형도 가능
    DESC EMP; -- 데이터 구조 확인
    -- 9일에 입사한 사원의 모든 필드
    SELECT * 
        FROM EMP
        WHERE SUBSTR(HIREDATE, 7, 2) = '09';
    SELECT * 
        FROM EMP
        WHERE SUBSTR(HIREDATE, -2, 2) = '09';

-- (4) LENGTH(STR) : STR의 글자
--     LENGTHB(STR) : STR의 바이트 수
SELECT LENGTH('ABCD') FROM DUAL; --글자수
SELECT LENGTHB('ABCD') FROM DUAL; --저장될 바이트 수
SELECT LENGTH('오라클'), LENGTHB('오라클') FROM DUAL;

-- (5) LPAD(STR, 자리수, 채울 문자): STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울 문자로 출력
--     LPAD(STR, 자리수): STR을 자리수만큼 확보하고, 왼쪽 빈자리에 ' '로 출력
--     RPAD(STR, 자리수, 채울 문자): STR을 자리수만큼 확보하고 오른쪽 빈자리에 채울 문자로 출력
--     RPAD(STR, 자리수): STR을 자리수만큼 확보하고, 오른쪽 빈자리에 ' '로 출력
SELECT LPAD('ORACLE', 10, '#') FROM DUAL;
SELECT LPAD('ORACLE', 10) FROM DUAL;
    -- ENAME: 최장 10글자, SAL: 5자리.2자리
SELECT ENAME, SAL FROM EMP; --문자는 왼쪽정렬, 숫자는 오른쪽
SELECT LPAD(ENAME, 11, '-'), LPAD(SAL, 5, '$') FROM EMP;
    -- EX. 사번, 이름 (7369 S**** / 1111 W*** ... / 2222 M*****) - RPAD, SUBSTR, LENGTH
    SELECT EMPNO,
            RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME)-1, '*') ENAME
        FROM EMP;
    -- EX. 사번, 이름, 직책(9자리 확보), 입사일
    --      7369 Smith ____****K 80/12/**
    --      7566 Jones ___*****R 81/02/**
    SELECT  EMPNO, 
            INITCAP(ENAME) ENAME, 
            LPAD(LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB)-1, '*'), 9) JOB,
--          SUBSTR(HIREDATE, 1, 6) || '**' HIREDATE
            TO_CHAR(HIREDATE, 'RR/MM/') || '**' HIREDATE
        FROM EMP;
-- (6) INSTR(STR, 찾을문자): STR에서 찾을문자가 첫번째로 나오는 위치(처음1, 없으면0)
--     INSTR(STR, 찾을문자, 시작위치): STR의 시작위치부터 찾을 문자가 나오는 위치
SELECT INSTR('ABCABCABC', 'B'), 
       INSTR('ABCABCABC', 'B', 3) 
    FROM DUAL; 
    -- EX. 9월에 입사한 사원의 모든 필드 (날짜 RR/MM/DD)
    SELECT * 
        FROM EMP 
        WHERE INSTR(HIREDATE, '09', 4) = 4;
    SELECT * 
        FROM EMP
        WHERE SUBSTR(HIREDATE, 4, 2) = '09';
    SELECT * 
        FROM EMP
        WHERE HIREDATE LIKE '__/09/__';
    -- EX. 9일에 입사한 사원의 모든 필드
    SELECT * 
        FROM EMP
        WHERE INSTR(HIREDATE, '09', 7) = 7;
    SELECT * 
        FROM EMP
        WHERE SUBSTR(HIREDATE, 7, 2) = '09';
    SELECT * 
        FROM EMP
        WHERE HIREDATE LIKE '%/09';
    -- EX. 9일이 아닌 날에 입사한 사원의 모든 필드
    SELECT * 
        FROM EMP
        WHERE INSTR(HIREDATE, '09', 7) = 0;
    SELECT * 
        FROM EMP
        WHERE SUBSTR(HIREDATE, 7, 2) != '09';
    SELECT * 
        FROM EMP
        WHERE HIREDATE NOT LIKE '%/09';
-- (7) 여백제거: TRIM(STR), LTRIM(STR), RTRIM(STR)
SELECT TRIM('   ORACLE  ') MSG FROM DUAL;
SELECT LTRIM('   ORACLE  ') MSG FROM DUAL;
SELECT RTRIM('   ORACLE  ') MSG FROM DUAL;

-- (8) REPLACE(STR, '바꿔야할문자', '바꿀문자')
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(SAL, 0, 'X') FROM EMP; --숫자도 바꿀 수 있어
SELECT REPLACE(HIREDATE, 0, 'X') FROM EMP; --날짜도 바꿀 수 있어

-- 3. 날짜 관련 함수 및 예약어
-- (1) SYSDATE: 지금 
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'RR/MM/DD HH:MI') FROM DUAL;
-- (2) 날짜 계산: 오라클 기본 타입(문자, 숫자, 날짜) 중 숫자, 날짜 타입은 연산 가능
SELECT 
        TO_CHAR(SYSDATE, 'RR/MM/DD HH:MI'),
        TO_CHAR(SYSDATE+1, 'RR/MM/DD HH:MI') --내일 이시간
    FROM DUAL;
    -- 개강시점(24/08/26 09:30)부터 현재(24/09/19 11:48)까지 며칠 지났나?
    SELECT 
            TRUNC(SYSDATE-TO_DATE('24/08/26 09:30', 'RR/MM/DD HH24:MI'))
        FROM DUAL;
    -- 현재부터 수료까지 며칠 남았나?
    SELECT 
            TRUNC(TO_DATE('25/03/07 18:00', 'RR/MM/DD HH24:MI')-SYSDATE)
        FROM DUAL;
    -- EMP에서 이름, 입사일, 근무일수
    SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) FROM EMP;
    SELECT ENAME, HIREDATE, TRUNC(TRUNC(SYSDATE-HIREDATE)/7) FROM EMP; --몇주 지났나
    -- EMP에서 이름, 입사일, 근무일수, 근무주수, 근무년수
    SELECT ENAME, HIREDATE,
           TRUNC(SYSDATE-HIREDATE) DAY,
           TRUNC( (SYSDATE-HIREDATE) /7) WEEK,
           TRUNC( (SYSDATE-HIREDATE) /365) YEAR
        FROM EMP;
-- (3) MONTHS_BETWEEN(날짜형1, 날짜형2): 두 날짜형 데이터 간 개월수 (날짜형1이 큰 시점)
    -- EX. 이름, 입사일, 근무월수
    SELECT ENAME, HIREDATE,
            TRIM(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))) MONTH
        FROM EMP;
    -- EX. 수료시점까지 남은 개월수
    SELECT 
        TRUNC(MONTHS_BETWEEN(TO_DATE('25/03/07 18:00', 'RR/MM/DD HH24:MI'), 
                            SYSDATE), 2)
        FROM DUAL;
-- (4) NEXT_DAY(특정시점, '토'): 특정시점부터 처음 돌아오는 토요일
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;

-- (5) ADD_MONTHS(특정시점, 개월수): 특정시점부터 몇개월 후
SELECT ADD_MONTHS(SYSDATE, 1) FROM DUAL;
    -- EX. 이름, 입사일, 수습종료기간(수습기간은 입사일로부터 6개월까지)
    SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) "수습종료"
    FROM EMP;
    -- 입사일을 8월 31일로 하면 6개월 후는 2월 28일
    INSERT INTO EMP VALUES (9999, '홍길동', NULL, NULL, '80/08/31', 900, NULL, 40);
    SELECT * FROM EMP;
    ROLLBACK; --DML언어(데이터입력, 수정, 삭제) 취소
-- (6) LAST_DAY(특정시점): 특정시점의 말일(28, 29, 30, 31)
SELECT LAST_DAY(SYSDATE) FROM DUAL;
    -- EX. 이름, 입사일, 첫월급날(말일)
    SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "월급날" FROM EMP;
-- (7) ROUND(날짜, XX): 날짜 반올림(XX: 'YEAR', 'MONTH', 'DAY', 생략)
--     TRUNC(날짜, XX): 날짜 버림
SELECT TO_CHAR(ROUND(SYSDATE), 'MM/DD HH24:MI') -- 가까운 0시 0분
    FROM DUAL; 
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL; --가까운 일요일
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL; --가까운 1일
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; --가까운 1월 1일

SELECT TO_CHAR(TRUNC(SYSDATE), 'MM/DD HH24:MI') -- 오늘 0시 0분
    FROM DUAL; 
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL; --지난 일요일
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL; --이번달 1일
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; --올해 1월 1일
    -- EX. 이름, 입사일, 첫월급날(16일)
    SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+15 "월급날"
        FROM EMP;
    -- EX. 이름, 입사일, 첫월급날(15일): ROUND 기준 15/16을 14/15로
    SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH')+14 월급날 
        FROM EMP;
    -- EX. 이름, 입사일, 첫월급날(12일): ROUND 기준 15/16을 11/12로
    SELECT ENAME, HIREDATE, ROUND(HIREDATE+4, 'MONTH')+12 월급날
        FROM EMP;
    -- EX. 이름, 입사일, 첫월급날(25일): ROUND 기준 15/16을 24/25로
    SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 월급날
        FROM EMP;
        
-- 4. 형변환 함수 
-- TO_CHAR: 문자로 변환시키는 함수
-- TO_DATE: 날짜형으로 변환시키는 함수
-- TO_NUMBER: 숫자로 변환시키는 함수
-- (1) TO_CHAR(날짜형, '출력형식')
--     YYYY 년도 4자리 / RR 년도 2자리 / MM 월 / DD 일 / DY 목 / DAY 목요일
--     HH24 / HH12 / HH (12시간) / MI 분 / SS 초 / AM 오전/오후
--     출력형식에 문자를 포함할 경우 ""
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY/MM/DD DAY AM HH24:MI:SS') 
    FROM EMP;
SELECT ENAME, TO_CHAR(HIREDATE, 'RR"년"MM"월"DD"일" DY"요일" AM HH"시"MI"분"SS"초"')
    FROM EMP;
-- (2) TO_CHAR(숫자, '출력형식')
    -- 0: 자릿수. 출력형식의 자릿수가 많으면 0으로 채움
    -- 9: 자릿수. 출력형식의 자릿수가 많아도 숫자만큼 출력
    -- ,: 세자리마다 콤마
    -- .: 소수점
    -- $: 통화단위 달러
    -- L: 지역통화단위로 출력
SELECT TO_CHAR(SAL, 'L99,999')SAL변형1 FROM EMP; 
SELECT TO_CHAR(SAL, 'L00,000')SAL변형2 FROM EMP;
SELECT TO_CHAR(1234.56, '9,999.9')SAL변형3 FROM EMP; -- 소수점 자리가 부족할 경우 반올림
-- (3) TO_DATE(문자, '패턴')
    -- EX. 81/5/1 ~ 83/5/1 사이에 입사한 사원의 모든 필드
    SELECT * FROM EMP
        WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '81/05/01' AND '81/05/02';
    SELECT * FROM EMP
        WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD') AND
                            TO_DATE('83/05/01', 'RR/MM/DD');
    ALTER SESSION SET NLS_DATE_FORMAT = "YYYY-MM-DD"; --날짜 표기법 셋팅                        
-- (4) TO_NUMBER(문자, '패턴')
SELECT TO_NUMBER('3,456', '9,999') + 1  FROM DUAL;

-- 5. NVL(NULL일 수도 있는 데이터, NULL이면 대신할 값) - 매개변수 2개의 타입 일치
    -- EX. 사원이름, 직속상사이름(직속상사가 없으면 CEO 출력)
    SELECT W.ENAME, NVL(M.ENAME, 'CEO') "MANAGER(없으면 CEO)" 
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO(+);
    -- EX. 사원이름, 직속상사의 사번(직속상사가 없으면 CEO 출력)
    SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') "상사사번(없으면 CEO)" FROM EMP; 
    
-- (6). ETC
-- (1). EXTRACT: 날짜형 데이터에서 년도, 월, 일만 추출하고자 할 때
SELECT HIREDATE, EXTRACT(YEAR FROM HIREDATE) "연도(숫자)" FROM EMP; -- 년도만 추출(숫자로)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY')"연도(문자)" FROM EMP; -- 년도만 추출(문자로)
SELECT HIREDATE, EXTRACT(MONTH FROM HIREDATE)"월(숫자)" FROM EMP; -- 월만 추출(숫자로)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'MM')"월(문자)" FROM  EMP; -- 월만 추출(문자로)
SELECT HIREDATR, EXTRACT(DAY FROM HIREDATE) "일(숫자)" FROM EMP; -- 일만 추출(숫자로)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'DD') "일(문자)" FROM EMP; -- 일만 추출(문자로)
-- (2) 계층별 출력
SELECT * FROM EMP; -- 계층없이 출력 
SELECT LEVEL, EMP.* FROM EMP
    START WITH MGR IS NULL -- 1레벨 정의
    CONNECT BY PRIOR EMPNO=MGR
    ORDER BY LEVEL;
SELECT LEVEL, LPAD('└ ', LEVEL*2)|| ENAME "계층별 출력" FROM EMP 
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR
    ORDER BY LEVEL;

-- <총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT TO_CHAR(SYSDATE, 'RR/MM/DD AM HH:MI') "Current Date"
    FROM DUAL;
    
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15 INCREASE
    FROM EMP;

--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT EMPNO, HIREDATE,
        NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월')AFTER6MONTH
    FROM EMP;

--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT EMPNO, HIREDATE, 
        TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH,
        SAL,
        SAL * TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) SUMSAL
        FROM EMP;
-- 가독성 높게 바꾸기
SELECT EMPNO, HIREDATE, 
        TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH,
        SAL,
        TO_CHAR(SAL * TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)), '$99,999,999') SUMSAL
        FROM EMP;
        
--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL, 15, '*') SECRETSAL
    FROM EMP;
    
--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, 
        TO_CHAR(HIREDATE, 'DAY')
    FROM EMP;
    
--7. 이름의 길이가 6자 이상인 사원의 정보를 이름, 이름의 글자수, 업무를 출력
SELECT ENAME, LENGTH(ENAME) "NAMELEN", JOB
    FROM EMP
    WHERE LENGTH(ENAME) >= 6;
    
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, NVL(COMM,0), SAL+NVL(COMM,0)FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;

--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있음을 고려하자 YYYY-MM-DD
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE EXTRACT(MONTH FROM HIREDATE)= 12;

SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE INSTR(HIREDATE, '12', 6)= 6;
    
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE SUBSTR(HIREDATE, 6, 2)= '12';
    
SELECT EMPNO, ENAME, HIREDATE 
    FROM EMP
    WHERE HIREDATE LIKE '%-12-__';
    
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO   ENAME	급여
--7369	    SMITH	*******800
--7499	    ALLEN	******1600
--7521	    WARD	******1250
--……. 
SELECT 
        RPAD(EMPNO, 5) EMPNO,
        ENAME,
        LPAD(SAL, 10, '*') "급여"
    FROM EMP;
    
-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO ENAME 입사일
-- 7369	  SMITH	  1980-12-17
-- ….
SELECT EMPNO, ENAME, 
        TO_CHAR(HIREDATE, 'YYYY-MM-DD') "입사일"
    FROM EMP;
    
--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB,
        TO_CHAR(SAL, '$99,999') SAL -- 5자리로 해야 안전
    FROM EMP
    WHERE DEPTNO = 20;

INSERT INTO EMP VALUES (1001, '제갈민', NULL, NULL, NULL, 90000, NULL, 20);
ROLLBACK; --DML문 취소 (데이터 삭제, 수정, 삽입)
SELECT * FROM EMP; --테이블 전체 출력
DESC EMP; --테이블구조






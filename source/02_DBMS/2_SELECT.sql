-- [II] SELECT문 - 조회

-- 1. SELECT 문 작성법(실행 : CTRL+ENTER / 블록잡고 F9)
SHOW USER; 
SELECT * FROM TAB; --현 계정이 갖고 있는 테이블들
SELECT * FROM EMP; --EMP테이블의 모든 열(필드), 모든 행
SELECT * FROM DEPT; -- DEPT테이블의 모든 열, 모든 행
SELECT * FROM SALGRADE;
-- 날짜 표기법 셋팅(RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = "RR/MM/DD";

-- 2. 특정 열만 출력
DESC EMP;
    -- EMP 테이블 구조
SELECT EMPNO, ENAME, SAL, JOB -- EMP테이블의 EMPNO, ENAME, SAL, JOB 필드만 모든 행
    FROM EMP;
SELECT EMPNO, ENAME, COMM 
    FROM EMP;
SELECT EMPNO AS "사 번", ENAME AS "이름", SAL AS "급여" --필드명에 별칭을 사용
    FROM EMP;
SELECT EMPNO "사 번", ENAME "이름", SAL "급여" -- 별칭에 AS 생략 가능 
    FROM EMP;
SELECT EMPNO "사 번", ENAME 이름, SAL 급여 -- 별칭에 SPACE 없는 경우 "" 생략 가능
    FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY
    FROM EMP;
SELECT EMPNO "NO", ENAME "NAME", SAL "SALARY"
    FROM EMP;
    
-- 3. 특정 행 출력: WHERE 절(조건절) -- 비교연산자: 같다(=), 다르다(!=, ^=, <>), < <= > >=
SELECT EMPNO 사번 , ENAME 이름, SAL 급여
    FROM EMP
    WHERE SAL = 3000;
SELECT * FROM EMP
    WHERE SAL<>3000;
SELECT * FROM EMP
    WHERE SAL!=3000;
SELECT * FROM EMP
    WHERE SAL^=3000;
    -- 비교연산자는 숫자, 문자, 날짜형 모두 가능
    -- 아스키코드 우선순위: 'A' < 'AA' < 'AAA' < 'AAAA' < 'AAAB' < 'B' < 'a'
    -- EX1. 사원이름이 'A','B','C'로 시작하는 사원의 모든 필드
    SELECT * FROM EMP 
        WHERE ENAME < 'D';
    -- EX2. 81년도 이전에 입사한 사원의 모든 필드
    SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
    ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
    
-- 4. 조건절에 논리연산자: AND, OR, NOT
    -- EX1. 급여(SAL)가 2000이상 3000이하인 직원의 모든 필드
    SELECT * FROM EMP WHERE SAL >= 2000 AND SAL <=3000;
    -- EX2. 82년도에 입사한 사원의 모든 필드(82/01/01 이상, 82/12/31 이하)
    SELECT * FROM EMP WHERE HIREDATE>='82/01/01' AND HIREDATE<='82/12/31';
    
    -- EX3. 연봉(SAL*12)이 2400이상인 직원의 ENAME, SAL, 연봉(ANNUALSAL)을 출력
    SELECT ENAME, SAL, SAL*12 AS "연봉" --(3)
        FROM EMP              -- (1)EMP있는지 확인
        WHERE SAL*12 >= 2400  -- (2)조건이 충족되면 buffer에 넣어, 필드로 연산
        ORDER BY 연봉;         -- (4)정렬, alias 써도 돼(SELECT 실행 이후니까)
    -- EX4. 10번부서(DEPTNO)이거나 JOB이 MANAGER인 직원의 모든 필드
    SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
    -- EX5. 10번 부서가 아닌 직원의 모든 필드
    SELECT * FROM EMP WHERE DEPTNO!=10;
    SELECT * FROM EMP WHERE NOT DEPTNO=10;
    
-- 5. 산술연산자(SELECT절, WHERE절, ORDER BY절)
SELECT EMPNO, ENAME, SAL, SAL*1.1 AS "UPGRADESAL" FROM EMP;
    -- EX. 모든 사원의 ENAME, SAL, COMM, 연봉(SAL*12 + COMM)을 출력
    SELECT ENAME, SAL, COMM, SAL*12 + COMM AS "연봉" FROM EMP; -- 산술연산결과는 NULL을 포함하면 결과도 NULL
    -- NVL(NULL일 수도 있는 값, NULL이면 대체할 값)
    SELECT ENAME, SAL, COMM, SAL*12 + NVL(COMM, 0) AS "ANNUALSAL" FROM EMP;
    -- MGR이 NULL이면 'CEO'라고 출력
    SELECT EMPNO, ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP; --NVL(타입 통일)
    DESC EMP;
    
-- 6. 연결연산자(||) : 필드나 문자를 연결
SELECT ENAME || '은' || JOB FROM EMP;
SELECT CONCAT(ENAME, JOB) "EMPLOYEE" FROM EMP; -- CONCAT(A,B): 두 개만 가능
    -- EX. 모든 사원에 대해 'SMITH : 연봉 = XXX' 포맷으로 출력(연봉=SAL*12+COMM)
    SELECT ENAME || ' : 연봉 = ' || (SAL*12+NVL(COMM,0)) "MESSAGE" 
        FROM EMP;
        
-- 7. 중복제거(DISTICNT)
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;

-- 8. SQL연산자 (BETWEEN, IN, LIKE, IS NULL)
-- (1) BETWEEN A AND B: A부터 B까지 (A와 B포함, A<B)
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE SAL >= 1500 AND SAL <= 3000;
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL BETWEEN 3000 AND 1500; -- 결과값 없음
    -- EX. SAL이 1500미만, 3000초과하는 직원의 모든 필드(NOT BETWEEN 사용)
    SELECT * FROM EMP 
        WHERE SAL < 1500 OR SAL > 3000;
    SELECT * FROM EMP 
        WHERE SAL NOT BETWEEN 1500 AND 3000; 
    -- EX. 82년도에 입사한 직원의 모든 필드
    SELECT * FROM EMP
        WHERE HIREDATE BETWEEN '82/02/01' AND '82/12/31';
    -- EX. 이름이 'A','B','C'로 시작하는 직원의 모든 필드
    SELECT * FROM EMP
        WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME != 'D';

-- (2) IN / NOT IN
    -- EX. 부서번호가 10, 20, 40번 부서인 직원의 모든 필드
    SELECT * FROM EMP
        WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40;
    SELECT * FROM EMP
        WHERE DEPTNO IN(10, 20, 40);
    -- EX. 부서번호가 10, 20, 40번을 제외한 부서의 직원들 모든 정보
    SELECT * FROM EMP
        WHERE DEPTNO NOT IN(10, 20, 40);
    SELECT 8 FROM EMP
        WHERE DEPTNO!=10 OR DEPTNO!=20 OR DEPTNO!=40;
    -- EX. 직책이 MANAGER이거나 ANALYST인 사원의 모든 필드
    SELECT * FROM EMP
        WHERE JOB IN('MANAGER','ANALYST');
        
-- (3) 필드 LIKE 포맷: %(0글자이상), _(한 글자)를 포함한 패턴
    -- EX. 이름이 M으로 시작하는 사원의 모든 필드
    SELECT * FROM EMP
        WHERE ENAME LIKE 'M%';
    -- EX. 이름에 N이 들어가는 사원의 모든 필드
    SELECT * FROM EMP
        WHERE ENAME LIKE '%N%'; -- 앞, 뒤, 중간 무관하게 포함
    -- EX. 이름에 N이 들어가거나 JOB에 N이 들어가는 사원의 모든 필드
    SELECT * FROM EMP
        WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%';
    -- EX. 이름이 S로 끝나는 사원의 모든 필드
    SELECT * FROM EMP
        WHERE ENAME LIKE '%S';
    -- EX. SAL이 5로 끝나는 사원의 모든 필드
    SELECT * FROM EMP
        WHERE SAL LIKE '%5';
    -- EX. 82년도에 입사한 사원의 모든 필드
    SELECT * FROM EMP
        WHERE HIREDATE LIKE '82/__/__';
    -- EX. 1월에 입사한 사원의 모든 필드
    SELECT * FROM EMP
        WHERE HIREDATE LIKE '__/01/__'; -- '%/01/%'도 상관없음
        
-- (4) IS NULL
    -- EX. COMM이 NULL인 사원의 모든 필드
    SELECT * FROM EMP
        WHERE COMM IS NULL;
    -- EX. COMM을 받지 않은 사원의 모든 필드
    SELECT * FROM EMP
        WHERE COMM IS NULL OR COMM=0;
    -- EX. COMM이 NULL이 아닌 사원
    SELECT * FROM EMP
        WHERE COMM IS NOT NULL;
    SELECT * FROM EMP
        WHERE NOT COMM IS NULL;

-- 9. 정렬(오름차순, 내림차순): ORDER BY 절
SELECT ENAME, SAL
    FROM EMP
    ORDER BY SAL; -- 급여 오름차순 정렬
SELECT ENAME, SAL
    FROM EMP
    ORDER BY SAL DESC; --급여 내림차순 정렬(두번째 정렬 기준은 INSERT 순서)
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    ORDER BY SAL DESC, HIREDATE; --급여 내림차순 정렬(두번째 정렬 기준은 HIREDATE 오름차순)
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    ORDER BY SAL DESC, HIREDATE DESC; --급여 내림차순 정렬(두번째 정렬 기준은 HIREDATE 내림차순)
SELECT * FROM EMP
    ORDER BY ENAME; -- 영어는 ABC순, 한글은 ㄱㄴㄷ순
SELECT ENAME, SAL*12 ANNUALSAL 
    FROM EMP
    ORDER BY ANNUALSAL;
    
SELECT * FROM EMP
    WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT;
    
-- 연습문제
--1. emp 테이블의 구조 출력
DESC EMP;

--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;

--3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;

--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;

--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL <= 2000;
    
--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE
    FROM EMP
    WHERE HIREDATE >= '81/02/01';
    
--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP
    WHERE JOB = 'SALESMAN';

--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP
    WHERE NOT JOB = 'CLERK';
    
--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE SAL >= 1500 AND SAL <= 3000;
    
--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE DEPTNO = 10 OR DEPTNO = 30;
    
--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE JOB = 'SALESAMAN' OR SAL >= 3000;
    
--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP
    WHERE SAL >= 2500 AND JOB = 'MANAGER';
    
--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
SELECT ENAME || '은 ' || JOB || ' 업무이고 연봉은 ' || (SAL*12+NVL(COMM,0)) || '다' AS "INTRODUCE"
    FROM EMP;

-- ★★★ <셤 연습문제> ★★★
--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
        SELECT EMPNO, ENAME, JOB, SAL 
            FROM EMP
            WHERE SAL>3000;
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
        SELECT ENAME, DEPTNO
            FROM EMP
            WHERE EMPNO = 7788;
--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
        SELECT EMPNO, ENAME, SAL
            FROM EMP
            WHERE SAL*12+NVL(COMM,0) >= 24000
            ORDER BY SAL;
--4.	입사일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 출력 (단 hiredate 순으로 출력)
        SELECT ENAME, JOB, HIREDATE
            FROM EMP
            WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01'
            ORDER BY HIREDATE;
--5.	deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
        SELECT * FROM EMP
            WHERE DEPTNO = 10 OR DEPTNBO = 20
            ORDER BY ENAME;
        SELECT * FROM EMP
            WHERE DEPTNO IN(10, 20)
            ORDER BY ENAME;
--6.	sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
        SELECT ENAME AS  "EMPLOYEE" , SAL AS "MONTHLY SALARY"
            FROM EMP
            WHERE SAL > = 1500 AND DEPTNO IN(10,30);
--7.	hiredate가 1982년인 사원의 모든 정보를 출력
        SELECT * FROM EMP
            WHERE HIREDATE LIKE '82/__/__'; --'82/%'도 가능
--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
        SELECT ENAME, SAL 
            FROM EMP
            WHERE (ENAME BETWEEN 'C' AND 'Q') AND ENAME != 'P';
--9.	comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 출력하는 SELECT 문을 작성
        SELECT ENAME, SAL, COMM
            FROM EMP
            WHERE COMM >= SAL*1.1;
--10.	job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
        SELECT * FROM EMP
            WHERE JOB = 'CLERK' OR JOB = 'ANALYST' AND SAL NOT IN(1000, 3000, 5000);
--11.	ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
        SELECT * FROM EMP
            WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782; --'%L%L%' 와일드카드
--12.	입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
        SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
            FROM EMP
            WHERE HIREDATE LIKE '81/__/__' ;
--13.	입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 업무, 급여를 검색하시오.
        SELECT EMPNO, ENAME, HIREDATE, JOB, SAL
            FROM EMP
            WHERE HIREDATE LIKE'81%'
--14.	사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.

--15.	사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오

--16.	사원명에 'A'가 들어간 사원의 사번, 사원명을 출력

--17.	연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.






    
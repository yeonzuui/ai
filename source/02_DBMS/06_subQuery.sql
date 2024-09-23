-- [VI] Sub Query : 메인 QUERY(SQL문) 안에 내포된 QUERY
-- ★ 1. 서브쿼리 개념과 종류
SELECT MAX(SAL) FROM EMP;
SELECT ENAME, SAL 
    FROM EMP   
    WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- VI. 서브쿼리(쿼리 안 쿼리)
-- F9 선택한 부분만 실행
-- 서브쿼리 종류(1) 단일행 서브쿼리: 서브쿼리 결과가 단일행: =, >, <, >=, <=, !=
    -- EX. SCOTT과 동일한 부서번호에서 근무하는 사원의 이름과 급여
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- 서브쿼리가 될 SQL문(실행되는지 확인)
    SELECT ENAME, SAL
        FROM EMP
        WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
-- 서브쿼리 종류(2) 다중행 서브쿼리: 서브쿼리 결과가 2행 이상: IN, >ALL, ANY(SOME), EXISTS
    -- EX. SCOTT이나 KING과 동일한 부서번호에서 근무하는 사원의 정보
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'KING';
    SELECT DEPTNO FROM EMP WHERE ENAME IN('SCOTT', 'KING'); -- 서브쿼리가 될 SQL문
    SELECT * FROM EMP 
        WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'KING'); --(10,20)
-- ★ 2. 단일행 서브쿼리
    -- EX1. SCOTT과 동일한 근무지(LOC)에서 근무하는 사원의 정보
    -- DEPT에 50번부서(DALLAS) INSERT, EMP에 50번 근무 직원 INSERT
    INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
    SELECT * FROM DEPT;
    SELECT * FROM EMP;
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES(1000, '홍길동', 50); -- 입력하지 않은 값은 NULL로 INSERT
    SELECT LOC FROM DEPT D, EMP E
        WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT'; -- 서브쿼리
    SELECT * FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO
            AND LOC = (SELECT LOC FROM DEPT D, EMP E
                            WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT')
            AND ENAME <> 'SCOTT';
    ROLLBACK;
    -- EX2. 최초입사일과 최초입사한 사람의 이름
    SELECT MIN(HIREDATE) FROM EMP; -- 단일행 서브쿼리
    SELECT HIREDATE FIRSTDATE, ENAME FIRST_EMP 
        FROM EMP
        WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); -- 메인쿼리
    -- EX3. 최근입사일과 최근입사한 사람의 정보
    SELECT HIREDATE LATEDATE, ENAME LATE_EMP    
        FROM EMP
        WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    -- EX4. 최초입사일, 최초입사자이름, 최근입사일, 최근입사자이름
    SELECT E1.HIREDATE FIRSTDATE, E1.ENAME FIRST_EMP, E2.HIREDATE LATEDATE, E2.ENAME LATE_EMP 
        FROM EMP E1, EMP E2
        WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)
            AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP); -- 메인쿼리
    -- SELECT문 안에 SELECT 넣기
    SELECT 
        (SELECT MIN(HIREDATE) FROM EMP) FIRSTDATE,
        (SELECT ENAME FROM EMP WHERE HIREDATE =(SELECT MIN(HIREDATE) FROM EMP)) FIRST_EMP,
        (SELECT MAX(HIREDATE) FROM EMP) LASTDATE,
        (SELECT ENAME FROM EMP WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP)) LAST_EMP
    FROM DUAL;
    -- EX5. SCOTT과 같은 부서에 근무하는 사람들의 급여합
    SELECT SUM(SAL) FROM EMP
        WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
    -- EX6. DALLAS에 근무하는 사원의 이름과 부서번호(서브쿼리, JOIN 무관)
    SELECT ENAME, DEPTNO
        FROM EMP
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'); --서브쿼리 이용
    SELECT ENAME, E.DEPTNO
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO
            AND LOC = 'DALLAS'; -- EQUI JOIN 이용
    -- EX7. 'KING'이 직속상사인 사원의 이름과 급여
    SELECT ENAME, SAL
        FROM EMP
        WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME= 'KING');
    SELECT W.ENAME, W.SAL
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO
            AND M.ENAME ='KING';
    -- EX8. 평균급여 이하로 받는 사원의 이름, 급여를 출력
    SELECT ENAME, SAL
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    -- EX9. 평균급여 이하로 받는 사원의 이름, 급여, 급여평균을 출력
    SELECT ENAME, SAL, (SELECT ROUND(AVG(SAL)) FROM EMP) "AVG_SAL"
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    -- EX10. 사원이름, 급여, 평균급여와의 차이
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)-SAL) "DIFFERANCE"
        FROM EMP;
    -- 단일행 다중열 서브쿼리
    -- EX. SCOTT과 JOB도 같고, 부서번호도 같은 직원의 모든 필드 출력
    SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- 서브쿼리
    SELECT * FROM EMP
        WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
        
-- ★ 3. 다중행 서브쿼리: IN, ALL, ANY(=SOME), EXISTS
-- (1) ALL: 서브쿼리 결과가 모두 만족하면 참
    -- EX. 30번 부서 직원의 모든 급여들보다 큰 직원의 모든 필드
    SELECT SAL FROM EMP WHERE DEPTNO = 30; -- 다중행 서브쿼리
    SELECT * FROM EMP WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30); -- 메인쿼리
    -- (= 30번 부서 최대 급여보다 큰 직원의 모든 필드)
    SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);
-- (2) ANY(=SOME): 서브쿼리 결과가 하나라도 만족하면 참
    -- EX. 30번 부서 직원 한 명(아무나)의 급여보다 큰 직원의 모든 필드
    SELECT SAL FROM EMP WHERE DEPTNO=30;
    SELECT * FROM EMP WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO=30);
    SELECT * FROM EMP WHERE SAL > SOME(SELECT SAL FROM EMP WHERE DEPTNO=30);
    -- (= 30번 부서 최소 급여보다 큰 직원의 모든 필드)
    SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);
-- (3) IN
    -- EX. 부서별로 입사일이 가장 늦은 사람의 이름, 입사일, 부서번호
    SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- 다중행 다중열 서브쿼리
    SELECT ENAME, HIREDATE, DEPTNO 
        FROM EMP 
        WHERE (DEPTNO, HIREDATE) IN(SELECT DEPTNO, MAX(HIREDATE) 
                                        FROM EMP 
                                        GROUP BY DEPTNO); -- 메인쿼리
        -- 급여를 3000이상 받는 사원이 소속된 부서 직원의 모든 필드
        SELECT * FROM EMP 
            WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE SAL >= 3000);
-- (4) EXISTS: 서브쿼리 결과가 존재하면 참
    -- EX. 직속부하가 있는 직원들의 사번, 이름, 급여
    SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO; -- SELF JOIN 이용
    SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
                        -- 읽어들인 EMP데이터의 EMPNO가 MGR에 존재하나?
        WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR); -- 서브쿼리 이용
    -- 직속부하가 없는 직원들의 사번, 이름, 급여
    SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
                        -- 읽어들인 EMP데이터의 EMPNO가 MGR에 존재하지 않는지?
        WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);
    SELECT M.EMPNO, M.ENAME, M.SAL
        FROM EMP W, EMP M
        WHERE W.MGR(+)= M.EMPNO AND W.ENAME IS NULL; -- SELF JOIN 이용

-- 탄탄1. 부서별로 가장 급여를 많이 받는 사원의 모든 정보를 출력(IN 연산자 이용)
-- 부서번호별 가장 큰 급여받는 사원
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; --서브쿼리
SELECT * FROM EMP
    WHERE (DEPTNO, SAL) IN(SELECT DEPTNO, MAX(SAL) 
                           FROM EMP GROUP BY DEPTNO)
    ORDER BY DEPTNO;

-- 부서번호별 가장 큰 급여받는 사원(DNAME, LOC, 급여등급 포함)
SELECT E.*, DNAME, LOC, GRADE 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO
        AND SAL BETWEEN LOSAL AND HISAL
        AND (E.DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO)
    ORDER BY E.DEPTNO;
	
-- 탄탄2. 직급(JOB)이 MANAGER인 사람의 속한 부서의 부서 번호와 부서명과 지역을 출력(IN)
SELECT DEPTNO, DNAME, LOC FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');
    
-- 탄탄3. 급여가 3000이상인 사람들 중 연봉 등급을 나누어서 해당 등급별 최고 급여를 받는 사람들의 사번, 이름, 직업, 입사일, 급여, 급여등급을 출력
SELECT GRADE, MAX(SAL)
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL 
        AND SAL >= 3000
    GROUP BY GRADE; -- 서브쿼리
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL)
                                FROM EMP, SALGRADE
                                WHERE SAL BETWEEN LOSAL AND HISAL 
                                    AND SAL >= 3000
                                GROUP BY GRADE)
    ORDER BY GRADE; -- 메인쿼리
    
-- 탄탄4. 응용심화 : 입사일 분기별로 가장 높은 급여를 받는 사람들의 분기, 사번, 이름, JOB, 상사사번, 입사일, 급여, 상여를 출력하세요
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP; --분기
SELECT CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUARTER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM FROM EMP; --분기
SELECT TO_CHAR(HIREDATE, 'Q') "QUARTER" FROM EMP; --분기

SELECT TO_CHAR(HIREDATE, 'Q') "QUARTER", MAX(SAL) 
    FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q'); --서브쿼리
SELECT  TO_CHAR(HIREDATE, 'Q') "QUARTER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM 
    FROM EMP
    WHERE (TO_CHAR(HIREDATE, 'Q'), SAL) IN (SELECT TO_CHAR(HIREDATE, 'Q') "QUARTER", MAX(SAL) 
                                                FROM EMP 
                                                GROUP BY TO_CHAR(HIREDATE, 'Q'))
    ORDER BY QUARTER; --메인쿼리
                                                
-- 탄탄5. 급여가 3000미만인 사람 중에 가장 최근에 입사한 사람의 사원번호와 이름, 급여, 입사일을 출력
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000);

-- 탄탄6. SALESMAN 모든 사원들 보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력하지 않는다.(ALL이용)
SELECT ENAME, JOB 
    FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');
-- = JOB이 SALESMAN인 사원들 최대 급여보다 많이 받는 사원 정보
SELECT ENAME, JOB
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN'); 
    
-- 탄탄7. SALESMAN 일부 어떤 한 사원보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원도 출력(ANY)
SELECT ENAME, JOB 
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');
-- = 단일행 서브쿼리 이용
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB = 'SALESMAN');
    
-- ★ 총 연습문제 (1~13번: 단일행서브쿼리)
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
    
-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);
    
-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
    
--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND SAL <= (SELECT AVG(SAL) FROM EMP);
SELECT*FROM SALGRADE; 
--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');
    
--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬
SELECT DNAME, ENAME, SAL, HIREDATE, GRADE
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
        AND E.DEPTNO = D.DEPTNO
    ORDER BY SAL DESC;
    
--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');
    
--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');
    
--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
    
--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);
        
--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND DNAME = (SELECT DNAME FROM DEPT WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='CLARK'))
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);
        
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO
         AND DNAME = (SELECT DNAME 
                    FROM EMP E, DEPT D 
                    WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK')
         AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);
         
--12. BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름 단 급여가 많은 순으로 출력)
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;

-- 여기서부터는 다중행서브쿼리와 단일행서브쿼리, 이전은 단일행서브쿼리
-- 14.  이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 직원의 사원 번호,이름,급여(단 사번 순 출력)
SELECT DEPTNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE UPPER(ENAME) LIKE '%T%')
    ORDER BY EMPNO;
    
-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여(INITCAP)
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE INITCAP(LOC) = 'Dallas');
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT
                        WHERE INITCAP(LOC) = 'Dallas'); -- EQUI JOIN 이용
-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여
SELECT ENAME, SAL
    FROM EMP
    WHERE ENAME IN (SELECT ENAME FROM EMP WHERE MGR = 7839);

SELECT ENAME, SAL 
    FROM EMP 
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE INITCAP(ENAME)='King');
    
-- 17. SALES부서 사원의 이름, 업무(UPPER)
SELECT ENAME, JOB
    FROM EMP 
    WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT
                        WHERE UPPER(DNAME) = 'SALES');
    
-- 18. 월급이 부서 30의 최저 월급보다 높은 사원의 모든 필드
SELECT * 
    FROM EMP 
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30); -- 단일행서브쿼리
SELECT * 
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- 다중행서브쿼리
    
-- 19.  FORD와 업무도 월급도 같은 사원의 모든 필드
SELECT *
    FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL FROM EMP 
                        WHERE UPPER(ENAME) = 'FORD')
        AND ENAME != 'FORD';
        
-- 20. 이름이 JONES인 직원의 JOB과 같거나 FORD의 SAL 이상을 받는 사원의 정보를 이름, 업무, 부서번호, 급여
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력
SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES')
        OR SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD') 
    ORDER BY ENAME, SAL DESC;
    
-- 21. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL 
                    FROM EMP 
                    WHERE UPPER(ENAME) IN ('SCOTT', 'WARD'))
        AND UPPER(ENAME) NOT IN ('SCOTT', 'WARD');
    
-- 22. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름, 업무
SELECT ENAME, JOB
    FROM EMP
    WHERE JOB IN (SELECT JOB 
                        FROM EMP E, DEPT D 
                        WHERE E.DEPTNO = D.DEPTNO 
                            AND UPPER(LOC) = 'CHICAGO');
                        
-- 23. 부서 평균 월급보다 월급이 높은 사원을 사번, 이름, 급여, 부서번호
-- 방법 1. EQUI JOIN과 FROM절의 서브쿼리를 이용
SELECT EMPNO, ENAME, SAL, E.DEPTNO --AVGSAL
    FROM EMP E, 
        (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) G --임시, 가상테이블 생성
    WHERE E.DEPTNO=G.DEPTNO
        AND SAL>AVGSAL;
-- 방법 2.        
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
    
-- 24. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여, (확인용 JOB, JOB평균)
SELECT DEPTNO, ENAME, SAL, JOB, ROUND((SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB)) AVGSAL 
    FROM EMP E
    WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB); -- EQUI JOIN과 FROM 절의 서브쿼리를 이용

SELECT DEPTNO, ENAME SAL, E.JOB --, AVGSAL
    FROM EMP E,
        (SELECT JOB, AVG(SAL) AVGSAL FROM EMP GROUP BY JOB)G
    WHERE E.JOB = G.JOB        
        AND SAL < AVGSAL;
        
-- 25. 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무, 이름, 사번, 부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS (SELECT * FROM EMP WHERE MGR = M.EMPNO)
    ORDER BY DEPTNO; --EXISTS 연산자 이용(서브쿼리)
    
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP 
    WHERE EMPNO IN (SELECT MGR FROM EMP)-- 서브쿼리 결과 : 7839, NULL, 7782, 7698, 7902, 7566, 7788
    ORDER BY DEPTNO;-- IN 연산자 이용(다중행 서브쿼리)
    
SELECT M.ENAME, M.JOB, M.EMPNO, M.DEPTNO
    FROM EMP M, EMP W
    WHERE M.EMPNO = W.MGR; -- SELF JOIN 이용
                            
-- 26.  말단 사원의 사번, 이름, 업무, 부서번호
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE ENAME IN (SELECT W.ENAME
                        FROM EMP W, EMP M
                        WHERE W.MGR = M.EMPNO);
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP E
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MGR=E.EMPNO);--EXISTS 연산자 이용(서브쿼리)

SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP
    WHERE NOT EMPNO IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL)-- 서브쿼리 결과 : 7839, NULL, 7782, 7698, 7902, 7566, 7788
    ORDER BY DEPTNO;-- IN 연산자 이용(다중행 서브쿼리)










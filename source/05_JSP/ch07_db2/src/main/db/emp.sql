--ch06_db프로젝트에서 쓸 query
--ex1 DEPT랑 join(사번, 이름, 직책, 상사사번, 입사일, 급여, 부서번호, 부서명)
SELECT * FROM EMP;
SELECT * FROM DEPT;

--ex2 입력받은 부서번호의 직원정보를 출력
-- select 태그내에 보여질 부서정보
SELECT DEPTNO, DNAME
    FROM DEPT; 
-- 10번 → 10번 부서 정보, "" → 모든 부서 정보(쿼리 2개 필요)
SELECT E.*, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO LIKE '%' || '10' AND E.DEPTNO = D.DEPTNO;

-- QUIZ: 사원명(일부 알파벳)으로 직원 검색 (TRIM, 대문자 변환)
SELECT E.*, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%'|| TRIM(UPPER('  s')) ||'%'; --'%s%'
    




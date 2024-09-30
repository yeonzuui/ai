-- com.lec.ex1selectAll
SELECT * 
    FROM EMP;

-- com.lec.ex2selectWhere
-- Ex1. 부서번호를 받아 부서정보를 출력
SELECT * FROM DEPT WHERE DEPTNO = 10;
INSERT INTO DEPT VALUES(50, 'IT', '서울');
SELECT * FROM DEPT;
COMMIT; -- 커밋해야 자바에 반영됨







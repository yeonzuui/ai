-- com.lec.ex1selectAll
SELECT * 
    FROM EMP;

-- com.lec.ex2selectWhere
-- Ex1. 부서번호를 받아 부서정보를 출력
SELECT * FROM DEPT WHERE DEPTNO = 10;
INSERT INTO DEPT VALUES(50, 'IT', '서울');
SELECT * FROM DEPT;
COMMIT; -- 커밋해야 자바에 반영됨

-- Ex2. 부서번호 입력 받아 부서 정보와 사원 정보 출력
SELECT * FROM DEPT WHERE DEPTNO = 10;
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME "MANAGER"
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = 10;

-- Ex3. 부서이름으로 부서번호 출력
SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER('sales'); -- DB, 사용자입력 모두 대문자로 변환

-- ★★★ com.lec.ex3insert ★★★
INSERT INTO DEPT 
    VALUES (60, UPPER('CS'), UPPER('PUSAN')); -- 자바는 1을 받음(1행 삽입)
rollback;

SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = 80; -- 1이면 INSERT 안 해(중복)
INSERT INTO DEPT 
    VALUES (60, UPPER('CS'), UPPER('PUSAN')); -- 자바는 1을 받음(1행 삽입)
rollback;

-- ★★★ com.lec.ex3update ★★★
UPDATE DEPT 
    SET DNAME = UPPER('marketing'),
        LOC   = UPPER('seoul')
    WHERE DEPTNO = 80; -- PRIMARY KEY는 수정 X
COMMIT;
SELECT * FROM DEPT WHERE DEPTNO = 80; -- 수정 확인

-- ★★★ com.lec.ex4update ★★★
SELECT * FROM DEPT WHERE DEPTNO = 80;
UPDATE DEPT 
    SET DNAME = UPPER('marketing'),
        LOC   = UPPER('seoul')
    WHERE DEPTNO = 80;

-- ★★★ com.lec.ex5delete ★★★
SELECT * FROM DEPT WHERE DEPTNO = 80;
DELETE FROM DEPT WHERE DEPTNO = 80;
COMMIT;

-- ★★★ com.lec.ex6preparedStatement ★★★
SELECT * FROM DEPT WHERE DNAME = UPPER('sales'); -- 부서명 받아 부서정보 출력
SELECT EMPNO, ENAME, SAL 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('sales')
    ORDER BY SAL;
    
select * from dept;
    


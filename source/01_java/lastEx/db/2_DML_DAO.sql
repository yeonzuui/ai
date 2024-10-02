-- DAO에 쓸 QUERY
-- 1번 기능과 2번 기능에서 입력 가능한 작업명들
-- (1) PERSON 정보 가져오는 함수: getPerson
SELECT * FROM PERSON;
-- (2) JNAME 가져오는 함수: getJname
SELECT JNAME FROM JOB;

-- 1번 기능: PNAME, JNAME, KOR, ENG, MAT를 입력받아 PERSON 테이블 INSERT
INSERT INTO PERSON (PNO, PNAME, JNO, KOR, ENG, MAT) 
    VALUES (PERSON_SEQ.NEXTVAL, '정우성', 
            (SELECT JNO FROM JOB WHERE JNAME = '배우'), 10, 90, 90);
ROLLBACK;

-- 2번 기능: JNAME을 입력받아 RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력
            -- RANK는 SUM 내림차순으로 순위를 정합니다.(hint. ROWNUM과 INLINE-VIEW 이용)
-- EX. 1등    	정우성(1번)     배우      90     	80      81	251	
SELECT PNAME || '(' || PNO || '번)' "PNAME(PNO)", JNAME, KOR, ENG, MAT, KOR+ENG+MAT "SUM"
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO AND JNAME = '가수'
    ORDER BY SUM DESC; -- SUBQUERY
SELECT ROWNUM "RANK", A.*
    FROM (SELECT PNAME || '(' || PNO || '번)' "PNAME", JNAME, KOR, ENG, MAT, KOR+ENG+MAT "SUM"
                FROM PERSON P, JOB J 
                WHERE J.JNO = P.JNO AND JNAME = '배우'
                ORDER BY SUM DESC) A; -- MAIN QUERY
-- 3번 기능: RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력
-- EX. 1등    정우성(1)     배우     90     	80      81	251
SELECT PNAME || '(' || PNO || ')' "PNAME", JNAME, KOR, ENG, MAT
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO; -- SUBQUERY
SELECT ROWNUM "RANK", A.*
    FROM (SELECT PNAME || '(' || PNO || ')' "PNAME", JNAME, KOR, ENG, MAT, KOR+ENG+MAT "SUM"
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO
    ORDER BY SUM DESC) A; -- MAIN QUERY


    



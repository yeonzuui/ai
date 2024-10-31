-- 테이블 및 시퀀스 제거
DROP TABLE PERSON;
DROP SEQUENCE PERSON_ID_SEQ;
-- 테이블 및 시퀀스 생성
CREATE TABLE PERSON(
    ID      NUMBER(6),             -- 순번(인위적인 PK)
    NAME    VARCHAR2(50) NOT NULL, -- 이름
    TEL     VARCHAR2(50) UNIQUE,   -- 전화
    ADDRESS VARCHAR2(250),         -- 주소
    BIRTH   DATE,                  -- 생년월일
    MEMO    VARCHAR2(4000),        -- 메모
    RDATE   DATE         DEFAULT SYSDATE NOT NULL, -- 등록 시점 (에디터 쓸거면 타입 CLOB)
    PRIMARY KEY(ID)
);
CREATE SEQUENCE PERSON_ID_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
-- DUMMY DATA 생성
INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO) 
    VALUES (PERSON_ID_SEQ.NEXTVAL, '홍길동', '010-9999-9999', '서울', NULL,'테스트');
INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO) 
    VALUES (PERSON_ID_SEQ.NEXTVAL, '신길동', '010-8888-8888', '서울', NULL, NULL);
INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO) 
    VALUES (PERSON_ID_SEQ.NEXTVAL, '박길숙', '010-7777-7777', '부산', NULL, NULL);
COMMIT;
-- DAO 들어갈 QUERY
-- 1. LIST (PAGING 없이): public ArrayList<Person> getPersonList()
SELECT * FROM PERSON;

-- 1. LIST (PAGING 추가): public ArrayList<Person> getPersonList(int startRow, int endRow) / top-N 구문 이용(2등~3등)
SELECT * FROM PERSON ORDER BY ID DESC; -- 1
SELECT ROWNUM RN, A.* FROM (SELECT * FROM PERSON ORDER BY ID DESC) A; -- 2
SELECT * 
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM PERSON ORDER BY ID DESC) A) -- 3
    WHERE RN BETWEEN 2 AND 3;
    
    
-- 2. getCount (PAGING 처리시 필요한 전체 갯수, 페이지수는 데이터 갯수에 따라 달라짐)
-- public int getCount()
SELECT COUNT(*) FROM PERSON;

-- 3. 추가: public int insertPerson(Person person)
INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
    VALUES (PERSON_ID_SEQ.NEXTVAL, '최길동', '010-6666-6666', '부산', '02/01/01', '테스트');
    
-- 4. 한 명 출력: public Person getPerson(int id)
SELECT * FROM PERSON WHERE ID=1;

-- 5. 수정: public int updatePerson(Person person)
UPDATE PERSON
    SET NAME = '홍길동', TEL='010-1234-7894', ADDRESS='수원', BIRTH='99/12/12', MEMO=''
    WHERE ID=1;

-- 6. 삭제: public int deletePerson(int id)
COMMIT;
DELETE FROM PERSON WHERE ID=1;
ROLLBACK;

-- ch07_db2 프로젝트에서 쓸 query
-- friend 데이터 저장할 table 생성
DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_NO_SQ;
CREATE TABLE FRIEND(
    NO   NUMBER(4, 0) PRIMARY KEY,
    NAME VARCHAR2(50) NOT NULL,
    TEL  VARCHAR2(30) UNIQUE
);
CREATE SEQUENCE FRIEND_NO_SQ MAXVALUE 9999 NOCACHE NOCYCLE;
-- dummy data insert
INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_NO_SQ.NEXTVAL, '홍길동', '010-9999-9999'); 
INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_NO_SQ.NEXTVAL, '홍길동', ''); 
INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_NO_SQ.NEXTVAL, '홍길동', NULL); 
-- INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_NO_SQ.NEXTVAL, NULL, '010-8888-8888'); ERROR
-- DAO에 들어갈 query
INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_NO_SQ.NEXTVAL, '신길동', '010-8888-8888'); 
SELECT * FROM FRIEND;
COMMIT;

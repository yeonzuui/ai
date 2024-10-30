-- 테이블 제거
DROP TABLE MEMBER CASCADE CONSTRAINTS;
-- 테이블 생성
CREATE TABLE MEMBER(
    ID    VARCHAR2(30),
    PW    VARCHAR2(30) NOT NULL,
    NAME  VARCHAR2(30) NOT NULL,
    BIRTH DATE,
    RDATE DATE         DEFAULT SYSDATE NOT NULL, -- 등록시점
    PRIMARY KEY(ID)
);
-- DUMMY DATA
INSERT INTO MEMBER (ID, PW, NAME, BIRTH) 
    VALUES ('aaa', '111', '홍길동', '99/12/12');
INSERT INTO MEMBER (ID, PW, NAME, BIRTH, RDATE) 
    VALUES ('bbb', '111', '신길동', '01/12/12', '24/01/01');
SELECT * FROM MEMBER;

-- DAO에 들어갈 QUERY
-- public int insertMember(Member new Member)
INSERT INTO MEMBER (ID, PW, NAME, BIRTH) 
    VALUES ('ccc', '111', '홍길동', '24/01/01'); -- 사용자가 INPUT 받는 형식 고려
    
-- public Member getMember(String id)
-- SELECT * FROM MEMBER WHERE ID='aaa';

-- public int getCountMember(String id)
SELECT count(*) FROM MEMBER WHERE ID='aaa';

-- public ArrayList<Member> getMemberList(몇등, 몇등)
SELECT * FROM MEMBER ORDER BY NAME;
COMMIT;

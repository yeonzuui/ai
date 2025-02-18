-- 저장 경로
-- D:/ai/source/12_fastAPI/ch4_todo_db/database/todo.sql

-- 테이블 삭제 및 생성
DROP TABLE TODO;
CREATE TABLE TODO(
    ID       NUMBER(4)     PRIMARY KEY,
    CONTENTS VARCHAR2(256) NOT NULL,
    IS_DONE  NUMBER(1)     DEFAULT 0
);

-- 해당 예제에서는 ID에 SEQUENCE 필요없음
-- CREATE SEQUENCE TODO_SQ NOCACHE NOCYCLE MAXVALUE 9999;

-- CREATE
--INSERT INTO TODO (ID, CONTENTS, IS_DONE)VALUES (TODO_SQ.NEXTVAL, '장고', 0);
INSERT INTO TODO (ID, CONTENTS, IS_DONE) VALUES (1, '개별프로젝트발표', 0);
INSERT INTO TODO (ID, CONTENTS, IS_DONE) VALUES (2, '포트폴리오및이력서,GIT README작성', 0);
INSERT INTO TODO (ID, CONTENTS, IS_DONE) VALUES (3, '설날에 맛난거 많이 먹기', 0);
INSERT INTO TODO (ID, CONTENTS, IS_DONE) VALUES (4, '머신러닝', 0);
INSERT INTO TODO (ID, CONTENTS, IS_DONE) VALUES (5, '팀프로젝트', 0);
INSERT INTO TODO (ID, CONTENTS, IS_DONE) VALUES (6, 'DJANGO', 0);

-- READ
SELECT * FROM TODO ORDER BY ID;
SELECT * FROM TODO WHERE ID = 1;

-- UPDATE
UPDATE TODO SET CONTENT = '바꿀내용', IS_DONE = 1 WHERE ID = 1;

-- DELETE
DELETE FROM TODO WHERE ID = 1;
COMMIT;

SELECT * FROM TODO
-- [IX] 쇼핑몰 DB 설계 및 생성, 입력, 수정
DROP TABLE CART;
DROP TABLE ORDER_DETAIL;
DROP TABLE ORDERS;
DROP TABLE MEMBER;
DROP TABLE PRODUCT;
-- 테이블 삭제가 안 되면 참조되는 테이블이 있는 경우
        -- 무시하고 삭제하고자 하면 CASCADE CONSTRAINTS 추가
-- Entity(table)간 관계
    -- 식별관계 : 부모테이블의 주키가 자식 테이블의 주키
    -- 비식별관계 : 부모테이블의 주키가 자식테이블의 일반속성
    
CREATE TABLE MEMBER(
    mID   VARCHAR2(20)  PRIMARY KEY,
    mNAME VARCHAR2(50)  NOT NULL,
    mADDR VARCHAR2(255),
    mTEL  VARCHAR2(30),    
    mMAIL VARCHAR2(30)  NOT NULL
);
CREATE TABLE PRODUCT(
    pCODE  VARCHAR2(5)  PRIMARY KEY,
    pNAME  VARCHAR2(50) NOT NULL,
    PRICE  NUMBER(6)    NOT NULL    CHECK(PRICE > 0),
    pSTOCK NUMBER(3)    NOT NULL    CHECK(pSTOCK >= 0)
);
DROP SEQUENCE CART_SEQ; 
CREATE SEQUENCE CART_SEQ MAXVALUE 999999999 NOCACHE; -- 주문 시 사라질 테이블이라 NOCYCLE 생략
CREATE TABLE CART(
    cNO   NUMBER(9)    PRIMARY KEY,
    mID   VARCHAR2(20) REFERENCES MEMBER(mID)    NOT NULL,
    pCODE VARCHAR2(5)  REFERENCES PRODUCT(pCODE) NOT NULL,
    QTY   NUMBER(3)    CHECK(QTY>0)              NOT NULL,
    COST  NUMBER(9) 
    -- FOREIGN KEY(mID) REFERENCES MEMBER(mID) 밑에 추가해도 됨
);
DROP SEQUENCE ORDERS_SEQ;
CREATE SEQUENCE ORDERS_SEQ MAXVALUE 999 NOCACHE;
CREATE TABLE ORDERS(
    oNO   VARCHAR2(9)   PRIMARY KEY, -- 여기선 NUMBER()도 가능  ex. 2401, 2402, ...
    mID   VARCHAR2(20)  REFERENCES MEMBER(mID) NOT NULL,
    oNAME VARCHAR2(50)  NOT NULL,
    oADDR VARCHAR2(255) NOT NULL,
    oTEL  VARCHAR2(30)  NOT NULL,
    oDATE DATE          DEFAULT SYSDATE
);
DROP SEQUENCE ORDER_DETAIL_SEQ;
CREATE SEQUENCE ORDER_DETAIL_SEQ MAXVALUE 999999999 NOCYCLE NOCACHE;
CREATE TABLE ORDER_DETAIL(
    odNO  NUMBER(9)   PRIMARY KEY,
    oNO   VARCHAR2(9) REFERENCES ORDERS(oNO)    NOT NULL,
    pCODE VARCHAR2(5) REFERENCES PRODUCT(pCODE) NOT NULL,
    QTY   NUMBER(3)   NOT NULL                  CHECK(QTY>0),
    COST  NUMBER(9)
);
SELECT * FROM MEMBER;
SELECT * FROM PRODUCT;
SELECT * FROM CART;
SELECT * FROM ORDERS;
SELECT * FROM ORDER_DETAIL;
-- MEMBER(고객): mID, mNAME, mADDRESS, mTEL, mEMAIL
INSERT INTO MEMBER VALUES ('abc','홍길동','서울 관악구 신림동','010-9999-9999','hong@hong.com');
INSERT INTO MEMBER VALUES ('def','김김동','경기도 수원시','010-8888-8888','kim@kim.com');
SELECT * FROM MEMBER;
-- PRODUCT(상품): pCODE, pNAME, PRICE, STOCK(100으로 가정)
INSERT INTO PRODUCT VALUES ('A1', '맥주', 3000, 100);
INSERT INTO PRODUCT VALUES ('A2', '마스크', 200, 100);
INSERT INTO PRODUCT VALUES ('B1', '땅콩', 3000, 100);
INSERT INTO PRODUCT VALUES ('B2', '오징어', 5000, 100);
INSERT INTO PRODUCT VALUES ('C1', '소독약', 7000, 100);
SELECT * FROM PRODUCT;

-- 주문번호 생성하기 연습 ('230728' || ' 001' => '230728001')
SELECT TO_CHAR(SYSDATE, 'RRMMDD')|| TRIM(TO_CHAR(1, '000')) oNO FROM DUAL;

-- ▒▒▒▒▒ 첫번째 홍길동님 주문서 (23.07.26) ▒▒▒▒▒
-- 1. 홍길동(abc)님 장바구니 물건 담기
INSERT INTO CART VALUES
  (CART_SEQ.NEXTVAL, 'abc', 'A1', 3, (SELECT PRICE FROM PRODUCT WHERE PCODE='A1')*3);
INSERT INTO CART VALUES
  (CART_SEQ.NEXTVAL, 'abc', 'B1', 1, (SELECT PRICE FROM PRODUCT WHERE PCODE='B1')*1);
SELECT * FROM CART;

-- 2. 홍길동(abc)님 주문하기 
 -- 2-1. ORDERS (주문) 테이블
  INSERT INTO ORDERS (ONO, MID, ONAME, OADDR, OTEL)
    VALUES (TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '000')), 'abc', 
            '홍길동', '서울시 서대문구', '010-9999-9999');
  SELECT * FROM ORDERS;
   -- 2.2. ORDER_DETAIL(주문상세) 테이블(장바구니에 넣은 물건을 한꺼번에 주문할 경우)
     -- 주문상세 테이블에 insert할 때 필요한 서브쿼리 연습
    SELECT 
      ORDER_DETAIL_SEQ.NEXTVAL odNO,
      TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ONO, PCODE, QTY, COST
    FROM CART WHERE MID='abc'; -- 주문상세 테이블에 insert할 때 필요한 서브쿼리
  DROP SEQUENCE ORDER_DETAIL_SEQ; -- 위에 연습했으니 시퀀스 새로 생성
  CREATE SEQUENCE ORDER_DETAIL_SEQ MAXVALUE 999999999 NOCYCLE NOCACHE;
  INSERT INTO ORDER_DETAIL (odNO, oNO, pCODE, QTY, COST)
    SELECT 
      ORDER_DETAIL_SEQ.NEXTVAL odNO,
      TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ONO,PCODE, QTY, COST
    FROM CART WHERE MID='abc';
  SELECT * FROM ORDER_DETAIL; -- ORDERS 테이블과 ORDER_DETAIL테이블 완성
-- 3. 재고 수량 수정 (A1상품 3개, B1상품 1개 구매하여 재고 수정)
UPDATE PRODUCT SET pSTOCK = pSTOCK-3 WHERE pCODE='A1'; -- 재고 수량 수정
UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE='B1';-- 재고 수량 수정
-- 4. 장바구니 비우기
DELETE FROM CART WHERE MID='abc';

-- 5. 메일로 보내질 주문서에 필요한 데이터 출력
--현재 주문번호만 SELECT절에 현재 시퀀스값을 이용하여 가져올 수 있으나 시퀀스.CURRVAL은 WHERE절에서 사용할 수 없음
SELECT TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) FROM DUAL; -- 현재 주문번호
SELECT * FROM ORDERS WHERE ONO=240926001; -- 주문서에 출력할 내용

SELECT O.PCODE, PNAME, PRICE, QTY, COST
  FROM ORDER_DETAIL O, PRODUCT P
  WHERE O.PCODE=P.PCODE AND ONO=240926001; -- 주문서에 출력할 내용
  
-- ▒▒▒▒▒ 두번째 김김동님 주문서 (23.07.26) ▒▒▒▒▒
-- 1. 김김동(def)님 장바구니 물건 담기
INSERT INTO CART
  VALUES (CART_SEQ.NEXTVAL, 'def', 'A2', 20, (SELECT PRICE FROM PRODUCT WHERE PCODE='A2')*20);
INSERT INTO CART 
  VALUES (CART_SEQ.NEXTVAL, 'def', 'B2', 2, (SELECT PRICE FROM PRODUCT WHERE PCODE='B2')*2);
INSERT INTO CART 
  VALUES (CART_SEQ.NEXTVAL, 'def', 'C1', 1, (SELECT PRICE FROM PRODUCT WHERE PCODE='C1')*1);
SELECT * FROM CART;
-- 2. 김김동(def)님 주문하기 
  -- 2-1. ORDERS (주문) 테이블
  INSERT INTO ORDERS (ONO, MID, ONAME, OADDR, OTEL)
    VALUES (TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '000')), 'abc', 
            '김김동', '경기도 수원시', '010-8888-8888');
  SELECT * FROM ORDERS;
  -- 2.2. ORDER_DETAIL(주문상세) 테이블(장바구니에 넣은 물건을 한꺼번에 주문할 경우)
  INSERT INTO ORDER_DETAIL (odNO, oNO, pCODE, QTY, COST)
    SELECT 
      ORDER_DETAIL_SEQ.NEXTVAL odNO,
      TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ONO,PCODE, QTY, COST
    FROM CART WHERE MID='def';
    SELECT * FROM ORDER_DETAIL; -- ORDERS 테이블과 ORDER_DETAIL테이블 완성
    
-- 3. 재고 수량 수정 (A1상품 3개, B1상품 1개 구매하여 재고 수정)
  UPDATE PRODUCT SET pSTOCK = pSTOCK-20 WHERE pCODE='A2'; -- 재고 수량 수정
  UPDATE PRODUCT SET pSTOCK = pSTOCK-2 WHERE pCODE='B2';-- 재고 수량 수정
  UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE='C1';-- 재고 수량 수정
-- 4. 장바구니 비우기
  DELETE FROM CART WHERE MID='def';
  
-- 5. 메일로 보내질 주문서에 필요한 데이터 출력
--현재 주문번호만 SELECT절에 현재 시퀀스값을 이용하여 가져올 수 있으나 시퀀스.CURRVAL은 WHERE절에서 사용할 수 없음
SELECT TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) FROM DUAL; -- 현재 주문번호

SELECT * FROM ORDERS WHERE ONO=240926002;-- 주문서에 출력할 내용

SELECT O.PCODE, PNAME, PRICE, QTY, COST
  FROM ORDER_DETAIL O, PRODUCT P
  WHERE O.PCODE=P.PCODE AND ONO=240926002;-- 주문서에 출력할 내용
  
-- ▒▒▒▒▒ 세번째 홍길동님 주문서 (23.7.28) ▒▒▒▒▒
-- 1. 홍길동(abc)님 홍아빠에게 보낼 물건 장바구니 담기
INSERT INTO CART 
  VALUES (CART_SEQ.NEXTVAL, 'abc', 'A1', 2, (SELECT PRICE FROM PRODUCT WHERE PCODE='A1')*2);
INSERT INTO CART 
  VALUES (CART_SEQ.NEXTVAL, 'abc', 'B1', 1, (SELECT PRICE FROM PRODUCT WHERE PCODE='B1')*1);
INSERT INTO CART 
  VALUES (CART_SEQ.NEXTVAL, 'abc', 'C1', 1, (SELECT PRICE FROM PRODUCT WHERE PCODE='C1')*1);
SELECT * FROM CART;
-- 2. 홍길동(abc)님 홍아빠에게로 주문하기 
  -- 2-1. ORDERS (주문) 테이블
  INSERT INTO ORDERS (ONO, MID, ONAME, OADDR, OTEL)
    VALUES (TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '000')),
            'abc', '홍아빠', '제주도 제주시', '010-7777-9999');
  SELECT * FROM ORDERS;
  -- 2.2. ORDER_DETAIL(주문상세) 테이블(장바구니에 넣은 물건을 한꺼번에 주문할 경우)
  INSERT INTO ORDER_DETAIL (odNO, oNO, pCODE, QTY, COST)
    SELECT 
      ORDER_DETAIL_SEQ.NEXTVAL odNO,
      TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ONO,PCODE, QTY, COST
    FROM CART WHERE MID='abc';
  SELECT * FROM ORDER_DETAIL; -- ORDERS 테이블과 ORDER_DETAIL테이블 완성
-- 3. 재고 수량 수정 (A1상품 3개, B1상품 1개 구매하여 재고 수정)
  UPDATE PRODUCT SET pSTOCK = pSTOCK-2 WHERE pCODE='A1'; -- 재고 수량 수정
  UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE='B1';-- 재고 수량 수정
  UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE='C1';-- 재고 수량 수정
-- 4. 장바구니 비우기
  DELETE FROM CART WHERE MID='abc';
  
-- 5. 메일로 보내질 주문서에 필요한 데이터 출력
--현재 주문번호만 SELECT절에 현재 시퀀스값을 이용하여 가져올 수 있으나 시퀀스.CURRVAL은 WHERE절에서 사용할 수 없음
SELECT TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) FROM DUAL; -- 현재 주문번호

SELECT * FROM ORDERS WHERE ONO=240926003;-- 주문서에 출력할 내용
SELECT O.PCODE, PNAME, PRICE, QTY, COST
  FROM ORDER_DETAIL O, PRODUCT P
  WHERE O.PCODE=P.PCODE AND ONO=240926003;-- 주문서에 출력할 내용
  
SELECT * FROM ORDERS;
SELECT * FROM ORDER_DETAIL;
SELECT * FROM PRODUCT; -- 주문 후 100개였던 재고량 변동 확인
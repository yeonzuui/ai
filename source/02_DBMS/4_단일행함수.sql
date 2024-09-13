-- [IV] 단일행함수
-- 함수 = 단일행함수(4장) + 그룹함수(5장)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD HH24:MI:SS') FROM EMP; -- 단일행 적용

SELECT AVG(SAL) FROM EMP; -- 그룹함수(INPUT 14행 -> OUTPUT 1행)
--싱글라인필드와 그룹함수 같이 사용 불가
SELECT DEPTNO, AVG(SAL) FROM EMP; -- INPUT N행 -> OUTPUT 1행
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;

-- ★ 단일행함수 = 숫자관련함수, 문자관련함수, 날짜관련함수, 형변환함수, NVL, etc..
-- 1. 숫자 관련 함수
    -- DUAL테이블: 오라클에서 제공한 1행1열짜리 DUMMY TABLE
SELECT * FROM DUAL;
DESC DUAL;
SELECT FLOOR(34.567) FROM DUAL; --소수점에서 내림(버림)
SELECT FLOOR(34.567*10)/10 FROM DUAL; --정수/정수=>실수
SELECT TRUNC(34.567, 1) FROM DUAL;
SELECT TRUNC(34.567, -1) FROM DUAL;
    -- EX. EMP에서 이름, 급여(십의 자리에서 내림)
    SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;
SELECT CEIL(34.567) FROM DUAL; --소수점에서 올림
SELECT ROUND(34.567) FROM DUAL; --소수점에서 반올림
SELECT ROUND(34.567, 2) FROM DUAL; --소수점 두자리에서 반올림
SELECT ROUND(34.567, -1) FROM DUAL; --일의 자리에서 반올림
SELECT MOD(9,2) FROM DUAL; --9/2의 나머지
    -- 홀수년도에 입사한 사원의 모든 정보 출력
    SELECT * FROM EMP
        WHERE MOD(TO_CHAR(HIREDATE, 'RR'), 2) = 1;
-- 2. 문자 관련 함수
-- 3. 날짜 관련 함수
-- 4. 형변환 함수
-- NVL







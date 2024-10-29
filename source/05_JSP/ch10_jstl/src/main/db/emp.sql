-- 모든 getEmpList
SELECT * FROM EMP;

-- quiz에 쓸 query ArrayList(Emp) getEmpList(String schName, String schJob)
-- 이름과 직책 일부로 검색
SELECT * FROM EMP
    WHERE ENAME LIKE '%' || TRIM(UPPER('  s')) || '%' 
        AND JOB LIKE '%' || TRIM(UPPER('  c')) || '%';
package com.lec.ex1selectAll;

import java.sql.*;
import java.util.Date;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";  // 드라이버
		String url    = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		String sql    = "SELECT * FROM EMP"; // 불러오기 전에 sqldeveloper에서 실행해보기
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null; // select 결과를 받을 변수객체
		try {
			Class.forName(driver); // 1. 드라이버 로드(jdk17부터 생략가능)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3. SQL 전송 객체
			rs   = stmt.executeQuery(sql); // 4+5. SQL전송 + SQL결과 받기
			// 6. 원하는 로직 수행
			if(rs.next()) { // select 결과가 1행 이상
				System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t급여\t상여\t부서번호");
				do {
					int    empno    = rs.getInt(1); // 첫번째 필드 가져와라
					String ename    = rs.getString("ename"); // SQL결과의 title에 ename인 값
					String job      = rs.getString("job");
					String mgr      = rs.getString("mgr"); // null 값은 null 문자로 받음
					//String hiredate = rs.getString("hiredate");
					Date   hiredate = rs.getDate("hiredate"); // java.sql.Date 날짜만 받기(시간은 0시 0분)
					//Timestamp hiredate1 = rs.getTimestamp("hiredate"); // 날짜와 시간 받기
					int    sal      = rs.getInt("sal");
					int    comm     = rs.getInt("comm"); // null값은 0으로 받음
					int    deptno   = rs.getInt("deptno");
					if(job.length() < 6) {
						System.out.printf("%d\t %s\t %s\t\t %s\t %TF\t %d\t %d\t %d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}else {
						System.out.printf("%d\t %s\t %s\t %s\t %TF\t %d\t %d\t %d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}
				}while(rs.next());
			}else {
				System.out.println("등록된 사원 정보가 없습니다");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 7. 연결 해제(순서대로)
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	} // main
} // class












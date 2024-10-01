package com.lec.ex4update;

import java.sql.*;
import java.util.Scanner;

public class UpdateDeptConfirm {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner    scanner = new Scanner(System.in);
		Connection conn    = null;
		Statement  stmt    = null;
		ResultSet  rs      = null;
		System.out.print("수정할 부서번호는 > ");
		int deptno = scanner.nextInt();
		// 부서번호 존재 여부 confirm ---> deptno 존재하면 dname 입력으로 넘어가도록
		String confirmsql = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(confirmsql);
			if(rs.next()) {
				System.out.println("수정할 부서명은 >");
				String dname = scanner.next();
				System.out.println("수정할 부서위치는 >");
				String loc = scanner.next();
				String updatesql = String.format("UPDATE DEPT"
						+ "    SET DNAME = UPPER('marketing'),"
						+ "        LOC   = UPPER('seoul')"
						+ "    WHERE DEPTNO = 80", dname, loc, deptno);
				int result = stmt.executeUpdate(updatesql);
				if(result > 0) {
					System.out.println("수정성공");
				}
			}else {
				System.out.println(deptno + "번 부서는 유효하지 않은 부서번호입니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 7. 연결해제
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

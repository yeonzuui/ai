package com.lec.ex2selectWhere;

import java.sql.*;
import java.util.Scanner;

// 부서이름을 입력받아 해당 부서 정보 출력
public class Ex3_selectWhereDname {
	// SQL문 먼저 만들기
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("출력을 원하는 부서이름은? ");
		String dname = scanner.next();
		String sql = "SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER('" + dname + "')"; // 방법1
		sql = String.format("SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER('%s')", dname); // 방법2
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(sql);
			if(rs.next()) {
				// deptno, dname, loc
				System.out.println("부서번호: " + rs.getInt("deptno"));
				System.out.println("부서명: " + rs.getString("dname")); // getString - 대문자로 가져오기 위함
				System.out.println("부서위치: " + rs.getString("loc"));
			}else {
				System.out.println(dname + "(이)라는 부서는 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 7. 연결해제
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

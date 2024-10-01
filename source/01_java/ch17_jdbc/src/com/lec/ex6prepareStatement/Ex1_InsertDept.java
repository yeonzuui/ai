package com.lec.ex6prepareStatement;

import java.sql.*;
import java.util.Scanner;

public class Ex1_InsertDept {
	// SQL문 먼저 만들기
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		// Statement stmt = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DEPT VALUES (?, UPPER(?), UPPER(?))"; // SQL문 미리 생성
		System.out.print("입력할 부서번호는 >");
		int deptno = scanner.nextInt();
		System.out.print("입력할 부서명은 >");
		String dname = scanner.next();
		System.out.print("입력할 부서위치는 >");
		String loc = scanner.next();
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // 첫번째 물음표는 int값 deptno로 채움
			pstmt.setString(2, dname); // 두번째 물음표는 String값 dname로 채움
			pstmt.setString(3, loc); // 세번째 물음표는 String값 loc로 채움
			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? "입력성공" : "입력실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 7. 연결해제
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}

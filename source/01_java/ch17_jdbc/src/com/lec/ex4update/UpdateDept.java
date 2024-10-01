package com.lec.ex4update;

import java.sql.*;
import java.util.Scanner;

// 수정할 부서번호, 부서명, 부서위치를 받아 update(수정 확인은 sqldeveloper에서)
public class UpdateDept {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner    scanner = new Scanner(System.in);
		Connection conn    = null;
		Statement  stmt    = null;
		// ResultSet 필요없음 SELECT로 결과 출력할 거 아니니까
		System.out.print("수정할 부서번호는 > ");
		int deptno = scanner.nextInt();
		System.out.print("수정할 부서이름은 > ");
		String dname = scanner.next();
		System.out.print("수정할 부서위치는 > ");
		String loc = scanner.next();
		String sql = String.format("UPDATE DEPT"
				+ "    SET DNAME = UPPER('%s'),"
				+ "        LOC   = UPPER('%s')"
				+ "    WHERE DEPTNO = %d", dname, loc, deptno);
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "수정성공" : "해당 부서가 없어서 수정 불가합니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try { // 7. 연결해제
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

package com.lec.ex2selectWhere;

import java.sql.*;
import java.util.Scanner;

/* 1. 사용자에게 원하는 부서번호(40)를 입력받아
 *  1.1 해당 부서번호가 존재하는 경우: 부서정보 출력
 *  		사원정보(사번, 이름, 급여, 상사명) 출력, 사원이 존재하지 않는 경우 사원이 없다고 출력
 *  1.2 해당 부서번호가 존재하지 않을 경우: 존재하지 않는 부서라고 출력 */
public class Ex2_selectWhere {
	// SQL문 먼저 만들기
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner    scanner = new Scanner(System.in);
		Connection conn    = null;
		Statement  stmt    = null;
		ResultSet  rs      = null;
		System.out.println("출력을 원하는 부서번호는? ");
		int deptno = scanner.nextInt();
		String query1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		String query2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER"
				+ "    FROM EMP W, EMP M"
				+ "    WHERE W.MGR = M.EMPNO AND W.DEPTNO =" + deptno;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2) DB연결
			stmt = conn.createStatement(); // (3) SQL 전송 객체 생성
			rs   = stmt.executeQuery(query1); // (4) SQL 전송 + 결과 받기
			if(rs.next()) { // 부서번호가 있는 경우
				System.out.println("원하는 부서번호: " + deptno);
				System.out.println("원하는 부서이름: " + rs.getString("dname"));
				System.out.println("원하는 부서위치: " + rs.getString("loc"));
				System.out.println(); // 개행
				// query2 전송해서 사원정보 출력하기
				rs.close(); // rs에 새로운 값 받기 위함
				rs = stmt.executeQuery(query2);
				if(rs.next()) { // 사원이 존재할 경우
					System.out.println("사번\t이름\t급여\t상사명");
					do{
						// rs 내용 출력
						int    empno   = rs.getInt("empno");
						String ename   = rs.getString("ename");
						int    sal     = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);
					}while(rs.next());
				}else { // 사원이 없는 경우
					System.out.println(deptno + "번 부서 사원은 없습니다.");
				}
			}else { // 부서번호가 없는 경우
				System.out.println(deptno + "는 유효한 부서번호가 아닙니다.");
			}
		} catch (SQLException e) {
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
	} // main
} // class

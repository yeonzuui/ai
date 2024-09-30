package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Oracle 연동 여부: (1)드라이버 로드(jdk17부터 생략가능) (2)DB연결
public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";  // 드라이버
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Connection conn = null;
		try {
			Class.forName(driver); // 1. 드라이버 로드: 모듈에 requires java.sql; 생김
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB연결
			System.out.println("mySQL 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + " 드라이버 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	} // main
} // class




















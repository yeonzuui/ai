package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Oracle 연동 여부: (1)드라이버 로드(jdk17부터 생략가능) (2)DB연결
public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";                             // 드라이버 
		String url = "jdbc:mysql://localhost:3306/dev_user?serverTimezone=UTC"; // 주소
		Connection conn = null;
		try {
			Class.forName(driver); // 1. 드라이버 로드: 모듈에 requires java.sql; 생김
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2. DB연결
			System.out.println("mySQL 연결 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	} // main
} // class




















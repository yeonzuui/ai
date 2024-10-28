package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.Dept;


// Dept_DAO(함수 1개)
public class DeptRepository {
	// singleton-pattern : web 이용자 많음을 고려
	// DeptRepository 타입의 INSTANCE 변수 생성
	private static DeptRepository INSTANCE;
	
	// 객체 불러오는 getInstance()라는 method 생성
	public static DeptRepository getInstance() {
		if(INSTANCE == null) { 
			// 객체 생성
			INSTANCE = new DeptRepository();
		}
		return INSTANCE;
	}
	
	// Constructor(private)
	private DeptRepository() {}
	// 커넥션 풀
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	// (1) 부서 정보들 가져오는 함수: deptList
	// SELECT DEPTNO, DNAME FROM DEPT 실행결과를 return
	public ArrayList<Dept> deptList(){
		ArrayList<Dept> dtos = new ArrayList<Dept>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT DEPTNO, DNAME FROM DEPT";
		try {
			conn = getConnection(); //(2)
			pstmt = conn.prepareStatement(query); // (3)
			rs = pstmt.executeQuery(); // (4) + (5)
//			(6) sol 1
			while(rs.next()) {
				int    deptno  = rs.getInt("deptno"); 
				String dname   = rs.getString("dname");
				dtos.add(new Dept(deptno, dname)); // 생성자함수 추가
			}
			
//			sol 2 
//			while(rs.next()) {
//				Dept dept = new Dept();
//				dept.setDeptno(rs.getInt("deptno"));
//				dept.setDname(rs.getString("dname"));
//				dtos.add(dept);
//			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally { // (7)
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
}












































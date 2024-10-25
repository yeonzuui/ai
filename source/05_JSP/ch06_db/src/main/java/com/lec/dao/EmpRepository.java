package com.lec.dao;

import java.sql.*;
import java.util.ArrayList;

import com.lec.dto.Emp;

// Emp_DAO(함수 3개)
public class EmpRepository {
	// singleton-pattern : web 이용자 많음을 고려
	// data
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String uid    = "scott";
	private String upw    = "tiger";
	private static EmpRepository INSTANCE = new EmpRepository();
	public static EmpRepository getInstance() {
		return INSTANCE;
	}
	// Constructor
	public EmpRepository() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 1. SELECT * FROM EMP 수행결과 return
	public ArrayList<Emp> empList(){
		ArrayList<Emp> dtos = new ArrayList<Emp>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM EMP";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int    empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int    mgr = rs.getInt("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal = rs.getInt("sal");
				int    comm = rs.getInt("comm");
				int    deptno = rs.getInt("deptno");
				dtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, null));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		};
		return dtos;
	}
	// 2. 부서번호로 검색해서 empList return
	
	public ArrayList<Emp> empListByDeptno(String deptnoStr){
		ArrayList<Emp> dtos = new ArrayList<Emp>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String query = "SELECT E.*, DNAME"
				+ "    FROM EMP E, DEPT D"
				+ "    WHERE E.DEPTNO LIKE '%' || ? AND E.DEPTNO = D.DEPTNO";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, deptnoStr); // ? 채우기 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    empno    = rs.getInt("empno");
				String ename    = rs.getString("ename");
				String job      = rs.getString("job");
				int    mgr      = rs.getInt("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal      = rs.getInt("sal");
				int    comm     = rs.getInt("comm");
				int    deptno   = rs.getInt("deptno");
				String dname    = rs.getString("dname");
				dtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null)    rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		};
		return dtos;
	}
	
	// 3. 이름으로 검색해서 empList return

	public ArrayList<Emp> empListBySearchName(String searchName){
		ArrayList<Emp> dtos = new ArrayList<Emp>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String query = "	SELECT E.*, DNAME"
				+ "    FROM EMP E, DEPT D"
				+ "    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%'|| TRIM(UPPER(?)) ||'%'";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchName); // ? 채우기 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    empno    = rs.getInt("empno");
				String ename    = rs.getString("ename");
				String job      = rs.getString("job");
				int    mgr      = rs.getInt("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal      = rs.getInt("sal");
				int    comm     = rs.getInt("comm");
				int    deptno   = rs.getInt("deptno");
				String dname    = rs.getString("dname");
				dtos.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null)    rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		};
		return dtos;
	}
}




















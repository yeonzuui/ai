package com.lec.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.dto.Emp;

public class EmpRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
	private String id = "scott";
	private String pw = "tiger";
	
	private static EmpRepository INSTANCE;
	public static EmpRepository getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new EmpRepository();
		}
		return INSTANCE;
	}
	private EmpRepository() {}
	// (1) 사원 정보들 가져오는 함수: getEmpList()
	public ArrayList<Emp> getEmpList(){
		ArrayList<Emp> emps = new ArrayList<Emp>();
		// 변수 선언은 try-catch 블록 밖에
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int    empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal = rs.getInt("sal");
				int    comm = rs.getInt("comm");
				int    deptno = rs.getInt("deptno");
				emps.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // close
		} // try-catch-finally
		return emps;
	}
	// (2) deptno로 사원정보 가져오는 함수: getEmpList(10)
	public ArrayList<Emp> getEmpList(int deptno){
		ArrayList<Emp> emps = new ArrayList<Emp>();
		// 변수 선언은 try-catch 블록 밖에
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs   = null;
		String sql = "SELECT * FROM EMP WHERE DEPTNO = ?";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // SQL문 내의 물음표 채우기 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    empno    = rs.getInt("empno");
				String ename    = rs.getString("ename");
				String job      = rs.getString("job");
				String mgr      = rs.getString("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal      = rs.getInt("sal");
				int    comm     = rs.getInt("comm");
				// int    deptno = rs.getInt("deptno");
				emps.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // close
		} // try-catch-finally
		return emps;
	}
	//	(3) dname으로 사원정보 가져오는 함수: getEmpList("sales")
		public ArrayList<Emp> getEmpList(String dname){
			ArrayList<Emp> emps = new ArrayList<Emp>();
			// 변수 선언은 try-catch 블록 밖에
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT E.* "
					+ "	    FROM EMP E, DEPT D "
					+ "	    WHERE E.DEPTNO = D.DEPTNO AND UPPER(DNAME) = UPPER(?)";
			try {
				conn = DriverManager.getConnection(url, id, pw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dname); // SQL문 내의 물음표 채우기 
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int    empno    = rs.getInt("empno");
					String ename    = rs.getString("ename");
					String job      = rs.getString("job");
					String mgr      = rs.getString("mgr");
					Date   hiredate = rs.getDate("hiredate");
					int    sal      = rs.getInt("sal");
					int    comm     = rs.getInt("comm");
					int    deptno = rs.getInt("deptno");
					emps.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs != null)    rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null)  conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} // close
			} // try-catch-finally
			return emps;
		}
}
	

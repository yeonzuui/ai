package com.lec.dao;
// ctrl + shift + o : 필요한 import 추가, 불필요한 import는 삭제
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.lec.dto.Dept;

public class DeptRepository {
	String driver = "oracle.jdbc.driver.OracleDriver";  // 드라이버
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
	
	// 성공 = 1 / 실패 = 0
	public final static int SUCCESS = 1;
	public final static int FAIL    = 0;
	
	// DeptRepository 타입의 INSTANCE 변수 생성
	private static DeptRepository INSTANCE = new DeptRepository();
	
	// INSTANCE의 주소를 return
	public static DeptRepository getinstace() { 
		return INSTANCE;
	}
	
	private DeptRepository() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// (1) 부서 정보들 가져오는 함수: getDeptList
	public ArrayList<Dept> getdeptlist(){
		ArrayList<Dept> dtos = new ArrayList<Dept>() ;
		// SQL 수행한 결과를 dtos에 추가하기
		Connection 		  conn  = null;
		PreparedStatement pstmt = null;
		ResultSet 		  rs    = null;
		String sql = "SELECT * FROM DEPT";
		try {
			conn  = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); 
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				int    deptno = rs.getInt("deptno");
				String dname  = rs.getString("dname");
				String loc    = rs.getString("loc");
				dtos.add(new Dept(deptno, dname, loc));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // close
		} // try-catch-finally
		return dtos; // rs.next()가 없으면 size = 0인 ArrayList 반환
	}
	// (2) deptno로 부서정보 가져오는 함수: getDept()
	public Dept getDept(int deptno) {
		Dept dto = null; // 초기값 최악의 조건(null)
		// Query 수행 결과를 dto에
		Connection        conn      = null;
		PreparedStatement pstmt = null;
		ResultSet         rs = null;
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = ?";
		try {
			conn  = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // deptno 변수 타입과 일치하도록
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dto = new Dept(deptno, dname, loc);
			}
		} catch (SQLException e) {
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
		return dto;
	};
	// (3) dname으로 부서정보 가져오는 함수: getDept("sales")
	public Dept getDept(String dname) { // 위 getDept 함수와 변수타입이 다름
		Dept dto = null; // 초기값
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE UPPER(DNAME) = UPPER(?)"; // single quotation mark도 지워
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname); // SQL문 물음표 채우기
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				dname      = rs.getString("dname");
				String loc = rs.getString("loc");
				dto = new Dept(deptno, dname, loc); // rs.next() true면 dto에 deptno, dname, loc 넣어
			}
		} catch (SQLException e) {
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
		return dto;
	}
	// --------------- (결과값을 success / fail로 반환)--------------------
	// (4) insertDept(10, "it", "seoul") 
	public int insertDept(int deptno, String dname, String loc) {
		int result = FAIL;
		// insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		// select 아니니까 rs 필요없어
		String sql = "INSERT INTO DEPT VALUES (?, UPPER(?), UPPER(?))";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // SQL문 물음표 채우기
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "입력성공" : "입력실패");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + deptno + dname + loc); // 오류메시지와 함께 deptno, dname, loc 출력
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // close
		} // try-catch-finally
		return result;
	}
	// (5) updateDept
	public int updateDept(int deptno, String dname, String loc) {
		int result = FAIL;
		// update
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		// select 아니니까 rs 필요없어
		String sql = "UPDATE DEPT"
				+ "    SET DNAME = UPPER(?),"
				+ "        LOC   = UPPER(?)"
				+ "    WHERE DEPTNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname); // SQL문 물음표 채우기(순서유의)
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno); 
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "수정성공" : "부서번호가 유효하지 않아 수정 실패");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + deptno + dname + loc); // 오류메시지와 함께 deptno, dname, loc 출력
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // close
		} // try-catch-finally
		return result;
	}
	// (6) deleteDept
	public int deleteDept(int deptno) {
		int result = FAIL;
		// delete
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		// select 아니니까 rs 필요없어
		String sql = "DELETE FROM DEPT WHERE DEPTNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // SQL문 물음표 채우기
			result = pstmt.executeUpdate();
			if(result == SUCCESS) {
				System.out.println(deptno + "번 부서 삭제되었습니다.");
			}else {
				System.out.println(deptno + "번 부서는 유효하지 않아 삭제 불가합니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + deptno); // 오류메시지와 함께 deptno 출력
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} // close
		} // try-catch-finally
		return result;
	}
}

package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.Person;

public class PersonRepository {
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
	private String id = "scott";
	private String pw = "tiger";
	// final static 변수 생성 (insert 결과 반환)
	public final static int SUCCESS = 1;
	public final static int FAIL    = 0;
	// 인스턴스 변수 생성
	private static PersonRepository INSTNACE = new PersonRepository();
	// INSTANCE 주소 반환하는 getinstance()
	public static PersonRepository getInstance() {
		return INSTNACE;
	}
	// 1, 2번 기능에서 사용 가능한 작업명들
	public ArrayList<String> jnameList(){
		ArrayList<String> jnames = new ArrayList<String>();
		Connection 		  conn  = null; // 모듈에 추가
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT JNAME FROM JOB";
		
		try {
			conn  = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) { // rs.next true면 arraylist에 jname 추가
				jnames.add(rs.getString("jname")); 
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
			}
		} // try-catch-finally
		return jnames;
	} // jnameList
	
	// 1번 기능: PNAME, JNAME, KOR, ENG, MAT를 입력받아 PERSON 테이블 INSERT
	public int insertPerson(String pname, String jname, int kor, int eng, int mat) {
		int result = FAIL; // 초기값(최악의 경우)
		// insert
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON (PNO, PNAME, JNO, KOR, ENG, MAT)"
				+ "		    VALUES (PERSON_SEQ.NEXTVAL, ?,"
				+ "		            (SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			pstmt.setString(2, jname);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, mat);
			result = pstmt.executeUpdate();
			if(result == SUCCESS) {
				System.out.println("입력에 성공했습니다");
			}else {
				System.out.println("입력에 실패했습니다");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + pname + jname + kor + eng + mat);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		return result;
	} // insertPerson
	
	// 2번 기능: JNAME을 입력받아 RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력
	public ArrayList<Person> getPerson(String jname) {
		ArrayList<Person> persons = new ArrayList<Person>();
		Connection        conn    = null;
		PreparedStatement pstmt   = null;
		ResultSet         rs      = null;
		String sql = "	SELECT ROWNUM \"RANK\", A.*"
				+ "	    FROM (SELECT PNAME || '(' || PNO || '번)' \"PNAME\", JNAME, KOR, ENG, MAT, KOR+ENG+MAT \"SUM\""
				+ "	                FROM PERSON P, JOB J "
				+ "	                WHERE J.JNO = P.JNO AND JNAME = ?"
				+ "	                ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				persons.add(new Person(rank, pname, jname, kor, eng, mat, sum));
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
			}
		} // try-catch-finally
		return persons;
	} // getPerson(jname)
	
	// 3번 기능: RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력
	public ArrayList<Person> getPerson() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Connection        conn    = null;
		PreparedStatement pstmt   = null;
		ResultSet         rs      = null;
		String sql = "SELECT ROWNUM \"RANK\", A.*"
				+ "	    FROM (SELECT PNAME || '(' || PNO || ')' \"PNAME\", JNAME, KOR, ENG, MAT, KOR+ENG+MAT \"SUM\""
				+ "	    FROM PERSON P, JOB J"
				+ "	    WHERE P.JNO = J.JNO"
				+ "	    ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				persons.add(new Person(rank, pname, jname, kor, eng, mat, sum));
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
			}
		} // try-catch-finally
		return persons;
	} // getPerson(jname)
}

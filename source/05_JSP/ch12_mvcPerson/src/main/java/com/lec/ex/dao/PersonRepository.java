package com.lec.ex.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.Person;

public class PersonRepository {
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	private DataSource ds;
	private static PersonRepository INSTANCE;
	public static PersonRepository getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PersonRepository();
		}
		return INSTANCE;
	}
	
	// Connection Pull
	private PersonRepository () {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 1-1. public ArrayList<Person> getPersonList()
	public ArrayList<Person> getPersonList(){
		ArrayList<Person> persons = new ArrayList<Person>();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT * FROM PERSON";
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(sql);
			while(rs.next()) {
				int 	  id      = rs.getInt("id");
				String    name    = rs.getString("name");
				String    tel     = rs.getString("tel");
				String    address = rs.getString("address");
				Date      birth   = rs.getDate("birth");
				String    memo    = rs.getString("memo");
				Timestamp rdate   = rs.getTimestamp("rdate");
				persons.add(new Person(id, name, tel, address, birth, memo, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null)   rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return persons;
	}
	
	// 1-2. public ArrayList<Person> getPersonList(int startRow, int endRow) / top-N 
	public ArrayList<Person> getPersonList(int startRow, int endRow){
		ArrayList<Person> persons = new ArrayList<Person>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * "
				+ "     FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM PERSON ORDER BY ID DESC) A)"
				+ "     WHERE RN BETWEEN ? AND ?";
		try {
			conn  = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				int 	  id     = rs.getInt("id");
				String    name    = rs.getString("name");
				String    tel     = rs.getString("tel");
				String    address = rs.getString("address");
				Date      birth   = rs.getDate("birth");
				String    memo    = rs.getString("memo");
				Timestamp rdate   = rs.getTimestamp("rdate");
				persons.add(new Person(id, name, tel, address, birth, memo, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return persons;
	}
	
	// 2. public int getCount(): PAGING 처리시 필요한 전체 갯수
	public int getCount() {
		int count = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM PERSON";
		try {
			conn  = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
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
		}
		return count;
	}
	
	// 3. 추가: public int insertPerson(Person person)
	public int insertPerson(Person person) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = " INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO)"
				+ "	 VALUES (PERSON_ID_SEQ.NEXTVAL, ? , ?, ?, ?, ?)";
		try {
			conn  = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getTel());
			pstmt.setString(3, person.getAddress());
			pstmt.setDate(4, person.getBirth());
			pstmt.setString(5, person.getMemo());
			pstmt.executeQuery();
			result = SUCCESS;
			System.out.println("추가 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "추가 실패");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 4. 한 명 출력: public Person getPerson(int id)
	public Person getPerson(int id) {
		Person person = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM PERSON WHERE ID=?";
		try {
			conn  = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String    name    = rs.getString("name");
				String    tel     = rs.getString("tel");
				String    address = rs.getString("address");
				Date      birth   = rs.getDate("birth");
				String    memo    = rs.getString("memo");
				Timestamp rdate   = rs.getTimestamp("rdate");
				person = new Person(id, name, tel, address, birth, memo, rdate);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return person;
	}
	
	// 5. 수정: public int updatePerson(Person person)
	public int updatePerson(Person person) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE PERSON"
				+ "     SET NAME = ?, TEL=?, ADDRESS=?, BIRTH=?, MEMO=?"
				+ "     WHERE ID=?";
		try {
			conn  = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getTel());
			pstmt.setString(3, person.getAddress());
			pstmt.setDate(4, person.getBirth());
			pstmt.setString(5, person.getMemo());
			pstmt.setInt(6, person.getId());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println(result==SUCCESS ? "수정성공" : "수정실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage() + person + "제약조건에 맞지 않아 오류");
			}
		}
		return result;
	}
	
	
	// 6. 삭제: public int deletePerson(int id)
	public int deletePerson(int id) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM PERSON WHERE ID=?";
		try {
			conn  = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println(result==SUCCESS ? "삭제성공":"삭제실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
}

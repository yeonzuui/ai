package com.lec.dto;
// DEPT DTO (클래스명과 DTO명 같게 하는 것이 추세)
public class Dept {
	// 데이터(DEPT 테이블의 column 선언)
	private int    deptno;
	private String dname;
	private String loc;
	
	// 생성자 함수
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	// toString override
	@Override
	public String toString() {
		return deptno + "\t" + dname + "\t" + loc;
	}
	
	// getter&setter
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	
	
	
}

package com.lec.dto;
// Dept_Dto(Loc 제외)
public class Dept {
	// data
	private int    deptno; 
	private String dname;
	
	// Constructor
	public Dept(){}
	public Dept(int deptno, String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}
	
	
	// getter & setter
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
	
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + "]";
	}
	
	
	
}

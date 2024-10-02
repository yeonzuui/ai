package com.lec.dto;
// Emp DTO

import java.sql.*; // 모듈에 넣어야 error 사라짐

public class Emp {
	// 데이터(Emp 테이블의 column 선언)
	private int    empno;
	private String ename;
	private String job;
	private String mgr;
	private Date   hiredate;
	// private Timestamp hiredate2; // 시간과 날짜
	private int    sal; // 10자리 넘으면 변수 타입 long
	private int    comm;
	private int    deptno;
	
	// 생성자 함수(매개변수 있음, super(); 지우기)
	public Emp(int empno, String ename, String job, String mgr, Date hiredate, int sal, int comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	// toString override
	@Override
	public String toString() {
		if(job.length() < 8) { // if-else문으로 job 뒤의 여백 조정
			return empno + "\t" + ename + "\t" + job + "\t\t" + 
					(mgr == null ? " - " : mgr) + "\t" + hiredate
					+ "\t" + sal + "\t" + comm + "\t" + deptno;
		}else {
			return empno + "\t" + ename + "\t" + job + "\t" + 
					(mgr == null ? " - " : mgr) + "\t" + hiredate
					+ "\t" + sal + "\t" + comm + "\t" + deptno;
		}
	}
	
	// getter&setter
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
}

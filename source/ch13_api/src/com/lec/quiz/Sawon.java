package com.lec.quiz;
// Sawon s = new sawon("24a001", "홍길동", Sawon.COMPUTER, 2024, 9,9)
// new sawon("24a001", "홍길동", Sawon.COMPUTER)

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	public static final String COMPUTER = "전산실";
	public static final String PLANNING = "기획팀";
	public static final String DESIGN   = "설계팀";
	
	// data
	private String no;     // 사번
	private String name;   // 사원명
	private String dept;   // 부서명
	private Date hiredate; // 입사일
	
	// Conductor
	public Sawon(String no, 
			     String name, 
			     String dept) { // hiredate 제외
		this.no = no;
		this.name = name;
		this.dept = dept;
		hiredate = new Date();
	}
	
	public Sawon(String no, 
		         String name, 
		         String dept,
		         int    y, 
		         int    m, 
		         int    d) { // hiredate 제외
	this.no   = no;
	this.name = name;
	this.dept = dept;
//	hiredate = new Date(y-1900, m-1, d); // 연도-1900, 컴퓨터는 월을 0부터 count, m-1
	hiredate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	} // sysout(s) 

	@Override
	public String toString() {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy년 M월 d일(E)");
		return "[사번]" + no + " [이름]" + name +  "[부서]" + dept + " [입사일]" + sdf.format(hiredate);
	} 
}




















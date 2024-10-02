package com.lec.dto;
// PERSON DTO
public class Person {
	// 데이터
	private int rank;
	private int pno;
	private String pname;
	private String jname;
	private int jno;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	
	// 생성자
	public Person(int rank, String pname, String jname, int kor, int eng, int mat,  int sum) {
		this.rank = rank;
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}
	// ToString override
	@Override
	public String toString() {
		if(pname.length() < 7) {
			return rank + "\t" + pname + "\t\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum;
		}else {
			return rank + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum;
		}
	}	
}

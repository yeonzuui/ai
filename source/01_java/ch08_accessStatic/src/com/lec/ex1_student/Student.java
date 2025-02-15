package com.lec.ex1_student;
// 데이터 : name(String), kor(int), eng(int), mat(int), tot(int), avg(double;소수점)
// 생성자 : new Student("정우성", 90, 90, 90)
// method : inforPrint(), inforString()
public class Student {
	// 데이터(속성, 인스턴스변수)
	private String  name;
	private int     kor;
	private int 	eng;
	private int		mat;
	private int 	tot;
	private double	avg;
	// ------------------------------------------------------------------------------------
	// 생성자 함수
	public Student() {} // 디폴트 생성자 // 필수는 아니지만 상속 시 편해
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3.0;
//		avg = (double)tot/3; // 정수-정수 연산은 정수가 되어 소수점 데이터가 손실될 수 있음
	}
	// ------------------------------------------------------------------------------------
	// method
	public void infoPrint() {
		// \t정우성\t100\t100\t100\t300\t100.0 → 평균은 소수점 포함해서 5자리
		// \t정우성\t90\t90\t90\t270\t90.0
		System.out.printf("\t%s\t%3d\t%3d\t%3dt%3d\t%5.1f",name, kor, eng, mat, tot, avg);
	}
	public String infoString() {
		return String.format("\t%s\t%3d\t%3d\t%3d\t%3d\t%5.1f", name, kor, eng, mat, tot, avg);
	}
	// ------------------------------------------------------------------------------------
	// setter&getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}

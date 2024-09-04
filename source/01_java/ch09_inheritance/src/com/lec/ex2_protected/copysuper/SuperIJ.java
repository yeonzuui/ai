package com.lec.ex2_protected.copysuper;

public class SuperIJ {
	// 데이터
	protected int i;
	protected int j;
	
	// 생성자함수
	public SuperIJ() {
		// 부모클래스 생성자 함수는 기본적으로 매개변수 없는 생성자 호출
		System.out.println("매개변수 없는 SuperIJ 생성자 함수");
	} // default
	public SuperIJ(int i, int j) {
		System.out.println("매개변수 있는 SuperIJ 생성자 함수. i와 j 초기화");
		this.i = i;
		this.j = j;
	} // 매개변수 有
	
	// getter&setter
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
} // class

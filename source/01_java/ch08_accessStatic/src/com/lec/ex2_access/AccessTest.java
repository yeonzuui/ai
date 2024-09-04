package com.lec.ex2_access;

public class AccessTest {
	private int privateMember; // 같은 클래스 내
			int defualtMember; // 디폴트 접근 제한 : 같은 패키지 내
	protected int protectedMember; // 같은 패키지나 상속받은 클래스
	public int publicMember; // 아무데서나
	//-------------------------------------------------------------------------------------------
	// 생성자 함수 생략(default)
	// method
	private void privateMethod() {
		System.out.println("private 메소드");
	}
	void defualtMethod() {
		System.out.println("default 메소드");
	}
	protected void protectedMethod() {
		System.out.println("protected 메소드");
	}
	public void publicMethod() {
		System.out.println("public 메소드");
	}
}
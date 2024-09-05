package com.lec.ex1;
// 추상method, static final 변수(상수)만 가능
public interface InterfaceEx1 {
	// 데이터
	// private 못 씀, 전부 public 써야 해
	public /*static final*/ int CONSTANT_NUM = 10; // 생략 가능
	
	// method 
	public /*abstract*/ void method1(); // 생략 가능

}

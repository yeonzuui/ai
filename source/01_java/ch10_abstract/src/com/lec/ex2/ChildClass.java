package com.lec.ex2;
// 추상 class로부터 상속받았으면 (보이지 않더라도) 추상 method 존재
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의 method1 - 추상메소드라서 반드시 오버라이드 함");
	}
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2 - 걍 오버라이드 함");
	}
}

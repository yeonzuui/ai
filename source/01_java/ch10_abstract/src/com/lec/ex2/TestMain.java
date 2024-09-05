package com.lec.ex2;

public class TestMain {
	public static void main(String[] args) {
		// 추상 class는 객체 만들 수 없음
		// SuperClass obj = new SuperClass();
		
		// 앱 만들 때:  Anonymous(익명) 타입
		SuperClass obj = new SuperClass() {
			@Override
			public void method1() { // method2, method3은 SuperClass것으로
				System.out.println("익명클래스의 method1");
			}
		};
		obj.method1();
		obj.method2();
		obj.method3();
		
		SuperClass obj1 = new ChildClass();
		obj1.method1();
		obj1.method2();
		obj1.method3();
	} // main
} // class

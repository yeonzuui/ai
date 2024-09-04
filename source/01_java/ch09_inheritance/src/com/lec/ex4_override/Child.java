package com.lec.ex4_override;
// method1(), method2()
public class Child extends Parent {
	// 생성자 함수
	public Child() {
		System.out.println("매개변수 없는 Child 생성자");
	}
	
	public Child(int i) {
		System.out.println("매개변수 있는 Child 생성자");
	}
	// Parent로부터 override
	@Override
	public void method1() { // override = 함수의 재정의 // Parent의 method1() 없어짐
		System.out.println("Child의 method1");
	}
	public void method3() {
		System.out.println("Child의 method3");
	}
	// Object의 equals()없애고, override
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
}

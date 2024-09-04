package com.lec.ex2_protected;

public class ChildTestMain {
	public static void main(String[] args) {
		Child child1 = new Child(1,2);
		// 매개변수 있는 Superclass의 생성자 함수는 호출 불가
		child1.setI(1); child1.setI(2);
		child1.sum();
		System.out.println("==========");
		Child child2 = new Child(10,20);
		child2.sum();
		
	}
}

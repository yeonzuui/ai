package com.lec.ex4_Object;

public class Ex1_PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person(9812121021452L);
		Person p2 = new Person(9812121021452L);
		Person p3 = null; // 결측치, 쓰레기값 아냐
		String name = "홍길동";
		System.out.println(p1 == p2 ? "같은 주소" : "다른 주소");
		System.out.println(p1.equals(p2) ? "같은 사람" : "다른 사람");
		System.out.println(p1.equals(p3) ? "같은 사람" : "다른 사람");
		System.out.println(p1.equals(name));
		System.out.println(p1.toString());
		System.out.println(p2);
		System.out.println(p3);
	}
}

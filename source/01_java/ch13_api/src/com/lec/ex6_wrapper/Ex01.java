package com.lec.ex6_wrapper;

import com.lec.ex4_Object.Person;

// Wrapper 클래스
public class Ex01 {
	public static void main(String[] args) {
		String name      = "홍길동";
		String othername = "홍길동";
		Person p = new Person(9812122015478L);
		System.out.println(name.equals(10));               // 원래는 기초데이터타입(int)오면 안 돼야 맞음
//		System.out.println(name.equals(new Integer(10)));  // 자동적으로 integer 객체가 들어가게 변환(내부적으로)
		System.out.println(name.equals(10.9));             // 기초데이터 타입인 double도 불가능
//		System.out.println(name.equals(new Double(10.9))); // 자동적으로 Double로 변환해줌(내부적으로)
		
		// Wrapper 클래스 필요성
	}
}









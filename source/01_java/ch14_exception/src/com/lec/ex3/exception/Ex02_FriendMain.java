package com.lec.ex3.exception;

import java.util.Date;

public class Ex02_FriendMain {
	public static void main(String[] args) {
		// 객체 변수(friend1) 생성
		Friend friend1 = new Friend("홍길동", 
									"010-9999-9999", 
									new Date(98, 8, 10));
		// friend1 출력: 원하는 대로 출력 불가 - toString override
		System.out.println(friend1);
		
		// 객체 변수(friend2) 생성
				Friend friend2 = new Friend("홍길동", 
											"010-9999-9999", 
											new Date(98, 8, 9));
		// friend2 출력
		System.out.println(friend2);
		
		// 객체 변수(friend3) 생성 -----tel과 birthday는 null값이 들어있다
		Friend friend3 = new Friend("김길동");
		System.out.println(friend3);
		// 객체 변수(friend4) 생성
		Friend friend4 = new Friend("박길동", "010-7894-4564");
		System.out.println(friend4);
	}
}

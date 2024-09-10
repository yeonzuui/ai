package com.lec.ex4_account;

public class AccountTestMain {
	public static void main(String[] args) {
		// 객체 변수(hong) 생성
		Account hong = new Account("100-1", "홍길동");
		hong.deposit(100);
		// try-catch: 예외처리
		try {
			hong.withdraw(150);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		hong.infoPrint();  
		System.out.println(hong.infoString());
		
		// 객체 변수(hong1) 생성
		Account hong1 = new Account("010-2", "홍길순", 220000000L);
		// 예외 발생 안되는 상황이라도 compile 인식 못 해. try-catch 해주자
		try {
			hong1.withdraw(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(hong1.infoString());
	} // main
} // class
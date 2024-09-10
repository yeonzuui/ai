package com.lec.ex2_throws;

public class ThrowsTestMain {
	public static void main(String[] args) {
		// 객체 변수 생성
		try {
			new ThrowsEx();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // try-catch
	} // main
} // class

// main 함수에서는 예외처리 않는 것을 추천 (발생하는 부분만 하기)
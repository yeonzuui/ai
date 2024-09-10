package com.lec.ex3.exception;
// NullPointerException : 자주 발생하는 예외 type, 
public class Ex01_NullPointEx {
	public static void main(String[] args) {
		// greeting 변수 생성
		String greeting = "Hello";
		// substring(n): 인덱스 n번째부터 끝까지 출력
		System.out.println(greeting.substring(2));
		// 변수 초기화
		greeting = null; // Hello 사라짐(garbage collection)
		// Error
		System.out.println(greeting.substring(2));
	}
}
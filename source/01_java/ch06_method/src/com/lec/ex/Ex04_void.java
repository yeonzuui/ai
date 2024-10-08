package com.lec.ex;

// return이 없는 메소드의 타입은 void로
public class Ex04_void {
	public static void main(String[] args) {
		printLine(30);
		System.out.println("Hello, world!");
		printLine("=");
		System.out.println("Hello, Java");
		printLine(30, "~");
		System.out.println("Hello, world!");
		printLine();
	} // main
	
// printLine() 함수 오버로딩
// 매개변수의 type만 다르다면 무제한 가능
	private static void printLine(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print('-');
		}
		System.out.println(); // 개행
	} // printLine - 매개변수 int
	
	private static void printLine(String ch) {
		for (int i = 0; i < 20; i++) {
			System.out.print(ch);
		}
		System.out.println(); // 개행
	} // printLine - 매개변수 String
	
	private static void printLine() {
		for (int i = 0; i < 20; i++) {
			System.out.print('-');
		}
		System.out.println(); // 개행
	} // printLine - 매개변수 無
	
	private static void printLine(int cnt, String ch) {
		for (int i = 0; i < cnt; i++) {
			System.out.print(ch);
		}
		System.out.println(); // 개행
	} // printLine - 매개변수 2개
} // class

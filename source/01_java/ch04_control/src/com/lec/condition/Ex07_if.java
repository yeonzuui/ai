package com.lec.condition;

import java.util.Scanner;

// 입력받은 수가 홀수인지 짝수인지 출력(if, switch, 삼항연산자)
public class Ex07_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요.");
		int num = sc.nextInt();
		
//		if문
//		if (num % 2 == 0) {
//			System.out.println("짝수");
//		} else {
//			System.out.println("홀수");
//		}
		
//		삼항연산자
//		System.out.println( num % 2 == 0 ? "짝수" : "홀수");
		
//		switch문
		switch (num % 2) { // -1 0 1
		case 0:
			System.out.println("짝수"); break;
		default:
			System.out.println("홀수"); 
		}
		
	} // main
} //class

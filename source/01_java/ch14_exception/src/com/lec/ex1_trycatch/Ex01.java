package com.lec.ex1_trycatch;
// 예외: 실행됐었다가 뜻하지 않은 error
// 예외처리는 일종의 보험
// try-catch: 내가 보험처리
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		// 사용자로부터 두 수(i,j)를 입력받기 
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 정수는 : ");
		int i = scanner.nextInt();
		System.out.print("두번째 정수는 : ");
		int j = scanner.nextInt();
		
		// 나눗셈, 곱셈, 덧셈, 뺄셈 출력
		System.out.println("i/j = " + (i/j)); 
		System.out.println("i*j = " + (i*j));
		System.out.println("i+j = " + (i+j));
		System.out.println("i-j = " + (i-j));
		scanner.close();
	}
}

// 0일때 나눗셈 실행 불가
// java.lang.ArithmeticException by zero → 예외 객체가 자동 생성됨


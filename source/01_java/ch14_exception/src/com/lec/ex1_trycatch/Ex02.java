package com.lec.ex1_trycatch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		// 사용자로부터 두 수(i,j)를 입력받기 
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 정수는 : ");
		int i = scanner.nextInt();
		System.out.print("두번째 정수는 : ");
		int j = scanner.nextInt();
		
		// 나눗셈, 곱셈, 덧셈, 뺄셈 출력
		try {
			System.out.println("i/j = " + (i/j)); 
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("i*j = " + (i*j));
		System.out.println("i+j = " + (i+j));
		System.out.println("i-j = " + (i-j));
		scanner.close();
	}
}

// 0일때 나눗셈 실행 불가(예외: 실행됐었다가 뜻하지 않은 error)
// java.lang.ArithmeticException by zero → 예외 객체가 자동 생성됨
// 예외처리는 일종의 보험
// try{ 예외가 발생할 수도 있는 부분 }catch( 예외객체변수 선언 ){ 예외시 실행할 코드 }로 감싸기
// getMessage(): 에러메시지 반환
// catch절은 예외 발생할 때만 수행됨

// 정수 입력받는 곳에 int 말고 다른 type 입력하면 실행 불가(내부적으로 오류)
// java.util.InputMismatchException → 예외 종류에 따라 다른 예외 객체 생성됨

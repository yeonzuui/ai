package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;
// 첫번째 정수를 제대로 입력할 때까지 입력받음
// 두번째 정수를 제대로 입력하지 않으면 1로 할당받고, 곱셈, 덧셈, 뺼셈을 출력하도록
// 첫번째 정수 → try 감싸고, do-while 감싸기
public class Ex03 {
	public static void main(String[] args) {
		// 사용자로부터 두 수(i,j)를 입력받기 
		Scanner scanner = new Scanner(System.in);
		int i=0, j=1; // i,j는 try절 밖으로 빼고 초기화
		do {
			try {
				System.out.print("첫번째 정수는 : ");
				i = scanner.nextInt(); break;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				scanner.nextLine(); // 버퍼 지우기. next()도 가능
			}
		} while (true);
		
		System.out.print("두번째 정수는 : ");
		try {
			j = scanner.nextInt();
			System.out.println("i/j = " + (i/j)); // 나눗셈
		} catch (InputMismatchException e) {
			System.out.println("두번째 정수를 잘못 입력하셔서 1로 처리합니다" + e.getMessage());
			j = 1;
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌수는 없습니다" + e.getMessage());
		}
		System.out.println("i*j = " + (i*j)); // 곱셈
		System.out.println("i+j = " + (i+j)); // 덧셈
		System.out.println("i-j = " + (i-j)); // 뺄셈
		scanner.close();
	}
}

// 0일때 나눗셈 실행 불가(예외: 실행됐었다가 뜻하지 않은 error)
// java.lang.ArithmeticException by zero → 예외 객체가 자동 생성됨
// 예외처리는 일종의 보험

// try{ 예외가 발생할 수도 있는 부분 }catch( 변수타입 예외변수선언 ){ 예외 시 실행할 코드 }finally{ 예외발생 무관하게 맨 마지막에 실행할 코드 }로 감싸기
// getMessage(): 에러메시지 반환
// catch절은 예외 발생할 때만 수행됨

// 정수 입력받는 곳에 int 말고 다른 type 입력하면 실행 불가(내부적 오류)
// java.util.InputMismatchException → 예외 종류에 따라 다른 예외 객체 생성됨
// 중복 try문 허용하지 않음(실행은 가능하나 절대 그렇게 짜지 않음)
// catch절이 여러 개일 때, catch절 내 예외변수type은 상속관계에 있지 않아야 함 (ex. Exception - ArithmeticException)

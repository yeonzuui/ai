package com.lec.Quiz;

import java.util.Scanner;

// 사용자로부터 구구단 수를 입력받아 gugudanOut(입력받은 수) 호출 -> 호출한 메소드에서 대항 구구단 출력
public class Quiz_gugudan {
	
// Java에서는 method가 main 밖에 위치해야 함 // return값이 없으니까 void
	public static void gugudanOut(int value) {
		for (int i=1; i<=9; i++) {
			System.out.printf("%d X %d = %d\n", value, i, value * i);
		} // for
	} // gugudanOut

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("출력하고자 하는 구구단 수는 > ");
		int dansu = scanner.nextInt();
		System.out.println("입력하신 구구단 수는 > " + dansu);
		gugudanOut(dansu);
		scanner.close();
	} // main
} // class
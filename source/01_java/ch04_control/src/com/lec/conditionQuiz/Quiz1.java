package com.lec.conditionQuiz;

import java.util.Scanner;

// 수를 입력받아 절댓값 출력
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 → ");
		int num = sc.nextInt();
			
		if (num >= 0) {
			System.out.printf("입력하신 수의 절댓값은 %d\n,", num);
		}else {
			System.out.printf("입력하신 수의 절댓값은 %d\n,", -num);
		}
		sc.close();
	}//main
}//class

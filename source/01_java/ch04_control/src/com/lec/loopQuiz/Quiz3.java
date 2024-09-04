package com.lec.loopQuiz;

import java.util.Scanner;

// 사용자로부터 원하는 구구단을 입력받아 해당 구구단만 출력
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇단 구구단을 출력할까요 > ");
		int dansu = sc.nextInt(); // 입력받기
		// 구구단 생성
		for (int i=2 ; i<=9 ; i++) { 
//			System.out.println(dansu + " * " + i + " = "  + dansu*1);
			System.out.printf("%d * %d = %d\n", dansu, i, dansu*1);
		}
		sc.close();
	} //main
} //class

package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz3_gugudan {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇단 구구단을 출력할까요 > ");
		int dansu = scanner.nextInt();
		for(int i=1 ; i<=9 ; i++) {
			System.out.println(dansu + " * " + i + " = " + dansu*i);
		}
		scanner.close();
	}
}

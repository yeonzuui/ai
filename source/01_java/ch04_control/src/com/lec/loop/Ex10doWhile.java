package com.lec.loop;

import java.util.Scanner;

// 짝수를 입력받아 출력
public class Ex10doWhile {
	public static void main(String[] args) {
		Scanner	scanner = new Scanner(System.in); // new: 주소를 scanner에 할당
		int num;
		do {
			System.out.print("짝수를 입력하세요 >");
			num = scanner.nextInt();
		} while ( num%2 != 0 );
		System.out.println("입력하신 짝수는 " + num);
		scanner.close();
	} //main
} //class	
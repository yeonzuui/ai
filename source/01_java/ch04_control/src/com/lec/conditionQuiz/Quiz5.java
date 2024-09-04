package com.lec.conditionQuiz;

import java.util.Scanner;

// 현재 몇월인지 입력받아 계절을 출력
public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("지금 몇 월? ");
		int month = sc.nextInt();

		String monStr;
		switch (month) {
		case 1:
		case 2:
		case 12:
			monStr = "겨울"; break;
		case 3:
		case 4:
		case 5:
			monStr = "봄"; break;
		case 6:
		case 7:
		case 8:
			monStr = "여름"; break;
		case 9:
		case 10:
		case 11:
			monStr = "가을"; break;
		default:
			monStr = "값이 올바르지 않습니다";
		}
		
//		if(month==12 || month==1 || month==2) {
//			System.out.println("입력하신 개월은 겨울이네요");
//		}else if(month==3 || month==4 || month==5) {
//			System.out.println("입력하신 개월은 봄이네요");
//		}else if(month==6 || month==7 || month==8) {
//			System.out.println("입력하신 개월은 여름이네요");
//		}else if(month==9 || month==10 || month==11) {
//			System.out.println("입력하신 개월은 가을이네요");
//		}else {
//			System.out.println("유효한 개월 수가 아닙니다.");
//		}
		
		sc.close();
		System.out.printf("입력하신 달, %d월의 계절은 %s입니다.", month, monStr);
	}// main
}// class

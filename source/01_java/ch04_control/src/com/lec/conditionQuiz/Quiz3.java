package com.lec.conditionQuiz;

import java.util.Scanner;

// 가위바위보 출력. 단, 가위(0), 바위(1), 보(2)
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) 입력: ");
		int you = sc.nextInt();
		String youStr;
				
//		if문
		if (you == 0) {
			youStr = "가위";
		} else if (you == 1) {
			youStr = "바위";
		} else if (you == 2){ 
			youStr = "보";
		} else {
			youStr = "유효하지 않은 값";
		}
//		switch (you) {
//		case 0:
//			youStr = "가위"; break;
//		case 1:
//			youStr = "바위"; break;
//		case 2: 
//			youStr = "보"; break;
//		default:
//			youStr = "유효하지 않은 값"
//		}
		
//		youStr = (you==0)? "가위": (you==1)? "바위": (you==2)?"보":"유효하지 않는 값";
		
		System.out.printf("당신은 %s을(를) 내셨습니다", youStr);
		sc.close();
	}//main
}//class

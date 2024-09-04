package com.lec.conditionQuiz;

// 두 수 중 max 출력
public class Quiz2 {
	public static void main(String[] args) {
		int num1 = 17;
		int num2 = 5;
//		방법1. 변수 max를 if문 밖에서 선언
		int max;
		if (num1 > num2) {
			max = num1;
		} else {
			max = num2;
		}
		System.out.println(max);

//		방법2. 변수 max를 if문 안에서 선언
//		if (num1 > num2) {
//			int max = num1;
//			System.out.println(max);
//		} else {
//			int max = num2;
//			System.out.println(max);
//		}
	}//main
}//class

// alt 화살표     : 소스 한줄 이동
// ctrl alt 화살표: 소스 한줄 복사 

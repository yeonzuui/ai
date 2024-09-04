package com.lec.loopQuiz;
// 구구단식 출력 (9마다 개행)
// 2*1=2 3*1=3 ... 9*1=9
// ...
// 2*9=18 3*9=27 ... 9*9=81
public class Quiz4 {
	public static void main(String[] args) {
		// 중첩 for문
		for(int j=1 ; j<=9 ; j++) {
			for (int i=2 ; i<=9 ; i++) {
				System.out.printf("%d * %d = %2d\t", i, j, i*j); // %2d 두자리수
			}//for-i
			System.out.println(); //개행만 추가
		}//for-j
	}//main
}//class
package com.lec.loop;
/*
 * *
 * * *
 * * * *
 * * * * *
 */
public class Ex04for {
	public static void main(String[] args) {
		// 중첩구문
		for (int i=1 ; i<=5 ; i++) { // j 1~5까지 반복
			for(int j=1 ; j<=i ; j++) { // i가 j보다 작거나 같으면 * 추가
				System.out.print("* "); // 여기서는 개행 안 바꿔 
			} //for-j
			System.out.println(); // println → or문 실행할 때마다 개행 바꿔
		} //for-i
	} //main
} //class
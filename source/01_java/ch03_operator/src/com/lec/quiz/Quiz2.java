package com.lec.quiz;

import java.util.Scanner;

// 국어, 영어, 수학 점수를 사용자에게 입력받아, 각 점수를 출력하고 총점, 평균(소수점 2자리까지) 출력하는 프로그램을 구현하시오(산술연산자/참조)
public class Quiz2 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력하세요");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 입력하세요");
		int mat = sc.nextInt();		
		int tot = kor + eng + mat;
//		double avg = (double)tot /3;
		double avg = tot / 3. ;
		System.out.printf("국어 점수는 , %d\n", kor);
		System.out.printf("영어 점수는 , %d\n", eng);
		System.out.printf("수학 점수는 , %d\n", mat);
		System.out.printf("총점은 %d\n ", tot);
		System.out.printf("평균은 %.2f\n ", avg);
		sc.close();
	}
}
package com.lec.ex;

// x부터 y까지 정수 합과 그 결과가 짝/홀인지 출력
public class Ex01_noMethod {
	public static void main(String[] args) {
		int tot = 0; // 누적변수
		for (int i=1; i<=10; i++) {
			tot += i;
		} // for
		System.out.println("1부터 10까지 정수의 합은: " + tot);
		System.out.println(tot % 2 == 0 ? "짝수입니다" : "홀수입니다"); // 삼항연산자
		//--------------------------------
		tot = 0; // 누적변수
		for (int i = 10; i <= 100; i++) {
			tot += i;
		} // for
		System.out.println("10부터 100까지 정수의 합은: " + tot);
		System.out.println(tot % 2 == 0 ? "짝수입니다" : "홀수입니다");
		//--------------------------------
		tot = 0; // 누적변수
		for (int i = 5; i <= 10; i++) {
			tot += i;
		} // for
		System.out.println("10부터 100까지 정수의 합은: " + tot);
	} // main
} // class
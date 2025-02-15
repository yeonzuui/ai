package com.lec.method;
// 수학적 method만 모아놓은 class => Arithmetic
public class ArPractice {
	
	// method 1) abs(절댓값; absolute value)
	public static int abs(int value) {
		int result = (value >= 0) ? value : -value;
		return result;
	}
	
	// sum / overloading(과적)
	// method 2) from-to까지의 누적합을 return - 매개변수 2개 
	public int sum(int from, int to) {
		int sum = 0; // 누적변수
		for (int i= from ; i <= to; i++) {
			sum += i ;
		}
		return sum;
	}
	
	// method 3) 1-to까지의 누적합을 return - 매개변수 1개
	// 매개변수 1개
	public int sum(int to) {
		int sum = 0; // 누적변수
		for (int i=1; i<=to; i++) {
			sum += i;
		}
		return sum;
	}
	
	// method 4) value의 짝/홀을 return
	public String evenOdd(int value) {
		String result = value%2 == 0 ? "짝수입니다" : "홀수입니다"; // 삼항연산
		return result;
	}
} // class










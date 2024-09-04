package com.lec.method;
// Arithmetic 클래스에는 수학적 method만 모아놓음 
// sum(10, 100), sum(10)-함수 overloading / evenOdd(10)  / abs(-9)
// 컴퓨터는 method 4개로 인식
public class Arithmetic {
	
	public static int abs(int value) { // value의 절댓값을 return
		int result = (value >= 0) ? value : -value;
		return result;
	}
	
	// static 안 씀 → 다른 class에서 끌어오고 싶을 땐 객체 만들고 할당해서 사용해야 함
	// static은 나중에 파이썬 이미지 학습에서 사용해야 함
	// 귀찮지만 사용해야 하는 상황이 있음 
	
	// sum이라는 method를 overloading(과적)
	public int sum(int from, int to) { // 변수명은 임의로 // from부터 to까지 누적합 return
		int sum = 0; // 누적변수
		for (int i = from; i <= to; i++) {
			sum += i; // sum = sum +i;
		} // for
		return sum; // return
	} // sum - 매개변수 2개 	
	public int sum(int to) { // 1부터 to까지 누적합 return
		int result = 0;
		for(int i=1 ; i <=to ; i ++) {
			result += i ;
		}
		return result;
	} // sum - 매개변수 1개 
	
	public String evenOdd(int value) { // value가 짝/홀인지를 return
		String result = value%2==0 ? "짝수입니다" : "홀수입니다";
		return result;
//		if(value%2==0) {
//			return "짝수입니다";
//		}else {
//			return "홀수입니다";
//		}
	} // evenOdd
} // class
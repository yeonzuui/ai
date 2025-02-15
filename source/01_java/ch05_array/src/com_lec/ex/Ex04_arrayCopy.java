package com_lec.ex;
// 깊은 복사(데이터조작 불가)
public class Ex04_arrayCopy {
	public static void main(String[] args) {
		int[] score = { 100, 20, 30, 40, 50 };
		int[] s = new int[score.length]; // new 청소
		// s는 청소된 상태, score의 인덱스값을 s에 할당
		System.arraycopy(score, 0, s, 0, score.length); 
//		for (int idx = 0; idx < s.length; idx++) {
//			s[idx]=score[idx]; 
//		}
		for (int idx = 0; idx < score.length; idx++) {
			System.out.printf("score[%d]=%d \t s[%d]=%d\n", idx, score[idx], idx, s[idx]); 
		}
		s[0]=99; // s의 0번째 인덱스만 변경
		for (int idx = 0; idx < score.length; idx++) {
			System.out.printf("score[%d]=%d \t s[%d]=%d\n", idx, score[idx], idx, s[idx]); // score[0]값은 불변
		}
	} // main
} // class

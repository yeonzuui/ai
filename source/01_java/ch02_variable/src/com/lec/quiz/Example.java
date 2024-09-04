package com.lec.quiz;
// 국어, 영어, 수학 점수를 할당하고, 각 점수와 총점을 출력
public class Example {
	public static void main(String[] args) {
//		int kor = 100, eng = 90, mat= 99;
		int kor = 100;
		int eng = 80;
		int mat = 99;
		int tot = kor + eng + mat;
	System.out.println("국어 : " + kor + " 영어: " + eng + " 수학 : " + mat);
	System.out.println("총점 : " + tot);
	}
}

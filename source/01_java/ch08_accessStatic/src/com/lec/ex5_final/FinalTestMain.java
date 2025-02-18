package com.lec.ex5_final;

import constant.Constant;

// final 변수 : 수정 불가(고정값)
public class FinalTestMain {
	public static void main(String[] args) {
		final double PI = 3.141592; // final 변수는 대문자로 쓴다
		double r = 3.0;
		r = 5;
//		PI = 3.1415926535; // Error: PI cannot be assigned. 할당 불가
		double area = r * r * Constant.PI;
		System.out.println(area);
	}

}
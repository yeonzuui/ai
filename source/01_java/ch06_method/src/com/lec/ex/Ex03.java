package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9의 절댓값: " + Arithmetic.abs(-9));
//		System.out.println(Math.random()); // = Arithmetic
//		int tot = Arithmetic.sum(10, 100); // static 메소드가 아니라서 Error
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(100);
		System.out.println("합은 " + tot);
		System.out.println(ar.evenOdd(tot));
	} // main
} // class
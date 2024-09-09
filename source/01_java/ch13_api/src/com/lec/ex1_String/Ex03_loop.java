package com.lec.ex1_String;

import java.util.Scanner;

// I: 입력로직, U: 수정로직, X: 종료
public class Ex03_loop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.print("I:입력, U:수정, X:종료");
			fn = scanner.next(); // "X"
			switch (fn) {
			case "I": case "i":
				System.out.println("입력로직수행");break;
			case "U": case "u":
				System.out.println("수정로직수행");
			}
//		} while(! fn.equals("X") && ! fn.equals("x"));
		} while(! fn.equalsIgnoreCase("x"));
		scanner.close();
	}
}

// equalsIgnoreCase(): 대소문자 구별없이 비교(T/F)
// 대소문자 구분없이 x나오면(T) = !(F)일 때 do~while문 실행

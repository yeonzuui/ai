package com.lec.ex1_String;

import java.util.Scanner;

// quiz: 전화번호(02-7894-7897)를 입력받아, 전번, 짝수번째문자, 거꾸로, 국번, 뒷4자리 출력(x를 입력할 때까지 반복적)
public class Ex04_tel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("전화번호(ooo-oooo-oooo), 단 종료시 x :");
			String tel = scanner.next(); // "010-1234-5678"
			if(tel.equalsIgnoreCase("x")) break; // 반복문 종료 조건
			// 전화번호 출력(tel출력)
			System.out.println("전화번호 : " + tel);
			System.out.println("--------------------------");
			
			// 짝수번째 문자열 출력(length(), charAt(), for문 이용)
			String Even = ""; // null 쓰지말기
			int length = tel.length();
			for(int i=0 ; i<length ; i++) {
				if(i%2 == 0) {
				Even += tel.charAt(i);
				}
			}
			System.out.println("짝수번째 : " + Even );
			// 거꾸로 출력(length(), charAt(), for문 이용)
			System.out.println("거꾸로: ");
			for(int i=tel.length()-1; i>=0 ; i--) {
				System.out.print(tel.charAt(i) + " ");
			}
			System.out.println();
				
			// 앞자리 출력(indexOf(), substring() 이용)
			String preTel = tel.substring(0, tel.indexOf("-"));
			System.out.println("앞자리만 : " + preTel);
			System.out.println();
	
			// 뒷자리 출력(lastindexOf(), substring() 이용)
			String postTel = tel.substring(tel.lastIndexOf("-", 8)+1, tel.length());
			System.out.println("뒷자리만 : " + postTel);
		}
	}
}

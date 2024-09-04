package com.lec.quiz;

import java.util.Scanner;

// 사용자로부터 입력받은 수가 3의 배수인지 아닌지 출력
public class Sample {
	public static void main(String[] args) {
//		String name = "Hong"; // 원래는 new String()감싸야 하는데, string은 생략가능
//		System.out.println(name.toUpperCase()); // string객체라서 toUpperCase 가능
		// Scanner 커서 갖다놓고 ctrl+space
		// sc는 nextInt() 생성하려고 부르는 변수, 스캐너 안에 있으니까
		Scanner sc = new Scanner(System.in); 
		System.out.print("정수를 입력하세요 >");
		int su = sc.nextInt(); // 키보드로부터 입력받은 정수를 반환하는 기능
		String result = (su % 3 == 0) ? "3의 배수입니다" : "3의 배수가 아닙니다";
//		System.out.println("입력하신 수, " + su + "는 " + result);
		System.out.printf("입력하신 수, %d는 %s", su, result);
		sc.close(); // 스캐너변수 해제, 안 해도 상관없지만 노란 밑줄 생성(추천), garbage 청소
	}
}

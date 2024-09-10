package com.lec.ex5_Scanner;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 주소 입력
		System.out.print("주소 : ");
		scanner.nextLine(); // 버퍼에 남아있는 내용을 (\n포함) 지우는 용도
		String address = scanner.nextLine();
		System.out.println("입력한 주소는 : " + address);
		// 이름 입력
		System.out.print("이름 : ");
		String name = scanner.nextLine(); 
		System.out.println("입력한 이름 : " + name);
		// 나이 입력
		System.out.println("나이 : ");
		int age = scanner.nextInt();
		System.out.println("입력한 나이 : " + age);

		// next() : "톰 크루즈"는 못 받아, white space(space, tab, \n)앞까지만 return 하고 나머지는 버퍼에 남겨둠
		// nextLine(): "\n" 앞의 값을 return하고 나머지는 버퍼에서 지움
		
	}
}

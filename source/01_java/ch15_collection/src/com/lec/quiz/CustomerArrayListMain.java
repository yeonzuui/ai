package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

import com.lec.ex1_list.Friend;

public class CustomerArrayListMain {
	public static void main(String[] args) {
		// ArrayList 생성
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		// 사용자로부터 데이터 입력 받기
		Scanner scanner = new Scanner(System.in);
		
		// 변수 선언 및 초기화
		String answer = null, name, tel, address;
		
		do {
			System.out.print("회원가입 진행하시겠습니까 (Y/N)?");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("y")) {
				// newCustomer 변수 생성
				Customer newCustomer = new Customer();
				// 이름 받기
				System.out.print("가입하실 회원님 이름은?");
				newCustomer.setName(scanner.next());
				// 전화번호 받기
				System.out.print("가입하실 회원님 전화는?");
				newCustomer.setTel(scanner.next());
				// 주소 받기
				System.out.print("가입하실 회원님 주소는?");
				scanner.nextLine();// 버퍼지우는 용도
				newCustomer.setAddress(scanner.nextLine());
				customers.add(newCustomer);
//				System.out.print("가입하실 회원님 이름은?");
//				name = scanner.next();
//				System.out.print("가입하실 회원님 전화번호는 ?");
//				tel = scanner.next();
//				System.out.print("가입하실 회원님 주소는 ?");
//				scanner.nextLine(); // 버퍼지우는 용도
//				address = scanner.nextLine();
//				customers.add(new Customer(name, tel, address));
			}
		}while(!answer.equalsIgnoreCase("n"));
		scanner.close();
		// N(n)을 입력할 경우 회원정보 출력
//		if(customers.isEmpty()) {
		if(customers.size()==0) {
			System.out.println("가입한 회원 목록이 없습니다");
		}else {
			System.out.println("가입한 회원 목록입니다");
			for(Customer customer : customers) {
				System.out.println(customer);
			}//for
		}//if
	} // main
} // class

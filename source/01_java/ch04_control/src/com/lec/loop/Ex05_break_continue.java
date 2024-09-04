package com.lec.loop;

public class Ex05_break_continue {
	public static void main(String[] args) {
		for(int i=1 ; i<=10 ; i++) {
			if(i==3) 
				//break; // 반복문 블럭을 빠져 나감
				continue; // 증감식으로 올라감
			System.out.print(i + "\t");
		} //for
	} //main
} //class
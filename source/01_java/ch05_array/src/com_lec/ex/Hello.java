package com_lec.ex;

public class Hello {
	public static void main(String[] args) { // String[] - args 배열을 의미
		System.out.println("args 배열 길이: " + args.length);
		System.out.print("Hello ");
		for(int i = 0 ;i < args.length ; i++) {
			System.out.printf("Hello, %s\n", args[i]);
		}
	} // main
} // class
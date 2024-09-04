package com.lec.ex2;

import com.lec.ex2_access.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privateMember); → Error
//		System.out.println(obj.defualtMember);
//		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		// obj.privateMethod();
//		obj.defualtMethod();
//		obj.protectedMethod();
		obj.publicMethod();
		// 다른 패키지에서는 public만 쓸 수 있음
	}
}

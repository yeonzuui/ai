package com.lec.ex2_access;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privateMember); → Error
		System.out.println(obj.defualtMember);
		System.out.println(obj.protectedMember);
		// obj.privateMethod();
		obj.defualtMethod();
		obj.protectedMethod();
		obj.publicMethod();
	}
}

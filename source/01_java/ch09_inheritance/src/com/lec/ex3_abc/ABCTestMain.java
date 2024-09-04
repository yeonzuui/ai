package com.lec.ex3_abc;

public class ABCTestMain {
	public static void main(String[] args) {
		S sobj = new S(); // 생성자 1개 실행
		// A aobj = new A(); // 생성자 2개 실행(S->A)
		S aobj = new A(); // A타입, S타입 변수 둘 다 가능, 위와 동일 결과
		S bobj = new B();
		S cobj = new C();
		
		// S타입으로 통일하여 배열 생성
		// arr은 각 인덱스의 주소값을 받는다
		S [] arr = {sobj, aobj, bobj, cobj, new A()};
		
		// 확인
		for(S temp : arr) {
			System.out.println(temp.s);
		}
	}
}

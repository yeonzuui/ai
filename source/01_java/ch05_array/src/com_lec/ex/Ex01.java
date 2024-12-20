package com_lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // 변수의 선언과 초기화 한번에(ch02 Ex04 참고)
		// 1. 배열 변수 선언과 초기화
		int[] iArr = { 10, 20, 30, 40, 50 }; // int[]: int 배열 타입 // len = 5
		iArr[2] = 333; // 배열값의 접근은 index(0부터 시작)
		for (int idx = 0; idx < iArr.length; idx++) { // 상수말고 len 넣기
			System.out.println(idx + "번째는 " + iArr[idx]);
		}
		// 2. 배열 변수 선언과 배열 메모리 공간 확보
		int[] iArr2 = new int[5]; // new가 len = 5 형성하고 쓰레기값 청소
		for (int idx = 0; idx < iArr.length; idx++)
			System.out.println("iArr2[" + idx + "]= " + iArr2[idx]);
		// 3. 배열 변수 선언
		int[] arr;
		arr = new int[3]; // arr = { 0, 0, 0 } 의미적으로 같다
		for (int a : arr) { // 확장 for문(자주 씀, 인덱스 無)
			System.out.println(a);
		}
	} // main
} // class
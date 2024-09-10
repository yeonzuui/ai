package com.lec.ex1_trycatch;

public class Ex04_finally {
	public static void main(String[] args) {
		// 배열 생성
		int [] arr = {0,1,2};
		// 일반 for문
		for(int i=0 ; i<=arr.length; i++) {
			try {
				System.out.println("arr[" + i + "] = " + arr[i]);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메세지 : " + e.getMessage());
			}catch (Exception e) {
				
			}finally {
				System.out.println("try절 실행후에도, catch절 실행후에도 실행되는 절\n");
			} // try
		} // for
	} // main
} // class

// java.lang.ArrayIndexOutOfBoundsException : 인덱스값이 배열 범위를 벗어났을 때 발생하는 예외 객체 변수
// Index 3 out of bounds for length 3
// finally절: try절 밖에 써도 동일하게 실행되는 것처럼 보임
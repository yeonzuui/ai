package com.lec.ex2_protected.copysuper;
// private(i, j) / public setter&getter
// new Child(), new Child(1, 10)
public class Child extends SuperIJ{
	// 데이터
	private int total;
	
	// 생성자 함수(매개변수 無, 매개변수 2개)
	public Child() {
		System.out.println("매개변수 없는 Child 생성자");
	}
	public Child(int i, int j) {
		super(i,j);
		System.out.println("매개변수 있는 Child 생성자");
	}
	
	// method
	public void sum() {
		total = getI() + getJ(); // private 데이터일 경우
//		total = i + j; 
		System.out.println("i="+i +
							"j=" +j+
							"total="+total);
	}
}

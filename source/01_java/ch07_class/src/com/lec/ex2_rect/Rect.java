package com.lec.ex2_rect;
// class : 속성(인스턴스변수), 생성자함수(속성데이터초기화), method, setter&getter
// Rect r1 = new Rect(); r1.setWidth(2); r1.setHeight(4);
// Rect r1 = new Rect(2, 4)
// Rect r1 = new Rect(3);
public class Rect {
	private int width;
	private int height;
	// 생성자 함수가 없을 경우, jVM이 디폴트 생성자 자동 생성
	// 생성자함수도 overloading 가능
	public Rect( ) {} // 디폴트 생성자(매개변수 X)
	public Rect(int side) { // 매개변수 1개인 생성자 함수
		width  = side;
		height = side;
	}
	public Rect(int width, int height) { // 매개변수 2개인 생성자 함수
		this.width  = width;
		this.height = height;
	}
	// method
	public int area() {
		return width*height;
	}
	// setter&getter
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

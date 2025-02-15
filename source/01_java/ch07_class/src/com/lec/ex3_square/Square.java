package com.lec.ex3_square;

// 속성, 생성자, method, [setter&getter]
// Square s = new Square()   : s의 side를 0으로 초기화
// Square s = new Square(10) : s의 side를 10으로 초기화
public class Square {
	// 속성
	private int side = 0;

	// 생성자
	public Square() {
		System.out.println("매개변수 없는(default) 생성자 함수 호출됨");
	}

	public Square(int side) {
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출됨");
	}

	// method
	public int area() {
		return side * side;
	}
	
	// setters&getters
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
} // class

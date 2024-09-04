package com.lec.ex5_super;
// super(): 부모클래스의 생성자 함수
// super.intro: 부모클래스의 intro()
// private(name, character), public(intro(), getter&setter)
public class Baby extends Person {
	
	// 생성자 함수
	public Baby() {
		super(); // 부모클래스의 매개변수 없는 생성자 함수. super() 생략할 경우 super() 자동 실행
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		super(name, character); // 부모클래스의 매개변수 있는 생성자 함수. 반드시 첫 번째 줄에 호출
		System.out.println("매개변수 있는 Baby 생성자");
	}
	
	// method
	@Override
	public void intro() {
		System.out.print("◑◐ 응애 응애 이쁜 아기");
		super.intro();
	}
}

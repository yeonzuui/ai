package com.lec.ex5_super;

// super(): 부모클래스의 생성자 함수
// super.~: 부모클래스의
// new Person() new Person("아빠곰","뚱뚱해")
public class Person {

	// 데이터
	private String name;
	private String character;
    // -----------------------------------------------------
	// 생성자 함수(default, 매개변수 有)
	public Person() {
		System.out.println("매개변수 없는 Person 생성자");
	}
	public Person(String name, String character) {
		System.out.println("매개변수 없는 Person 생성자");
		this.name = name;
		this.character = character;
	} // 우클릭-source-constructor using fields
	// -----------------------------------------------------
	// method
	public void intro() {
		System.out.println("★" + name + "은 " + character);
	}
	// -----------------------------------------------------
	// setter&getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
}

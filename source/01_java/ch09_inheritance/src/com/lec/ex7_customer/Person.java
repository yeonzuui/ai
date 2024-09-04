package com.lec.ex7_customer;
// Customer와 Staff의 공통점을 super 단에
public class Person {
	
	// 데이터
	private String name; // 고객명
	private String tel; // 전화번호
	
	// 생성자 함수
	public Person(String name, String tel) {
		super(); // default 생성자 함수도 실행
		this.name = name;
		this.tel = tel;
	}
	
	// method
	public String infoString() {
		return "[이름]" + name + "   [전화]" + tel;
	}

	// setter&getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}

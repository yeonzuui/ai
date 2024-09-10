package com.lec.ex1_list;
// new Friend("홍길동", "010-7897-7897")
public class Friend {
	// data
	private String name;
	private String tel;
	
	// Constructor
	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", tel=" + tel + "]";
	}
	
	// Only getter
	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}
	
	
	
}

package com.lec.quiz;

public class Customer {
	// data
	private String name;
	private String tel;
	private String address;
	
	// Constructor(overloading)
	public Customer() {}
	public Customer(String name, String tel, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "[name = " + name + " " +
			   "tel = " + tel + " " +
			   "address = " + address + "]";
	}
	
	// setter&getter
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}
	
	
	
	
}

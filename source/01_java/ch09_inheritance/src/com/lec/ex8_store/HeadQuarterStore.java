package com.lec.ex8_store;
// 김치찌개-8,000 부대찌개-9,000 비빔밥-9,000, 순대국 -8,000 공기밥-1,000원
// new HeadQuaterStore("본사") new Store1("1호점") 
public class HeadQuarterStore {
	// 데이터
	private String storeName;
	
	// 생성자
	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("김치찌개 : 8000원");
	}
	public void bude() {
		System.out.println("부대찌개 : 9000원");
	}
	public void bibim() {
		System.out.println("비빔밥 : 9000원");
	}
	public void sunde() {
		System.out.println("순대국 : 8000원");
	}
	public void gongi() {
		System.out.println("공기밥 : 1000원");
	}
	
	@Override
	public String toString() {
		return "★" + storeName + "★";
	}
	
	// getter
	public String getStoreName() {
		return storeName;
	}
	
	
}	

package com.lec.ex2_store;
// 김치찌개-9,000  부대찌개-10,000  비빔밥-10,000 얼큰순대국-9,000  공기밥-1,000원
public class Store3 implements HeadQuarterStore {
	// 데이터
	private String storeName;
	
	// 생성자 함수
	public Store3(String storeName) {
		this.storeName = storeName;
	}
	
	@Override
	public void bude() {
		System.out.println("부대찌개 10,000원");
	}
	@Override
	public void sunde() {
		System.out.println("얼큰 순대국 9,000원");
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 9,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 10,000원");
	}
	@Override
	public void gongi() {
		System.out.println("공기밥 1,000원");
	}

	@Override
	public String toString() {
		return "★" + storeName + "★" ;
	}

}

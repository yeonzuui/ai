package com.lec.ex1_store;
// HeadQuarterStore를 상속받은 측에서 반드시 override 하도록 - 추상클래스
// 추상 method가 하나라도 있으면 추상 class가 된다
// 추상 class는 객체를 만들 수 없다
public abstract class HeadQuarterStore {
	// 데이터
	private String storeName;
	
	// 생성자
	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	
	// 추상 method: 메소드 선언만 있고, 구현은 없는 메소드(구현은 상속받은 측에서)
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gongi();
	
	@Override
	public String toString() {
		return storeName;
	}
	
	// getter
	public String getStoreName() {
		return storeName;
	}
	
	
}	

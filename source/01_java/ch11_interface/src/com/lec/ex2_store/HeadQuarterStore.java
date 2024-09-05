package com.lec.ex2_store;
// HeadQuarterStore를 상속받은 측에서 반드시 override 하도록 - 추상클래스
// 추상 method가 하나라도 있으면 추상 class가 된다
// 추상 class는 객체를 만들 수 없다
public interface HeadQuarterStore {
	
	// 추상 method: 메소드 선언만 있고, 구현은 없는 메소드(구현은 상속받은 측에서)
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gongi();
	// 인터페이스 → 작업명세서 역할, 다형성 구현, 기능 부품화(패턴)
}	
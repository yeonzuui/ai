package com.lec.ex6_final;
// final 변수     : 변수 수정 불가
// final method  : override 불가
// final class   : 상속금지 -> Redrabbit 클래스 만들면 상속 불가한 것 확인됨
public final class Rabbit extends Animal { 
	
	@Override
	public void running() {
		speed += 30;
		System.out.println("토끼가 마구 뛰어요. 현재 속도 : " + speed);
	}
	// stop은 final method라 override 불가능
}

package com.lec.ex1_parentChild;

public class ChildClassTestMain {
	public static void main(String[] args) {
		// 메모리 생성(new)은 부모-자식순, 생성자도 부모-자식순
		ChildClass child = new ChildClass();
		// 상속으로 인해 부모/자식 클래스 모두 사용 가능
		System.out.println(child.cStr);
		System.out.println(child.pStr); // 데이터 호출
		child.getPapaName();
		child.getMamiName(); // 메소드 사용
	}
}
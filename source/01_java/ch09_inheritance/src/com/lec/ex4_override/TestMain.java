package com.lec.ex4_override;

public class TestMain {
	public static void main(String[] args) {
		// 변수 생성과 초기화
		Parent pObj1 = new Parent();
		Parent pObj2 = new Parent();
		
		System.out.println("pObj1과 pObj2가 같은지 ? " + (pObj1.equals(pObj2))); // 주소 다름
		// 기초데이터(int ...) 비교 -> ==
		// 객체 비교 -> Object 안의 method 사용 -> equals()
		
		pObj1.method1();
		pObj2.method2();
		Child cObj1 = new Child();
		Child cObj2 = new Child();
		System.out.println("cObj1과 cObj2가 같은지 ? " + (cObj1.equals(cObj2)));
		cObj1.method1();
		cObj1.method2();
		cObj1.method3();
		
		// 상속 후에는 Parent 타입으로 불러올 수 있어
		Parent obj = new Child(10);
		
		obj.method1();
		obj.method2();
		// ((Child)obj).method3(); // 객체의 명시적인 형변환, 복잡한 코드에서 비추
		if(obj instanceof Child) { // obj가 Child형 인스턴스 변수냐
			((Child)obj).method3();
		}else {
			System.out.println("형변환 불가");
		}
	}
}






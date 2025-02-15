package com.lec.ex3_static;

public class MomTestMain {
	public static void main(String[] args) {
		// static (정적 변수; 공유 변수; 깍두기)
		// static 장점: 편하다, 변수 공유 가능, 객체 만들어두고 모니터링 해야 하는 경우
		// static 단점: 셧다운, 최소한의 static 사용
		Child.method();
		System.out.println(Child.mom.money);
		// -------------------------------------------------------
		Child child1 = new Child("첫째 길동이"); // 첫째 객체 생성
		Child child2 = new Child("둘째 개똥이"); // 둘째 객체 생성
		Child child3 = new Child("셋째 똘순이"); // 셋째 객체 생성
		// 각각의 name과 각각의 mom을 가짐
		// -------------------------------------------------------
		System.out.println("첫째 엄마 지갑 : " + Child.mom.money);
		child1.takeMoney(1000); // 첫째 돈 받아감 
		child2.takeMoney(1000); // 둘째 돈 받아감
		child3.takeMoney(1000); // 셋째 돈 받아감
		System.out.println("첫째 엄마 지갑 : " + Child.mom.money);
		System.out.println("둘째 엄마 지갑 : " + Child.mom.money);
		System.out.println("셋째 엄마 지갑 : " + Child.mom.money);
		System.out.println("엄마 지갑 : " + Child.mom.money);
		// 삼남매의 엄마를 공유하고 싶음
		// hit 메모리만 청소: garbage collection
	}
}
package com.lec.quiz;
// name, int computePay (추상메소드, 월급을 return하는 메소드)
// int computeIncentive (월급이 300이상인 사람만 월급의 5%를 incentive)
public abstract class Employee {
	// 데이터
	private final double RATE = 0.05; // 추후 유지보수 위해 상수클래스로 빼도 됨
	private String name;
	
	// 생성자 함수
	public Employee(String name) {
		this.name = name;
	}
	
	// method
	public abstract int computePay(); // 추상메소드(반드시 override)
	public final int computeIncentive() {   // 정규/비정규 똑같이 적용되어야 해 -> final(override 금지)
		int pay = computePay();
		if (pay > 3000000) {
			return (int) (pay*RATE);
		}
		return 0;
		
//		if (pay > 3000000) {
//			return (int) (pay*0.05);
//		}else {
//			System.out.println("보너스가 없습니다");
//		}
//		return 0;
	}
	
	// getter
	public String getName() {
		return name;
	}
}

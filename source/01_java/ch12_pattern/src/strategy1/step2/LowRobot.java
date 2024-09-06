package strategy1.step2;

public class LowRobot extends Robot{ // Robot 클래스로부터 상속, 로봇 기본 동작 생략가능
	public void actionFly() {
		System.out.println("날 수 없습니다");
	}
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없습니다");
	}
	public void actionKnife() {
		System.out.println("검이 없습니다");
	}
}

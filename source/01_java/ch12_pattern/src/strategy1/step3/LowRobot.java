package strategy1.step3;

public class LowRobot extends Robot{ // Robot 클래스로부터 상속, 로봇 기본 동작 생략가능
	@Override
	public void actionFly() {
		System.out.println("날 수 없습니다");
	}
	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없습니다");
	}
	@Override
	public void actionKnife() {
		System.out.println("검이 없습니다");
	}
}

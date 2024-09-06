package strategy1.step5.modularization;

import strategy1.step4.interfaces.*; // ctrl + shift + O : *쓰고 필요한 거 가져옴

public class LowRobot extends Robot{ // Robot 클래스로부터 상속, 로봇 기본 동작 생략가능

	// 생성자
	public LowRobot() {
		setFly(new FlyNo());          // fly     = new FlyNo();
		setMissile(new MissileNo());  // missile = new MissileNo();
		setKnife(new KnifeNo());      // knife   = new KnifeNo();
	}
	
	@Override
	public void shape() {
		System.out.println("= = 로우로봇의 외형은 팔, 다리, 머리, 몸통이 있습니다 = =");
	}
}

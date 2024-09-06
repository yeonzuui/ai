package strategy1.step5.modularization;

import strategy1.step4.interfaces.*;

public class SuperRobot extends Robot{
	
	// 생성자
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}
	
	@Override
	public void shape() {
		System.out.println("= = 슈퍼로봇의 외형은 팔, 다리, 머리, 몸통이 있습니다 = =");
	}
}

package strategy1.step5.modularization;

import strategy1.step4.interfaces.*;

public class StandardRobot extends Robot {
	
	// 생성자
	public StandardRobot() {
		setFly(new FlyNo());           // fly = new FlyNo();
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}
	
	@Override
	public void shape() {
		System.out.println("= = 스탠다드로봇의 외형은 팔, 다리, 머리, 몸통이 있습니다 = =");
	}
}

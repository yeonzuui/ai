package strategy1.step4.modularization;

import strategy1.step4.interfaces.*;

public class StandardRobot extends Robot {
	// 변수생성
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	
	// 생성자
	public StandardRobot() {
		setFly(new FlyNo());           // fly = new FlyNo();
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}
	
	@Override
	public void actionFly() {
		fly.fly();
	}
	@Override
	public void actionMissile() {
		missile.missile();
	}
	@Override
	public void actionKnife() {
		knife.knife();
	}
	
	// setter
	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}
	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}
	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
	
	
}

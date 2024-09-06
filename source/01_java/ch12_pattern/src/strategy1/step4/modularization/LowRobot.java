package strategy1.step4.modularization;

import strategy1.step4.interfaces.*; // ctrl + shift + O : *쓰고 필요한 거 가져옴

public class LowRobot extends Robot{ // Robot 클래스로부터 상속, 로봇 기본 동작 생략가능
	// 변수생성
	private FlyImpl     fly;     // FlyImpl 타입의 변수 생성
	private MissileImpl missile;
	private KnifeImpl   knife;
	
	// 생성자
	public LowRobot() {
		setFly(new FlyNo());          // fly     = new FlyNo();
		setMissile(new MissileNo());  // missile = new MissileNo();
		setKnife(new KnifeNo());      // knife   = new KnifeNo();
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

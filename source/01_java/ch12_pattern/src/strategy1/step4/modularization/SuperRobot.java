package strategy1.step4.modularization;

import strategy1.step4.interfaces.*;

public class SuperRobot extends Robot{
	// 변수 생성
	private FlyImpl     fly;
	private MissileImpl missile;
	private KnifeImpl   knife; 
	
	// 생성자
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
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

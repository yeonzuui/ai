package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.MissileImpl;

// pattern에서 추상클래스 응용 - main함수에서 배열 호출하는 for문 단순화
public abstract class Robot {
	
	// 변수생성
	private FlyImpl     fly;     // FlyImpl 타입의 변수 생성
	private MissileImpl missile;
	private KnifeImpl   knife;
	
	// 객체의 이름을 가져오는 메소드 - object에 포함
	public void actionWalk() {
		System.out.println("걸을 수 있습니다");
	}
	public void actionRun() {
		System.out.println("달릴 수 있습니다");
	}
	
	// method
	public void actionFly() {
		fly.fly();
	}

	public void actionMissile() {
		missile.missile();
	}

	public void actionKnife() {
		knife.knife();
	}
	
	// 추상method
	public abstract void shape();
	
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
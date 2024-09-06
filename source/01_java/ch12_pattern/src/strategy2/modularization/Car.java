																																										package strategy2.modularization;

import strategy2.interfaces.*;

public abstract class Car {
	// 변수생성
	private EngineImpl engine;
	private KmImpl     km;
	private FuelImpl   fuel;
	
	// method
	public void drive() {
		System.out.println("드라이브 할 수 있습니다");
	}
	public void engine() {
		engine.engine();
	}
	public void km() {
		km.km();
	}
	public void fuel() {
		fuel.fuel();
	}
	
	// 추상 method
	public abstract void shape();
	
	// setter
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	public void setKm(KmImpl km) {
		this.km = km;
	}
	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}
	
	
}

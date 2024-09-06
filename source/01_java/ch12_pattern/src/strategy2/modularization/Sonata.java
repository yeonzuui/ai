package strategy2.modularization;

import strategy2.interfaces.*;

public class Sonata extends Car {
	// 생성자
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.println("= = 소나타에는 door, sheet, handle이 있습니다 = =");
	}

}

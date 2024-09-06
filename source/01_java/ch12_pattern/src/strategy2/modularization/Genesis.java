package strategy2.modularization;

import strategy2.interfaces.*;

public class Genesis extends Car {
	
	// 생성자
	public Genesis() {
		setEngine(new Enginehigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.println("= = 제네시스에는 door, sheet, handle이 있습니다 = =");
	}

}

package strategy2.modularization;

import strategy2.interfaces.*;

public class Casper extends Car {
	public Casper() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.println("= = 캐스퍼에는 door, sheet, handle이 있습니다 = =");
	}

}

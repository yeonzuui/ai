package strategy2.interfaces;

public class FuelGasoline implements FuelImpl {
	@Override
	public void fuel() {
		System.out.println("휘발유 전용입니다");
	}
}

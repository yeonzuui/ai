package strategy2.interfaces;

public class FuelDiesel implements FuelImpl {
	@Override
	public void fuel() {
		System.out.println("경유 전용입니다");
	}
}

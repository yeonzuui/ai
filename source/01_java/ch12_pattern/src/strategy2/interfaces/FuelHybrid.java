package strategy2.interfaces;

public class FuelHybrid implements FuelImpl {
	@Override
	public void fuel() {
		System.out.println("하이브리드 전용입니다");
	}
}

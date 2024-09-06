package strategy1.step4.interfaces;
// 바꾸고 싶은 기능을 클래스로 만든다(기존 자료 변형 없이)
public class FlyHigh implements FlyImpl {
	@Override
	public void fly() {
		System.out.println("높~~~~~~~이 날 수 있습니다");
	}
}

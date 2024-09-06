package strategy2.modularization;

import strategy2.interfaces.FuelHybrid;
import strategy2.interfaces.Km20;

public class CarMainTest {
	public static void main(String[] args) {
		// 객체 변수 설정
		Genesis genesis = new Genesis();
		Sonata sonata = new Sonata();
		Casper casper = new Casper();
		
		// Car 배열 생성
		Car [] cars = {genesis, sonata, casper};
		
		// 확장 for문을 통한 호출
		for (Car car : cars) {
			car.shape();
			car.drive();
			car.engine();
			car.km();
			car.fuel();
			System.out.println();
		}
		System.out.println("소나타의 연료를 하이브리드로 교체하고 연비를 리터당 20km로 업그레이드");
		sonata.setFuel(new FuelHybrid());
		sonata.setKm(new Km20());
		sonata.fuel();
		sonata.km();
		System.out.println();
		
		System.out.println("-------------변경 후-------------");
		for (Car car : cars) {
			car.shape();
			car.drive();
			car.engine();
			car.km();
			car.fuel();
			System.out.println();
		}
	} // main
} // class

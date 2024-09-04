package com.lec.ex7_customer;
// Customer c = new Customer("홍", "010-9999-9999", "서울", "12-12")
// c.buy(10000)
// sysout(c.infoString())
public class Customer extends Person{
	
	// 데이터
	private String   address; 
	private int      sum;     // 구매금액 누적
	private int      point;   // 포인트(구매금액의 1%)
	private String   date;    // 기념일, String을 다음주부터는 날짜형(date)
	private boolean  vip;     // T: vip 고객, F: 일반 고객
	
	// 생성자 함수
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date    = date;
		point        = 1000; // 최초 가입시 1000점
		System.out.println(name + "님 가입 감사 포인트 무려 1000점 드렸습니다");
	}
	
	// method
	public void buy(int price) {
		sum += price; // 구매금액 누적
		if (vip == false && sum >= Constant.VIPLIMIT) { // VIP 기준 상수 처리
			vip = true;
			System.out.println(getName() + "님 VIP로 업그레이드 되셨습니다 짱입니다");
		}
		int thisPoint = (int)(price * Constant.POINTRATE); // 금번 포인트, 포인트지급율 상수 처리
		point = thisPoint; // 포인트 누적
		System.out.println(getName() + "님 감사. 구매액 : " + price);
		System.out.println("금번 포인트 : " + thisPoint);
		System.out.println("누적 포인트 : " + point);
		System.out.println("누적 금액 : " + sum);
	}
	
	@Override
	public String infoString() {
		String result = super.infoString() + "  [포인트]" + point + "  [구매누적]" + sum;
		result += (vip) ? " ♥ VIP 고객이십니다 ♥" : "";
		return result;
	}
} // class








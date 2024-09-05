package com.lec.quiz;
// name, hoursWorked, moneyPerhour, computePay(abstract), computeIncentive(final)
public class HourlyEmployee extends Employee{
	// 데이터
	private int hoursWorked;  // 노동시간
	private int moneyPerhour; // 시간당임금
	
	// 생성자 함수
	public HourlyEmployee(String name, int hoursWorked, int moneyPerhour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerhour = moneyPerhour;
	}
	
	@Override
	public int computePay() {
		return hoursWorked * moneyPerhour;
	}
	

}

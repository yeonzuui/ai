package com.lec.quiz;
//name, hoursWorked, moneyPerhour, computePay(abstract), computeIncentive(final)
public class SalaryEmployee extends Employee {
	// 데이터
	private int annualSalary;

	public SalaryEmployee(String name, int annualSalary) {
		super(name);
		this.annualSalary = annualSalary;
	}
	
	@Override
	public int computePay() {
		return annualSalary / 14;
	}
 
}
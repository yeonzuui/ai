package com.lec.quiz;

public class EmployeeTestMain {
	public static void main(String[] args) {
		// 변수 생성과 초기화
		Employee[] sawon = {
				new SalaryEmployee("홍길동", 48000000),
				new SalaryEmployee("강동원", 70000000),
				new SalaryEmployee("김고은", 76000000),
				new HourlyEmployee("홍길구", 100,9700),
				new HourlyEmployee("김길자", 160,10000)};
		
		// 확장 for문을 통한 출력
		for(Employee temp : sawon){
			System.out.println("--------------------------------");
			System.out.println("이 름 : "+ temp.getName());
			System.out.println("월 급 : "+ temp.computePay());
			// 상여금은 0 이상일 때만 출력
			int incentive = temp.computeIncentive();
			if( incentive > 0) {
				System.out.println("상 여 : "+ incentive);
			} // if
		} // for 
	} // main
} // class

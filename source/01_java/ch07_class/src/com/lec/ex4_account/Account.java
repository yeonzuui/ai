package com.lec.ex4_account;
// 데이터(인스턴스 변수): accountNo(String, 앞 0 손실 방지), ownerName(String), balance(long)
// 생성자 new Account("010-777-77", "홍길동"), new Account("010-777-77", "홍길동", 100)
// 기능(method): deposit(예금), withdraw(인출), inforPrint(정보출력), infoString(정보문자열 반환)
public class Account {
	// 데이터(속성)
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주명
	private long   balance;   // 예금 잔액
	
//	생성자 없으면 JVM이 default 생성자 함수를 자동 생성-----------------------------------------
//	public Account( ) {} // default 생성자 함수
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance   = balance;
	}
//	기능(method)---------------------------------------------------------------------
	public void deposit(long money) { // 무조건 예금하기
		balance += money;
		System.out.println(money + "원 예금하여 잔액 : " + balance);
	}
	public void withdraw(long money) { // 잔액이 있을 경우만 인출, 잔액 부족하면 떼끼
		if(balance >= money) {
			balance -= money;
			System.out.println(money + "원 인출하여 잔액 : " + balance);
		}else {
			// ch14에서는 강제 예외 발생
			System.out.println("잔액이 부족하여 인출 불가합니다");
		}
	}
	public void infoPrint() {
		// 100-1 "홍길동"님 잔액 : 100원
//		System.out.println(account + "\"" + ownerName + "\"님 잔액 : " + balance);
		System.out.printf("%s \"%s\"님 잔액 : %d\n", accountNo, ownerName, balance);
	}
	public String infoString() { // 객체 정보를 스트링으로 바꿔서 return
		// 100-1 "홍길동"님 잔액 : 100을 return
//		return accountNo + " \"" + ownerName + "\"님 잔액 : " + balance;
		return String.format("%s \"%s\"님 잔액 : %d\n", accountNo, ownerName, balance);
	}
//	setter&getter-------------------------------------------------------------------
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	} 
	
}

package com.lec.ex0_janmuri;
// class 파일을 따로 만들지 않고, 해당 파일 바로 위에 생성
// 시스템 내부적으로 컴파일 할 때 PersonInfo, Janmuri 분리
class PersonInfo{
	private String name; 
	private String tel; // 데이터
	public PersonInfo(String name, String tel) {
		this.name = name;
		this.tel = tel;
	} // 생성자 함수
	public String info() {
		return name + ": " + tel;
	} // method
}
public class Janmuri {
	public static void main(String[] args) {
		PersonInfo p = new PersonInfo("홍길동", "010-9999-9999");
		System.out.println(p.info());
	} // main
} // class
package com.lec.ex4_product;
// new Product("S22") 101 102 103 104....(=시리얼 넘버)
public class Product {
	// 데이터(인스턴스 변수)
	private String 		modelNo; // 모델명
	private int    		serialNo; // 객체 고유의 번호
	static int 	count = 100; // static 변수 
	// ------------------------------------------------------------------------
	// 생성자 함수
	public Product(String modelNo) {
		this.modelNo = modelNo;
		serialNo = ++count;
	}
	public void infoPrint() {
		System.out.println("모델명 : " + modelNo +", 시리얼번호 : " + serialNo);
	}
}

package com.lec.ex4_product;

public class ProductTestMain {
	public static void main(String[] args) {
		System.out.println(Product.count);
		Product p1 = new Product("S23"); // p1객체 생성
		p1.infoPrint();
		System.out.println(Product.count);
		Product p2 = new Product("S23"); // p2객체 생성
		p2.infoPrint();
		Product p3 = new Product("S23"); // p3객체 생성
		p3.infoPrint();
	}
}
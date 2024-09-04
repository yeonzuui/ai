package com.lec.ex6_final;

public class AnimalTestMain {
	public static void main(String[] args) {
		// Animal type으로 배열 생성 및 초기화
		Animal [] animals = {new Animal(), new Dog(), new Rabbit()};
		
		// for구문으로 배열값 호출
		for(int idx=0 ; idx<animals.length ; idx++) {
			animals[idx].running();
			animals[idx].running();
			animals[idx].stop();
			System.out.println("----------------------");
		}
	}
} //

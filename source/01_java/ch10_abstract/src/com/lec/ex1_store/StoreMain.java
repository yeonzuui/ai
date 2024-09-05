package com.lec.ex1_store;

public class StoreMain {
	public static void main(String[] args) {
		
		// 배열 생성과 할당 한 번에
		HeadQuarterStore [] stores = {
//				new HeadQuarterStore("= = 본사 = ="),
				new Store1("= = 주택가 1호점 = ="),
				new Store2("= = 대학가 2호점 = ="),
				new Store3("= = 증권가 3호점 = ="),
				
		};
		
//		// 일반 for
//		for (int idx=0 ; idx<stores.length; idx++) {
//			System.out.println(stores[idx].toString()); // getStoreName()과 결과 같게 하고 싶어서 toString을 override
//			stores[idx].kimchi();
//			stores[idx].bude();
//			stores[idx].bibim();
//			stores[idx].sunde();
//			stores[idx].gongi();
//		}
		
		// 확장 for으로 수정
		for (HeadQuarterStore store : stores) {
			System.out.println(store); // println은 내부적으로 toString을 호출
			store.kimchi();
			store.bude();
			store.bibim();
			store.sunde();
			store.gongi();
		}
		
//		HeadQuarterStore head = new HeadQuarterStore(" = = 본사 = = ");
//		Store1 st1 = new Store1("= = 주택가 1호점 = =");
//		Store2 st2 = new Store2("= = 대학가 2호점 = =");
//		Store3 st3 = new Store3("= = 증권가 3호점 = =");
//		HeadQuarterStore[] stores = {head, st1, st2, st3};
	}
}

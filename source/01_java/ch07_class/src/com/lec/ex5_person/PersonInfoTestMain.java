
package com.lec.ex5_person;
// person 배열 생성
public class PersonInfoTestMain {
	public static void main(String[] args) {
		int i = 10;
		int [] scores = {i, 100, 95};
		PersonInfo p1 = new PersonInfo("홍길동", 33, 'm');
		PersonInfo p2 = new PersonInfo("홍길순", 32, 'f', "2001-12-01");
		PersonInfo[] person = {p1, p2};

//		for(int idx=0; idx <person.length ; idx++) {
				//person[idx].print();
//			System.out.println(person[idx].infoString());
//		}
		// 확장 for문(only 출력) 훨씬 많이 쓴다
		for(PersonInfo p : person) { // p:임시변수, person:배열이름
			System.out.println(p.infoString());
		}
	} // main
} // class
package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		// HashMap 변수(hashMap) 선언과 초기화
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		// hashMap에 key 설정, 데이터값 삽입
		hashMap.put(11, "str11"); // key11에 데이터 "str11" 추가
		hashMap.put(12, "str12");
		hashMap.put(22, "str33");
		hashMap.put(20, "str20");
		
		// hashMap 값 호출하기
		System.out.println(11 + "key값의 데이터 : " + hashMap.get(11));
		System.out.println(10 + "key값의 데이터(없으면 null) : " + hashMap.get(10));
		System.out.println(hashMap);
		System.out.println();
		
		// remove(K): 특정 key값 데이터 지우기
		hashMap.remove(12);
		System.out.println("12 remove 후 : " + hashMap); // 확인
		System.out.println();
		
		// clear(): 모든 데이터 제거
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "데이터 없음" : "데이터 있음"); // 확인
		System.out.println();
		
		// 출력(key 값이 순서대로 안돼있으면 for문 못 써 → keySet 이용)-------------------   
		HashMap<Integer, String> hashMap2 = new HashMap<Integer, String>();
		hashMap2.put(0, "Hong gildong");
		hashMap2.put(10, "Kim dongil");
		hashMap2.put(22, "Lee soonsin");
		hashMap2.put(40, "Shin gildong");
		
		// keySet을 이용한 반복자 객체 생성
		Iterator<Integer> iterator = hashMap2.keySet().iterator();
		
		// while문 이용한 출력
		while(iterator.hasNext()) { 
			Integer key = iterator.next();
			System.out.println(key + "의 데이터는 " + hashMap2.get(key));
		}
	} // main
} // class

// HashMap<K, V> key값 type(object만 가능), 인덱스값 type
// Iterator<key값 type> : 반복자
// keySet(): 키값 차례대로 정렬
// hasNext(): 다음 데이터 존재 여부(T/F)
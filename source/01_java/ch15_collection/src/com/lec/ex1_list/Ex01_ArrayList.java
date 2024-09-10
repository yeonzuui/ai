package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[2];
		array[0] ="str0"; array[1] = "str1"; // array[2] = "str2"; 불가능
		
		// Arrays.toString(): 배열 출력
		System.out.println(Arrays.toString(array)); 
		// 확장 for문을 통한 출력
		for(String arr: array) {
			System.out.print(arr + "\t");
		}
		// 일반 for문을 통한 출력
		for(int idx=0; idx<array.length; idx++) {
			System.out.print(array[idx] + "\t");
		}
		System.out.println("\n----------ArrayList-------------");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0"); // 0번 인덱스, 처음 삽입
		arrayList.add("str1"); // 1번 인덱스
		arrayList.add("str2"); // 2번 인덱스
		arrayList.set(1, "s t r 1"); // 1번 인덱스 값 수정
		arrayList.add("str3");
		System.out.println(arrayList);
		System.out.println("현재 arrayList 사이즈 : " + arrayList.size());
		System.out.println();
		// 확장 for문을 통한 ArrayList 출력
		for(String arr: arrayList) {
			System.out.print(arr + "\t");
		}
		System.out.println();
		// 일반 for문을 통한 ArrayList 출력
		for(int idx=0; idx<arrayList.size(); idx++) {
			System.out.println(idx + "번째 : " + arrayList.get(idx));
		}
		// 인덱스값 제거
		arrayList.remove(1);
		System.out.println(arrayList);
		arrayList.remove(arrayList.size()-1); // 맨 마지막 인덱스값 제거
		System.out.println(arrayList);
		// 데이터 존재 확인
		System.out.println(arrayList.isEmpty() ? "arrayList데이터가 없음" : "데이터 있음");
		// 데이터 제거
		arrayList.clear();
		// 빈 collection 확인
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty() ? "arrayList데이터가 없음" : "데이터 있음");
		System.out.println(arrayList.size());
	} // main
} // class

// int ArrayList 못 만듦 → integer 넣으면 가능
// ArrayList에서는 인덱스 추가 제한 없음
// add(): 인덱스 추가
// set(idx, "변경값"): 인덱스 수정
// size(): 길이
// get(): 인덱스값 반환 
// remove(n): n번째 인덱스값 삭제(n번인덱스 → n-1번인덱스)
// isEmpty(): 데이터가 존재하는지 확인(T/F)
// clear(): 자료구조 내 모든 데이터 제거1

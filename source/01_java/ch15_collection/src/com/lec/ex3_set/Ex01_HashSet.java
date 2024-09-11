package com.lec.ex3_set;
// HashSet - 워드클라우드
import java.util.HashSet;
import java.util.Iterator;
public class Ex01_HashSet {
	public static void main(String[] args) {
		// HashSet 생성
		HashSet<String> set = new HashSet<String>();
		// 데이터 입력
		set.add("str0");
		set.add("str1");
		set.add("str2");
		// 출력
		System.out.println(set);
		System.out.println("set의 데이터 갯수 : " + set.size());
		// set은 중복 불가
		set.add("str2"); set.add("str2"); 
		System.out.println("중복한 데이터를 add한 후 set의 데이터 갯수 : " + set.size());
		System.out.println();
		
		// Iterator를 통한 출력
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		} // while
	} // main
} // class

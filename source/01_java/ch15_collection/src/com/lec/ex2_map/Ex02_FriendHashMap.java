package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex02_FriendHashMap {
	public static void main(String[] args) {
		Friend[] farr = new Friend[5];                                   // 배열 
		ArrayList<Friend> fs = new ArrayList<Friend>();                  // ArrayList
		HashMap<String, Friend> friends = new HashMap<String, Friend>(); // HashMap
		
		Friend newFriend = new Friend("김길동", "010-8888-9999");
		
		// 인덱스값 삽입
		friends.put("010-9999-9999", new Friend("홍길동", "010-9999-9999"));
		friends.put("010-7777-7777", new Friend("신길동", "010-7777-7777"));
		
		// 출력
		Iterator<String> iterator = friends.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(friends.get(key).getName() + "\t" + friends.get(key).getTel());
		}
		iterator = friends.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(friends.get(key));
		} // while
	} // main
} // class

// HashMap<K, V> key값 type(object만 가능), 인덱스값 type
// Iterator<key값 type> : 반복자
// keySet(): 키값 차례대로 정렬
// hasNext(): 다음 데이터 존재 여부(T/F)
// Iterator가 한 번 소요되면, 이후 반복문에서는 실행되지 않음 (Iterator 한 번 더 만들어야 해)

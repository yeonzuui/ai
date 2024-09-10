package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex02_FriendArrayList {
	public static void main(String[] args) {
//		배열
//		Friend [] fs = new Friend[2];
//		fs[0] = new Friend("홍길동", "010-7897-7897");
//		fs[1] = new Friend("신길동", "010-8888-8888");
		
		// ArrayList 생성과 인덱스값 삽입
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-7897-7897")); // 0번 인덱스
		friends.add(new Friend("신길동", "010-8888-8888")); // 1번 인덱스
		friends.add(new Friend("박길순", "010-4564-4564")); // 2번 인덱스
		
		// 일반 for문으로 ArrayList 출력
		for(int i=0; i<friends.size(); i++) {
			System.out.println(friends.get(i));
		}
		System.out.println();
		
		// 확장 for문으로 ArrayList 출력
		for(Friend friend : friends) {
			System.out.println(friend);
		}
		System.out.println();
		
		// 확장 for문
		for(Friend friend : friends) {
			System.out.println(friend.getName() + "\t" + friend.getTel());
		}
		System.out.println();
		
		// 데이터 제거
		friends.clear();
		
		// 일반 for문 - arrayList에 값 있을 때만 출력
		if(friends.isEmpty()) {
			System.out.println("friends 데이터가 없습니다");
		}else {
			for(int idx=0; idx<friends.size(); idx++) {
				System.out.println(friends.get(idx).getName() + "\t" + friends.get(idx).getTel());
			} // for
		} // if-else
	} // main
} // class

package com.lec.ex3_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

// Math.random(실수난수): Random 객체
public class Ex02_lotto {
	public static void main(String[] args) {
		// 난수 변수(random) 생성
		Random random = new Random();
		// 로또 배열 생성
		int [] lottoArr = new int [6];
		// 일반 for문을 통한 출력
		for(int i=0 ; i<lottoArr.length; i++) {
			lottoArr[i] = random.nextInt(45)+1;
		}
		// sort(배열값을 오름차순 정렬) // ch05 quiz 참고
		for(int i=0 ; i<lottoArr.length-1; i++) {
			for(int j=i+1; j<lottoArr.length; j++) {
				if(lottoArr[i]>lottoArr[j]) {
					int temp = lottoArr[i];
					lottoArr[i] = lottoArr[j];
					lottoArr[j] = temp;
				} // if
			} // for-j
		} // for-i
		System.out.println("lottoArr: " + Arrays.toString(lottoArr));
		
		// HashSet 생성
		// HashSet<Integer> lottoSet = new HashSet<Integer>();
		// TreeSet 생성: 
		TreeSet<Integer> lottoSet = new TreeSet<Integer>();
		int count = 0;
		while(lottoSet.size() < 6) {
			lottoSet.add(random.nextInt(45)+1);
			count ++; // 난수 몇 번 생성했는지 count
		}
		System.out.println(count + "번 뽑은 lottoSet: " + lottoSet);
		
		// 
	} // main
} // class

// TreeSet: sort(정렬)
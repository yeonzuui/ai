package com.lec.quiz;

import java.util.Arrays;

// 배열의 오름차순 정렬 (알고리즘)
public class Quiz1_sort {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 50 };
//		for (int a : arr) {
//			System.out.print(a + "\t");
//		}
		System.out.println("정렬전 : " + Arrays.toString(arr)); // 배열을 String 형태로 출력
		// 정렬
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					// i번째와 j번째를 바꿔, 바꾸기 전에 i번째 값 임시 저장, temp는 if문 나가면 사라져
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				} // if
			} // for-j
		} // for-i
		System.out.println("정렬후 : " + Arrays.toString(arr)); 
	} // main
} // class
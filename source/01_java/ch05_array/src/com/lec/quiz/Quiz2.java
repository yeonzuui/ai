package com.lec.quiz;

// 배열 안의 값의 합계, 평균, 최댓값, 최솟값 출력
public class Quiz2 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 12, 13 };
		// 합계
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum = " + sum);
		
		// 평균
		int avg =0;
		avg = sum / arr.length;
		System.out.println("avg = " + avg);
		
		// 최댓값
		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max= arr[i];
			}
			if(arr[i]<min) {
				min= arr[i];
			}
		}
		System.out.println("max = " + max);
		System.out.println("min = " + min);
	}// main
}// class
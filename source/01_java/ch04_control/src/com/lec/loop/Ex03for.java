package com.lec.loop;
// 15 16 17 18 19
// 20 21 22 23 24 
public class Ex03for {
	public static void main(String[] args) {
		for (int i=15 ; i<=50 ; i++) {
			System.out.print(i + "\t" ); //여기서는 println 하지 않고, 탭만큼 띄워
			if(i%5 == 4) { // 5로 나눈 나머지가 4일 때마다 개행
					System.out.println();
			} //if
		} //for
	} //main
} //class

package com.lec.loop;
// 1~100까지 숫자 중 3의 배수의 합을 출력
public class Ex09while {
	public static void main(String[] args) {
		int tot = 0; //누적변수
		int i = 1;
		while( i <= 100 ) {
//			방법1_추천★
			if( i%3 == 0 ) { //3의 배수일 때만 누적
				tot += i;
			} //if
			i++; // 1씩 누적, 3의 배수를 찾을 때까지 
		} //while
		System.out.println("1~100까지 3의 배수의 합은 " + tot);
	} //main
} //class

//			방법2
//			if( i%3 != 0) { 
//				i++;
//				continue;
//			}
//			tot += i;
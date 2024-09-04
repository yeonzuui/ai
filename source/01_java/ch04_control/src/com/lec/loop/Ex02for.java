package com.lec.loop;
// 1~10까지 누적합 출력 : 55
// 1+2+3+4+5+6+7+8+9+10= 55
public class Ex02for {
	public static void main(String[] args) {
		int total = 0;
		
		for (int i=1; i<=10 ; i++) {		
			total += i; //total = total + i;
			if(i==10) { //i 10일때만 =
				System.out.print(i + "="); //''하면 캐릭터로 인식, 연산함
			} else {
				System.out.print(i + "+");
			}		
		} //for
		System.out.println(total);
	} //main
} //class

//total = total + 1; //1
//total = total + 2; //1+2=3
//total = total + 3; // 1+2+3=6
//total = total + 4; // 1+2+3+4=10
//				.
//				.
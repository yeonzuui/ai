package com.lec.ex;
// 논리연산자: &&(and), ||(or), !(반대) 
/* true && true → true→
 * true && false
 * false && true
 * false && false
 */
public class Ex04 {
	public static void main(String[] args) {
		int i = 1, j = 10, h = 10;
		// &&(and) 
		// 가독성 위해 비교연산자 포함된 식에 ()
		System.out.println("( (i < j) && (++j > h) ) =>" + ( (i < j) && (++j > h) ) ); 
		System.out.println("j= " + j);
		
		// &&(and)연산의 좌항이 false인 경우, 우항은 수행하지도 않고 결과를 false로
		System.out.println("( (i > j) && (++j > h) ) =>" + ( (i > j) && (++j > h) ) );
		System.out.println("j= " + j);
		
		// ||(or)
		System.out.println("( (i < j) || (++j > h) ) =>" + ( (i < j) || (++j > h) ) ); 
		System.out.println("j= " + j);
		
		// ||(or)연산의 좌항이 true인 경우, 우항은 수행하지도 않고 결과를 true로
		System.out.println("( (i > j) || (++j > h) ) =>" + ( (i > j) || (++j > h) ) );
		System.out.println("j= " + j);
	}
}

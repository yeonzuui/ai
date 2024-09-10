package com.lec.ex1_String;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = "AbcXabc";
		String str3 = "   ja va   ";
		String str4 = "abcXabcXabc";
		String str5 = "반가워요. ㅋㅋ 또 봐요 ㅎㅎ zz";
		
		// concat(): 두 개의 문자열을 하나로 이어붙임
		System.out.println("1. " + str1.concat(str2));
		// substring(n): n번째 인덱스부터 끝까지 출력
		System.out.println("2. " + str1.substring(3));
		// substring(n1, n2): 인덱스 n1번부터 n2-1번째까지 출력
		System.out.println("3. " + str1.substring(3,5));
		// length(): 문자열 길이
		System.out.println("4. " + str1.length());
		// toUpperString(): 모두 대문자로 반환
		System.out.println("5. " + str1.toUpperCase());
		// toLowerCase(): 모두 소문자로 반환
		System.out.println("6. " + str1.toLowerCase());
		// charAt(n): 인덱스 n번째 문자 출력
		System.out.println("7. " + str1.charAt(3));
		// indexOf("ch"): 해당 문자(열)가 처음 오는 인덱스 반환
		System.out.println("8. " + str1.indexOf("bc"));
		// lastindexOf("ch"): 마지막부터 해당 문자(열) 검색하여 인덱스 반환
		System.out.println("9. " + str4.lastIndexOf("bc"));
		// 해당 문자 없으면 -1 반환
		System.out.println("10. " + str1.indexOf("@"));
		System.out.println("10. " + str4.lastIndexOf("@"));
		// equals(): 문자열이 같은지 다른지 비교(T/F), 주소값 비교 X
		System.out.println("11. " + str1.equals(str2));
		// equalsIgnoreCase(): 대소문자 구별없이 비교(T/F)
		System.out.println("12. " + str1.equalsIgnoreCase(str2));
		// trim(): 문자열의 앞뒤 공백을 제거 ex. 로그인
		System.out.println("13. " + str3.trim());
		// replace(): 문자열 내 특정 문자를 다른 문자로 바꿈
		System.out.println("14. " + str1.replace("abc", "바꿔"));
		// replaceAll(): 문자열 내 정규 표현식에 해당하는 문자를 교체
		System.out.println("15. " + str5.replaceAll("[ㄱ-ㅎz]", ""));
		
		System.out.println("원본은 바뀌지 않음------------");
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
	}
}
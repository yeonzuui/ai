package com.lec.ex; // 패키지 폴더

public class VarEx01 {
	public static void main(String[] args) {
		// 변수타입 변수명 = 값;
		int age = 27;// 4byte 정수
		// age = 27.5; 변수타입과 다른 값은 Error
		String name = "제니"; 
		// 두글자 이상은 쌍따옴표 
		// 처음 변수 선언시에는 대문자 
		// "제니"가 들어있는 참조값을 name에 할당(참조변수)
		name = "홍길동";
		System.out.println("안녕하세요. " + age + "살 "+ name +"씨"); //ctrl + alt + ↓(한줄복사)↓
		System.out.println("안녕하세요. " + age + "살 "+ name +"씨"); //ctrl + alt + ↓(한줄복사)
		System.out.println("안녕하세요. " + age + "살 "+ name +"씨"); //ctrl + alt + ↓(한줄복사)
		age = 29; name = "홍길동";
		System.out.println("안녕하세요. " + age + "살 "+ name +"씨"); //ctrl + alt + ↓(한줄복사)
		System.out.println("안녕하세요. " + age + "살 "+ name +"씨"); //ctrl + alt + ↓(한줄복사)
	}
}
;
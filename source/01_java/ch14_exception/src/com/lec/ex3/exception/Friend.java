package com.lec.ex3.exception;
// 데이터: 이름, 전화번호, 생년월일(Date) 
// Friend f = new Friend("홍길동", "010-9999-9999", new Date(98, 8, 10))
// sysout(f) → [이름]홍길* [전화]***-****-9999 [생일]9월10일 ♬ 생일축하 ♬

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	// data
	private String name;
	private String tel;
	private Date   birthday;
	
	// Constructor overloading
	public Friend(String name) { // 매개변수 1개
		this.name = name;
	}
	public Friend(String name, String tel) { // 매개변수 2개
		super();
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birthday) { // 매개변수 3개
		super();
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}
	@Override 
	public String toString() { // [이름]홍길* [전화]***-****-9999 [생일]9월10일 ♬ 생일축하 ♬
		String result = "";
		// 이름
		String nameOut = name.substring(0, name.length()-1) + "*"; // 이름 맨마지막 글자 *로 처리
		result += "[이름]" + nameOut;
		// 전화
		if(tel != null) {
			String telOut = tel.substring(tel.lastIndexOf("-")+1); // replaceAll → 정규표현식 나중에
			result += "[전화]***-****-" + telOut;
		}
		// 생일
		if(birthday != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("M월 d일");
			String birthOut = sdf.format(birthday);
			result += "[생일]" + birthOut;
			// 오늘이 생일인지 아닌지(birthOut과 비교: 월,일만 필요)
			String today = sdf.format(new Date()); // "9월 10일"
			if (today.equals(birthOut)) {
				result += "♬ 생일축하 ♬";
			}
		}
		return result;
	} // main
} // class

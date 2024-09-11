package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_Outputstream {
	public static void main(String[] args) {
		// OutputStream 객체 선언 및 초기화
		OutputStream os = null;
		try {
			// 1. 파일 열기(or 파일 생성)
			os = new FileOutputStream("txtFile/outTest.txt", true); 
			// byte[] bs = {'H', '', '', ... };
			// msg에 파일에 쓸 문자열 데이터를 할당
			String msg = "DBMS 첫날\n";
			// String을 byte 배열로 변환하고 bs에 할당
			byte[] bs = msg.getBytes(); 
			// 2. 파일에 데이터 쓰기
			// byte배열 bs를 파일에 씀
			os.write(bs);
			System.out.println("파일 출력 성공");
		} catch (IOException e) {
			System.out.println("폴더가 없을 때 : " + e.getMessage());
		} finally {
			try { // 3. 파일 닫기
				if(os!=null) os.close();
			} catch (IOException e2) {
			}
		} 
	} // main
} // class

// OutputStream: 데이터를 1byte 단위로 쓸 수 있게 하는 스트림
// FileOutputStream("파일경로", T/F): 파일에 데이터 쓰기, 없는 파일은 생성
// false → default, 기존 데이터 덮어씌워짐
// true → 기존 데이터를 유지하고 그 뒤에 새로운 데이터 덧붙임
// getBytes(): 문자열을 바이트 배열로 변환
// write(): 파일에 데이터 쓰기
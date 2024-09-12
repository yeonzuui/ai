package com.lec.ex2_readerWriter;

import java.io.*;

public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 1.
			while(true) { // 2.
				int i = reader.read(); // 2바이트 읽기
				if(i==-1)break;
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 없을 경우: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("읽기 권한 오류: " + e.getMessage());
		} finally { // 3.
			try {
				if(reader!=null) reader.close();
			} catch (Exception e2) {
			}
		} 
	} // main
} // class

// reader: 2byte씩 읽을 수 있게 하는 스트림
// FileReader("파일경로"): 파일 열기 및 read 준비
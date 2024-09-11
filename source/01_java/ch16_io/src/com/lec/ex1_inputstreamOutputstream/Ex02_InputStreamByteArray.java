package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1)파일을 연다(스트림객체생성) (2)데이터를읽는다(read메소드사용) (3)파일을 닫는다(close메소드사용)
// 한 줄(10byte)씩 읽기
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		// (1)
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/intest.txt");
			// 10byte짜리 배열 생성, bs에 10byte씩 읽어오는 용도
			byte[] bs = new byte[10];
			// (2)
			while(true) {
				int readByteCount = is.read(bs);
				if(readByteCount == -1) break;
				for(int i=0 ; i <readByteCount; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is!=null) is.close();
			}catch(IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}

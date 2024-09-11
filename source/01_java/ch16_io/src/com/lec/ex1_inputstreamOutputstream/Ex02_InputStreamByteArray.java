package com.lec.ex1_inputstreamOutputstream;
// 효율성을 위해 byte 배열을 이용하여 10byte씩 읽기
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 한 줄(10byte)씩 읽기
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		// 1. 스트림 객체 생성
		// InputStream 객체 is를 선언 및 초기화
		InputStream is = null;
		// FileInputStream 객체를 is에 할당
		try {
			is = new FileInputStream("txtFile/intest.txt");
			// 2. 파일 읽기
			// 크기가 10인 바이트 배열 bs를 생성 = 10byte씩 읽는 용도
			byte[] bs = new byte[10];
			while(true) {
				// 읽어온 byte수를 readByteCount에 할당
				int readByteCount = is.read(bs);
				if(readByteCount == -1) break;
				// 반복한 각 byte를 char로 변환 
				for(int i=0 ; i <readByteCount; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { // 3. 파일 닫기
			try {
				if(is!=null) is.close();
			}catch(IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}

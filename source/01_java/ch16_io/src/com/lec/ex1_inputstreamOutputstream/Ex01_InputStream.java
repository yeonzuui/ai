package com.lec.ex1_inputstreamOutputstream;

import java.io.*;
// 1. 파일 열기(스트림 객체 생성) 
// 2. 데이터 읽기: read() 
// 3. 파일 닫기: close()
public class Ex01_InputStream {
	public static void main(String[] args) {
		// InputStream 객체 is를 선언 및 초기화
		InputStream is = null;
		// FileInputStream 객체를 is에 할당
		try {
			is = new FileInputStream("txtFile/inTest.txt"); //1.파일열기
			while(true) {
				int i = is.read(); 
				if(i == -1) break; // 파일의 끝이면 break;
				System.out.print((char)i); // 읽은 값(int)을 char로 형변환
//				System.out.print((char)i + "(" + i + ")"); // 아스키코드값도 같이 출력
			}
			System.out.println("끝");
			// 3. 파일 닫는다
		} catch (FileNotFoundException e) {
			System.out.println("예외 메세지: 파일 못 찾음 " + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is!=null) is.close(); // is가 null이 아닐 때만 파일 닫기
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
// InputStream: 1byte씩 읽을 수 있게 하는 스트림
// FileInputStream("파일경로(절대경로도 가능)"): 파일 열기 및 read 준비
// 파일경로에서 [/]는 [\\]로 대체 가능
// FileNotFoundException: 파일을 찾지 못할 때 발생 → try-catch(예외처리)
// read(): 데이터를 읽고, 읽어온 byte 수를 정수로 표현, 파일 끝에 도달하면 -1을 반환
// close(): finally 블록에서 파일 닫기, 메모리 누수 방지 위함
// IOException: 파일 경로가 잘못되었거나 읽기/쓰기 권한이 없을 때 발생 → try-catch(예외처리) 
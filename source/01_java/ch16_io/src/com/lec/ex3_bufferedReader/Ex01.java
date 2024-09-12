package com.lec.ex3_bufferedReader;
// 텍스트 파일을 read, 한 줄씩 출력(보조 스트림 객체 BufferedReader 사용)
import java.io.*;

public class Ex01 {
	public static void main(String[] args) {
		// 스트림 객체 선언 및 초기화
		Reader         reader = null;
		BufferedReader br     = null;
		// 파일 열기 및 read 준비
		try {
			reader = new FileReader("txtFile/inTest.txt"); 
			br = new BufferedReader(reader); 
			while(true){
				String line = br.readLine(); // 한줄씩 read / 파일이 끝이면 null
				if(line==null)break;
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br!=null)br.close();
				if(reader!=null)reader.close();
			} catch (Exception e2) {
			}
		}
	}
}

// BufferedReader: Reader를 보조, FileReader를 감싸서 버퍼링 기능을 추가, 데이터 읽기 기능 향상
// readLine(): 한 줄씩 read. 파일 끝에 도달하면 null을 반환하고 loop 종료
// BufferedReader를 먼저 닫는 것이 좋음: BufferedReader 닫으면 FileReader도 닫힘
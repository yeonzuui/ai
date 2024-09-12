package com.lec.ex1_inputstreamOutputstream;
// 파일 복사 작업(InputStream, InputStream 사용)
import java.io.*;

// ~/bts_7.mp4 => ~/bts_copy.mp4 (7,460,545 byte) 
public class Ex04_fileCopy {
	public static void main(String[] args) {
		// 시간 측정 시작
		long start = System.currentTimeMillis(); // 1970년 1월 1일부터 지금까지의 밀리초
		// 파일 입출력 스트림 생성
		InputStream is = null;
		FileOutputStream os = null;
		try {
			// 원본 파일 read 위한 입력 스트림 생성
			// 복사할 파일 write 위한 출력 스트림 생성
			is = new FileInputStream("D:/ai/lecNote/01_java/bts_7.mp4");
			os = new FileOutputStream("D:\\ai\\lecNote\\01_java\\bts_copy.mp4");
			// 복사된 byte 수를 추적하는 변수(cnt) 생성
			int cnt = 0;
			// 진행 상황 출력
			while (true) {
				int i = is.read(); // read & write
				if(i == -1) break;
				os.write(i);
				cnt++;
				// 30만 byte마다 복사 진행 상황을 %로 출력
				if(cnt % 300000 == 0) {
					System.out.println(cnt + "/7,460,545 번 = " + (cnt/7460545.0)*100 + "% 완료");
				}
			}
			System.out.println("파일 복사 완료");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is!=null)is.close();
				if(os!=null)os.close();
			}catch(IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
		// 시간 측정 종료 및 출력(초단위)
		long end = System.currentTimeMillis(); // 1970.1.1부터 종료시점까지의 밀리초
		System.out.println((end-start)/1000.0 + "초 걸림");
	}
}
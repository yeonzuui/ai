package com.lec.ex1_inputstreamOutputstream;

import java.io.*;

// ~/bts_7.mp4 => ~/bts_copy.mp4 (7,460,545 byte) 
public class Ex04_fileCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970년 1월 1일부터 지금까지의 밀리초
		
		InputStream is = null;
		OutputStream os = null;
		try {
			// /는 \\로 대체 가능
			is = new FileInputStream("D:/ai/lecNote/01_java/bts_7.mp4");
			os = new FileOutputStream("D:\\ai\\lecNote\\01_java\\bts_copy.mp4");
			int cnt = 0;
			// 진행 상황
			while (true) {
				int i = is.read(); // read & write
				if(i == -1) break;
				os.write(i);
				cnt++;
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
		long end = System.currentTimeMillis(); // 1970.1.1부터 종료시점까지의 밀리초
		System.out.println((end-start)/1000.0 + "초 걸림");
	}
}

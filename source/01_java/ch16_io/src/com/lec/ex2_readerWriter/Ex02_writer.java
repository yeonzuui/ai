package com.lec.ex2_readerWriter;

import java.io.*;

public class Ex02_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/msg.txt", true); // append 출력 스트림
			String msg = "내일부터 오라클입니다\nDBMS는 개발자뿐 아니라, 데이터를 다룰 과학자에게도 필수\n";
			writer.write(msg);
			msg = "두 번째 write입니다\n";
			writer.write(msg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer!=null)writer.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

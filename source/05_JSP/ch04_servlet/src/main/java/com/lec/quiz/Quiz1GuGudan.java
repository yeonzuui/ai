package com.lec.quiz;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Quiz1GuGudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    public Quiz1GuGudan() {
//        super();
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()호출");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request해서 dansu를 String 배열로 access
		String[] dansu = request.getParameterValues("dansu");
		// dansu를 int 배열로 변환(intDansu)
		int[] intDansu = new int[dansu.length];
		for(int i=0 ; i<dansu.length ; i++) {
			intDansu[i] = Integer.parseInt(dansu[i]);
		}
		// response text 설정
		response.setContentType("text/html;charset=UTF-8");
		// stream 생성
		PrintWriter out = response.getWriter();
		// 구구단 결과 출력(for문 이용)
		if( intDansu != null) {
			for(int s: intDansu) {
				out.println("<h4>" + s + "단</h4>");
				for(int i=1 ; i<=9 ; i++) {
					out.printf("%d * %d = %d<br>", s, i, s*1);
				}
			}
		}else {
			out.println("입력하신 수가 없습니다");
		}
		// 닫기 
		out.close();
	}
}

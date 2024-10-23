package com.lec.ex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/ex2") web.xml에 URL을 mapping
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    public Ex2() {
//        super();
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// parameter access
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0; // 누적할 변수
		for(int i=1 ; i<=su ; i++) {
			sum += i;
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스트림 생성
		String msg = String.format("<h2>1부터 %d까지 누적한 합은 %d입니다</h2>", su, sum);
		out.println(msg);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

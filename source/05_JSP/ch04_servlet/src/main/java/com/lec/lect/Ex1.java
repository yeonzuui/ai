package com.lec.lect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    public Ex1() {
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
	
	// actionDo 메소드 만들고 throw exception
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// name, pw parameter받고, GET방식인지 POST방식인지까지 브라우저에 뿌리기
		// request는 내장객체
		String name   = request.getParameter("name");
		String pw     = request.getParameter("pw");
		String method = request.getMethod(); // method도 access 가능
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.println("<h2> 이름은 " + name + "</h2>");
		out.println("<h2> 비번은 " + pw + "</h2>");
		out.println("<h2> 요청 전송 방식은 " + method + "</h2>");
		out.close();
	}
}









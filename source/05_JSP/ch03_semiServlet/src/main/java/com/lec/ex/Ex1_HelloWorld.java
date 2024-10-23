package com.lec.ex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// URL mapping
@WebServlet(urlPatterns = "/HelloWorld")

public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;      
//    public Ex1_HelloWorld() {
//        super();
//    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// http://localhost:8090/ch03~/HelloWorld 
		// GET방식으로 요청하면 실행되는 부분
		System.out.println("GET방식으로 요청");
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// POST방식으로 요청하면 실행되는 부분
		System.out.println("POST방식으로 요청");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		// 브라우저 화면에 <h1>HelloWorld</h1>가 있는 HTML 보냄
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("<link href='css/ex.css' rel='stylesheet'>");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. 첫 servlet 예제입니다</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}










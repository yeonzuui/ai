package com.lec.lect;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Ex3_LifeCycle
 */
@WebServlet("/LifeCycle")
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_LifeCycle() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Servlet 객체가 생성되자마자 실행
		System.out.println("Ex3_LifeCycle Servlet 생성될 때 실행");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// Servlet 객체가 메모리에서 소멸될 때 실행
		System.out.println("Ex3_LifeCycle Servlet 객체가 소멸될 때 실행");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// service를 Override하면 doGet()과 doPost()는 실행되지 않고 service 실행
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().println("<h1>service() 함수 실행</h1?");
//		System.out.println("Ex3_LifeCycle service() 실행");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 요청 시 실행
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		out.println("<h1>doGet() 함수 실행</h1?");
		out.close();
		System.out.println("Ex3_LifeCycle doGET() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 요청 시 실행
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>doPost() 함수 실행</h1?");
		out.close();
		System.out.println("Ex3_LifeCycle doPost() 실행");
	}

}

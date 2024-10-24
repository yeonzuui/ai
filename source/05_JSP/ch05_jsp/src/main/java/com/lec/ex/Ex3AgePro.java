package com.lec.ex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ex3_agePro")
/**
 * Servlet implementation class Ex3AgePro
 */
public class Ex3AgePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3AgePro() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ex3_pass.jsp로 다시 request 요청
		int age = Integer.parseInt(request.getParameter("age"));
		if(age >= 19) {
			response.sendRedirect("lect_innerObject/ex3_pass.jsp?age=" + age);
		}else {
			response.sendRedirect("lect_innerObject/ex3_ng.jsp?age=" + age);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

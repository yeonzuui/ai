package com.lec.quiz;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Join
 */
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hiddenParam = request.getParameter("hiddenParam");
		String name        = request.getParameter("name");
		String id          = request.getParameter("id");
		String pw          = request.getParameter("pw");
		String birth       = request.getParameter("birth");
		String[] hobby     = request.getParameterValues("hobby");
		String gender      = request.getParameter("gender");
		String email       = request.getParameter("email");
		String[] mailSend  = request.getParameterValues("mailSend");
		
		if(pw==null) {
			response.sendRedirect("quiz/join.html");
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<h2>이름: " + name + "</h2>");
		
		out.println("</head>");
		out.println("</html>");
		out.close();
	}

}

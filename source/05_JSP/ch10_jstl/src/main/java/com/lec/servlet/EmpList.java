package com.lec.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.lec.dao.EmpDao;
import com.lec.dto.Emp;
@WebServlet("/emplist")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao empDao = EmpDao.getInstance();
		ArrayList<Emp> empList = empDao.getEmpList();
		// view 단에 출력할 내용은 request에 setAttribute
		request.setAttribute("empList", empList);
		// jsp 페이지로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

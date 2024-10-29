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
@WebServlet("/empSch")
public class EmpSch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// schName과 schJob 파라미터 받아서,
		EmpDao empDao = EmpDao.getInstance();
		String schName = request.getParameter("ename");
		String schJob  = request.getParameter("job");
		// dao.getEmpList(schName, schJob)의 결과를 request에 setAttribute
		ArrayList<Emp> empSch = empDao.getEmpList(schName, schJob);
		System.out.println(empSch.size());
		request.setAttribute("empSch", empSch);
		// jsp로 forward (empSch.jsp)
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empSch.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

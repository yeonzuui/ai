package com.lec.ex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.lec.ex.service.DeleteService;
import com.lec.ex.service.InfoService;
import com.lec.ex.service.InsertService;
import com.lec.ex.service.ListService;
import com.lec.ex.service.Service;
import com.lec.ex.service.UpdateService;
import com.lec.ex.service.UpdateService2;


@WebServlet("*.do")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null;
		String viewPage = null;
		if(command.equals("/list.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "person/list.jsp";
		} else if(command.equals("/info.do")){
			service = new InfoService();
			service.execute(request, response);
			viewPage = "person/info.jsp";
		} else if(command.equals("/insert.do")) {
			viewPage = "person/insert.jsp";
		} else if(command.equals("/delete.do")) {
			service = new DeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		} else if(command.equals("/update.do")) {
			service = new InfoService();
			service.execute(request, response);
			viewPage = "person/update.jsp"; 
		} else if(command.equals("/update2.do")) { // person 내용이 input의 value값
			service = new InfoService();
			service.execute(request, response);
			viewPage = "person/update2.jsp"; // person 내용이 input의 placeholder값
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null;
		String viewPage = null;
		if(command.equals("/list.do")) {
			service = new ListService();
			service.execute(request, response);
			viewPage = "person/list.jsp";
		} else if(command.equals("/insert.do")){
			service = new InsertService();
			service.execute(request, response);
			viewPage = "list.do"; // list.do 요청, webapp 폴더로 인식
		} else if(command.equals("/update.do")) {
			service = new UpdateService();
			service.execute(request, response);
			viewPage = "info.do";
		} else if(command.equals("/info.do")){
			service = new InfoService();
			service.execute(request, response);
			viewPage = "person/info.jsp";
		} else if(command.equals("/update2.do")) {
			service = new UpdateService2(); // 빈 스트링만 수정
			service.execute(request, response);
			viewPage = "info.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}

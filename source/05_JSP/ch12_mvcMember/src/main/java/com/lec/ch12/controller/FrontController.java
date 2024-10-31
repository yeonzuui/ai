package com.lec.ch12.controller;

import java.io.IOException;

import com.lec.ch12.service.MemberJoinService;
import com.lec.ch12.service.MemberListService;
import com.lec.ch12.service.Service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어온 요청을 판별하고, 그에 따른 service.execute(req, res) 호출한 후 view단으로
		String uri 	   = request.getRequestURI();  		  // [/ch12_mvcMember/memberList.do]
		String conPath = request.getContextPath(); 		  // [/ch12_mvcMember]
		String command = uri.substring(conPath.length()); // [memberList.do]
		// System.out.println("요청 command: " + command);
		Service service  = null;
		String  viewPage = null;
		
		if(command.equals("/memberList.do")) {
			service = new MemberListService();
			service.execute(request, response);
			viewPage = "member/memberList.jsp";
		}else if(command.equals("/memberJoin.do")) {
			viewPage = "member/memberJoin.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // DB연동 불필요
		dispatcher.forward(request, response); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어온 요청을 판별하고, 그에 따른 service.execute(req, res) 호출한 후 view단으로
		String uri 	   = request.getRequestURI();  		  // [/ch12_mvcMember/memberList.do]
		String conPath = request.getContextPath(); 		  // [/ch12_mvcMember]
		String command = uri.substring(conPath.length()); // [memberList.do]
		Service service  = null;
		String  viewPage = null;
		if(command.equals("/memberList.do")) { // 리스트 출력 용도 아닌 request에 post 담는 용도
			service = new MemberListService();
			service.execute(request, response);
			viewPage = "member/memberList.jsp";
		}else if(command.equals("/memberJoin.do")) {
			service = new MemberJoinService();
			service.execute(request, response);
			viewPage = "memberList.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // DB연동 불필요
		dispatcher.forward(request, response); 
	}
}

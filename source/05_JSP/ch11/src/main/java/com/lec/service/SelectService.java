package com.lec.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// Select 로직: parameter들 받아 dao 함수 호출 결과를 request에 setAttribute
		System.out.println("pageNum 파라미터로 받아, 몇 등~몇 등까지 찾아오는 dao함수 결과를 request에 setAttribute");
		request.setAttribute("list", "list결과를 ArrayList로");
	}

}

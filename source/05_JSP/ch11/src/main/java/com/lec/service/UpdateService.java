package com.lec.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// Update 로직 
		System.out.println("parameter들 받아 dao 함수 호출 후, 결과를 request에 setAttribute");
		request.setAttribute("updateResult", 1);
	}

}

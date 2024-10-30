package com.lec.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// Insert 로직: parameter들 받아 dao 함수 호출 결과를 request에 setAttribute
		System.out.println("insert 로직 수행함");
		request.setAttribute("insertResult", 1);
	}

}

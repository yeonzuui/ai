package com.lec.ex.service;

import com.lec.ex.dao.PersonRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// id 파라미터 받아 dao를 통해 person 정보를 request에 setAttribute
		int id = Integer.parseInt(request.getParameter("id"));
		PersonRepository dao = PersonRepository.getInstance();
		request.setAttribute("person", dao.getPerson(id));
		
	}
}

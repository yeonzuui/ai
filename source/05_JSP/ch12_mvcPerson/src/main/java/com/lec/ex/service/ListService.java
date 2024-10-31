package com.lec.ex.service;

import com.lec.ex.dao.PersonRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PersonRepository dao = PersonRepository.getInstance();
		request.setAttribute("personList", dao.getPersonList());
		
	}
	
}

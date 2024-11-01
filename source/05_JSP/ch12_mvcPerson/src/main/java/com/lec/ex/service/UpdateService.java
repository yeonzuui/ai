package com.lec.ex.service;

import java.sql.Date;

import com.lec.ex.dao.PersonRepository;
import com.lec.ex.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// id, name, tel, address, birth, memo 파라미터 받아 update
		int    id 		= Integer.parseInt(request.getParameter("id"));
		String name 	= request.getParameter("name");
		String tel  	= request.getParameter("tel");
		String address  = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		Date   birth    = null;
		if(!birthStr.equals("")) { // birth 파라미터 받은 경우, 빈 스트링 아닐 때 
			birth = Date.valueOf(birthStr);
		}
		String memo     = request.getParameter("memo");
		PersonRepository dao = PersonRepository.getInstance();
		// 수정할 내용
		Person person = new Person(id, name, tel, address, birth, memo, null);
		int updateResult = dao.updatePerson(person); // DB 수정
		System.out.println((updateResult==PersonRepository.SUCCESS) ? "수정 성공" : "수정 실패");

	}

}

package com.lec.ex.service;

import java.sql.Date;

import com.lec.ex.dao.PersonRepository;
import com.lec.ex.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//  name, tel, address, birth, memo 파라미터 받아 insert 결과를 request에 setAttribute
		String name 	= request.getParameter("name");
		String tel      = request.getParameter("tel");
		String address  = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		// birthStr을 Date로 형변환
		Date birth = null;
		if(!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		String memo     = request.getParameter("memo");
		Person newPerson = new Person(0, name, tel, address, birth, memo, null);
		PersonRepository dao = PersonRepository.getInstance();
		int insertResult = dao.insertPerson(newPerson);
//		request.setAttribute("insertResult", insertResult); // sol 1
		if(insertResult == PersonRepository.SUCCESS) {      // sol 2
 			request.setAttribute("insertMsg", "지인추가 완성");
		}else {
			request.setAttribute("insertMsg", "지인추가 실패");
		}
	}
}

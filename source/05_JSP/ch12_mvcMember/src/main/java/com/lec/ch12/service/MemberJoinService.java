package com.lec.ch12.service;

import java.sql.Date;

import com.lec.ch12.dao.MemberRepository;
import com.lec.ch12.dto.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// parameter(id, pw, name, birth) 받아 dao를 통해 id 중복체크 후 join 수행 결과를 request에 set
		String id    = request.getParameter("id");
		String pw    = request.getParameter("pw");
		String name  = request.getParameter("name");
		// String을 숫자형으로: Integer.parseInt("10");
		// String을 Date형으로: Date.valueOf("2000-12-12"); 
		String birthStr = request.getParameter("birth");
		Date birth = null; // 빈 스트링 error 대비
		if(!birthStr.equals("")) { // birth 입력한 경우, param이 빈 스트링이 "아니면"
			birth = Date.valueOf(birthStr);
		}
		Member newMember = new Member(id, pw, name, birth, null);
		MemberRepository repository = MemberRepository.getInstance();
		if(repository.getCountMember(id)==MemberRepository.MEMBER_NONEXISTENT) {
			int insertResult = repository.insertMember(newMember); // 회원가입
			request.setAttribute("insertResult", insertResult); // 1. 방법
			if(insertResult==MemberRepository.SUCCESS) {
				request.setAttribute("insertMsg", "가입성공");
			}else {
				request.setAttribute("insertMsg", "가입실패");
			}
		}else {
			
		}
	}

}

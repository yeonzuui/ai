package com.lec.ex.service;

import com.lec.ex.dao.PersonRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// pageNum 파라미터 받아, startRow, endRow 계산 → getPersonList(startRow, endRow)→
		// pageCnt, startPage, endPage 계산 후 view단으로 넘길 데이터 request에 setAttribute
		// list.do이나 list.do?=pageNum=7
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum); // 숫자형 현재 페이지
		final int PAGESIZE  = 10, // 페이지당 보여지는 갯수
				  BLOCKSIZE = 10; 
		// 공식
		int startRow = (currentPage - 1) * PAGESIZE+ 1;
		int endRow   = startRow + PAGESIZE -1;
		
		PersonRepository dao = PersonRepository.getInstance();
		request.setAttribute("personList", dao.getPersonList(startRow, endRow));
		
		int totCnt    = dao.getCount(); // DB에 입력된 person 수 
		int pageCnt   = (int)Math.ceil((double) totCnt / PAGESIZE); // 전체 페이지 수
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage   = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		// view단에서 필요한 항목들을 request에 setAttribute
		// 왼쪽에 [이전] 출력할지 여부(startPage와 BLOCKSIZE 비교)
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage); // 현재 페이지(int)
		// 오른쪽에 [다음] 출력할지 여부(endPage와 pageCnt 비교)
		request.setAttribute("pageCnt", pageCnt);
	}
	
}







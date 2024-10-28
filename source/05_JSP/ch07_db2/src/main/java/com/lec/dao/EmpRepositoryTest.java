package com.lec.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.lec.dto.Emp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empDaoTest")
public class EmpRepositoryTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpRepository empRepository = EmpRepository.getInstance();
		
		ArrayList<Emp> emplist = empRepository.empList();
		System.out.println(" empList()결과: " + emplist.size() + "행");
		for(Emp emp: emplist) {
			System.out.println(emp);
		}
		
		emplist = empRepository.empListByDeptno("40");
		System.out.println(" empListByDeptno(\"40\")결과: " + emplist.size() + "행");
		if(emplist.isEmpty()) {
			System.out.println("해당 부서번호의 사원이 없습니다");
		}else {
			for(Emp emp: emplist) {
				System.out.println(emp);
			}
		}
		
		emplist = empRepository.empListBySearchName("         ");
		System.out.println(" empListBySearchName(\"         \")결과: " + emplist.size() + "행");
		if(emplist.size()!=0) {
			for(Emp emp:emplist) {
				System.out.println(emp);
			}
		}else {
			System.out.println("해당 알파벳이 들어간 사원명은 없습니다");
		}
	}
}

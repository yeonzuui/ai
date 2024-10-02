package com.lec.ex;

import java.util.ArrayList;
import com.lec.dao.EmpRepository;
import com.lec.dto.Emp;

public class Ex1_selectAllOracle {
	public static void main(String[] args) {
		EmpRepository repository = EmpRepository.getInstance();
		ArrayList<Emp> emps = repository.getEmpList();
		if(emps.isEmpty()) { // = emps == 0?
			System.out.println("등록된 사원이 없습니다.");
		}else {
			// for문
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t급여\t상여\t부서번호");
			for(Emp emp : emps) {
				System.out.println(emp);
			}
		}
	} // main
} // class

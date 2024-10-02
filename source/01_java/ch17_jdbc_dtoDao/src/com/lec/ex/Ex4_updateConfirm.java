package com.lec.ex;

import java.util.Scanner;
import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

public class Ex4_updateConfirm {
	public static void main(String[] args) {
		DeptRepository deptRepository = DeptRepository.getinstace();
		Scanner scanner = new Scanner(System.in);
		System.out.println("수정할 부서번호는 > ");
		int deptno = scanner.nextInt();
		// 중복 점검
		Dept dept = deptRepository.getDept(deptno);
		if(dept != null) {
			System.out.print("수정할 부서명은 > ");
			String dname = scanner.next();
			System.out.print("수정할 부서위치는 > ");
			String loc = scanner.next();
			deptRepository.updateDept(deptno, dname, loc); // 업데이트함수
		}else {
			System.out.println("유효한 부서번호가 아닙니다.");
		}
		scanner.close();
	} // main
} // class

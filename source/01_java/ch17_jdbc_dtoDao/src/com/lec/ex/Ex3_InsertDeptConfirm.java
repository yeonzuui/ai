package com.lec.ex;

import java.util.Scanner;

import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

// 부서번호를 입력받아 중복체크 후, 부서명, 부서위치 받아 insert
public class Ex3_InsertDeptConfirm {
	public static void main(String[] args) {
		DeptRepository deptRepository = DeptRepository.getinstace();
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력할 부서번호는 > ");
		int deptno = scanner.nextInt();
		// 중복 확인
		Dept dept = deptRepository.getDept(deptno);
		if(dept == null) {
			System.out.println("입력할 부서명은 > ");
			String dname = scanner.next();
			System.out.println("입력할 부서위치는 > ");
			String loc = scanner.next();
			deptRepository.insertDept(deptno, dname, loc);
		}else {
			System.out.println("중복된 부서번호는 입력 불가합니다");
		} 
	} // main
} // class

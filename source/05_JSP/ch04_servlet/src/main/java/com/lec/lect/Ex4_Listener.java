package com.lec.lect;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener // annotation 필수
public class Ex4_Listener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에 load되는 시점에 실행
		System.out.println("★ ★ ★ ★ ★ ★ ★ ch04 프로젝트가 구동 ★ ★ ★ ★ ★ ★ ★");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에서 해제되는 시점에 실행
		System.out.println("★ ★ ★ ★ ★ ★ ★ ch04 프로젝트 종료 ★ ★ ★ ★ ★ ★ ★");		
	}
}

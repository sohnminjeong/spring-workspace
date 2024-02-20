package com.kh.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTestApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/user.xml");
		
		User user01 = (User) factory.getBean("user01");
		System.out.println(user01);
		
		String username = (String) factory.getBean("username");
		System.out.println(username);
		
		User user02 = (User) factory.getBean("user02");
		System.out.println(user02);
		
		User user03 = (User) factory.getBean("user03");
		System.out.println(user03);
	}
}

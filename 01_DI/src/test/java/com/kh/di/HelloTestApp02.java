package com.kh.di;

public class HelloTestApp02 {

	public static void main(String[] args) {
		
		// 1. 사용할 Bean 정보를 갖고 있는 hello.properties를
		// parsing, Bean 객체 생성할 HelloFactory 객체 생성
		// HelloFactory는 싱글톤이기 때문에 new가 아닌 .getInstace()로 불러오기
		HelloFactory factory = HelloFactory.getInstance();
		
		// 2. factory 객체로 parsing 할 리소스(hello.properties) 전달 
		factory.setConfigResource("./src/main/resources/config/hello.properties");
		
		// 3. fatory한테 hello 이름을 갖는 Hello 객체 요청
		Hello hello = factory.getBean("hello");
		
		// 4. printMessage() 호출
		hello.printMessage();
		
		
	}
	
}

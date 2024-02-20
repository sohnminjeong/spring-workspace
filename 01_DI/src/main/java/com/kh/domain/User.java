package com.kh.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


// @Data : Setter, Getter, AllArgsConstructor(모든 변수가 들어가는 생성자), ToString
@Data @NoArgsConstructor
public class User {
	private String userId;
	private String password;
	private int age;
	
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}

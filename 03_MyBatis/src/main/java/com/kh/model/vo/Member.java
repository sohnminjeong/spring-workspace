package com.kh.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Member {
	private String id;
	private String password;
	private String name;
	public Member(String id, String password) {
		this.id=id;
		this.password=password;
	}
	
}

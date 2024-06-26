package com.kh.aop.character;

import com.kh.aop.weapon.Weapon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
	private String name;
	
	private int level;
	
	private Weapon weapon;
	
	public String quest(String questName) throws Exception {
		return questName + " 퀘스트 진행 중";
	}
}


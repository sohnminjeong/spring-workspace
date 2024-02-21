package com.kh.aop.character;

import com.kh.aop.weapon.Weapon;

import lombok.Data;

@Data
public class Character {

	private String name;
	private int level;
	private Weapon weapon;
	
	public String quest(String questName) {
		return questName + " 퀘스트 진행 중";
	}
	
}

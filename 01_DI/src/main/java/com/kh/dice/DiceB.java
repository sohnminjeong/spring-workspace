package com.kh.dice;

import java.util.Random;

import lombok.Getter;

@Getter
public class DiceB {
private int value;
	
	public DiceB() {
		System.out.println(getClass().getName() + " 생성자..");
	}
	
	// 주사위를 던져 선택되는 숫자를 생산 : 1~6까지 랜덤
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}
	
}

package com.kh.dice.play;

import com.kh.dice.DiceA;

import lombok.Getter;

@Getter
public class Player01 {
	private DiceA diceA = new DiceA();
	private int totalValue;
	
	// count만큼 주사위 굴려서 주사위 합을 구하는 로직
	public void playDice(int count) {
		System.out.println("==> " + getClass().getName() + ".playDice() start...");
	
		for(int i=0; i < count; i++) {
			// 무작위 숫자 = .selectedNumber()
			diceA.selectedNumber();
			// diceA.getValue()접근할려면 DiceA클래스에서 DiceA가 @getter되어야 함
			System.out.println("[ " + diceA.getClass().getName() + " ]의 선택된 수 : " + diceA.getValue());
			totalValue += diceA.getValue();
			
		}
		System.out.println("==> " + getClass().getName() + ".playDice() end...");
	}
	
}

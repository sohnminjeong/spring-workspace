package com.kh.dice.play;

import com.kh.dice.Dice;

import lombok.Data;

@Data
public class Player03 {
	private Dice dice;
	private int totalValue;
	
	public Player03(Dice dice) {
		this.dice = dice;
	}

	public void playDice(int count) {
		System.out.println("==> " + getClass().getName() + ".playDice() start...");

		for (int i = 0; i < count; i++) {
			// 무작위 숫자 = .selectedNumber()
			dice.selectedNumber();
			// diceA.getValue()접근할려면 DiceA클래스에서 DiceA가 @getter되어야 함
			System.out.println("[ " + dice.getClass().getName() + " ]의 선택된 수 : " + dice.getValue());
			totalValue += dice.getValue();

		}
		System.out.println("==> " + getClass().getName() + ".playDice() end...");
	}
}

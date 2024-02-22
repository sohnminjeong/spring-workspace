package com.kh.aop.weapon;

public class Sword extends Weapon {

	public Sword() {
	}
	
	public Sword(String name) {
		super(name);
	}

	@Override
	public String attack() throws Exception {	
		
//		if (true) {
//			throw new Exception();
//		}
		
		return "검을 휘두른다.";
	}

	@Override
	public String toString() {
		return "Sword[name=" + name + "]";
	}
}
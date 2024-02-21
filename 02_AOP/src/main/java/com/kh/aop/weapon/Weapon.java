package com.kh.aop.weapon;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Weapon {
	protected String name;
	
	public abstract String attack() throws Exception;
}

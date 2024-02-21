package com.kh.aop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CharacterTest {

	@Autowired(required=false)
	private Character character;
	// di에서 userTestApp에서 factory-getbean까지 된 상태와 동일함(객체 생성된 상태)

	@Test
	void test() {}

	@Test
	void create() {
		assertThat(character).isNotNull();
	}
}

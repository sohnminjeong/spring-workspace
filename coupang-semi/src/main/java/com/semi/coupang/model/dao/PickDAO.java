package com.semi.coupang.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.coupang.model.vo.Pick;

@Repository
public class PickDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	// select
	public Pick select(Pick pick) {
		return session.selectOne("pick.select", pick);
	}
	
	
	// insert
	public int insert(Pick pick) {
		return session.insert("pick.insert", pick);
	}
	
	
	// delete
	public int delete(int pickCode) {
		return session.delete("pick.delete", pickCode);
	}
	
}

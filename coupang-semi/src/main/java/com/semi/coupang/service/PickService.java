package com.semi.coupang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.coupang.model.dao.PickDAO;
import com.semi.coupang.model.vo.Pick;

@Service
public class PickService {

	@Autowired
	private PickDAO dao;
	
	// select
	public Pick select(Pick pick) {
		return dao.select(pick);
	}
	
	
	// insert
	public int insert(Pick pick) {
		return dao.insert(pick);
	}
	
	// delete
	public int delete(int pickCode) {
		return dao.delete(pickCode);
	}
	
}

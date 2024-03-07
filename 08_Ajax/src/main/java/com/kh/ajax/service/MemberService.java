package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ajax.model.dao.MemberDAO;
import com.kh.ajax.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;
	
	public Member memberId(String id) {
		return dao.memberId(id);
	}
	
	public int memberInsert(Member member) {
		return dao.memberInsert(member);
	}
}

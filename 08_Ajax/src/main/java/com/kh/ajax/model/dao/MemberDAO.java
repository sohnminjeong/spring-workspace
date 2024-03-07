package com.kh.ajax.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ajax.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public Member memberId(String id) {
		return session.selectOne("memberMapper.memberId", id);
	}
	
	public int memberInsert(Member member) {
		return session.insert("memberMapper.memberInsert", member);
	}
	

}

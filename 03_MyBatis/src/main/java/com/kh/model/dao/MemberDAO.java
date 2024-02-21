package com.kh.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.model.vo.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate session;

	public List<Member> showAllMember() {
		return session.selectList("memberMapper.showAllMember");
	}
}

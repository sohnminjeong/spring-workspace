package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@Service
public class MemberService {
	
	// bean등록 되어있는건 autowired로 가져올 수 있음
	@Autowired
	private MemberDAO dao;
	
	public List<Member> showAllMember(){
		return dao.showAllMember();
	}
	
}

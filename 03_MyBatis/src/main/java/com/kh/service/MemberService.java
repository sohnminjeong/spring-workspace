package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.model.dao.MemberDAO;
import com.kh.model.dto.SearchDTO;
import com.kh.model.vo.Member;

@Service
public class MemberService {
	
	// bean등록 되어있는건 autowired로 가져올 수 있음
	@Autowired
	private MemberDAO dao;
	
	public List<Member> showAllMember(){
		return dao.showAllMember();
	}
	
	public int registerMember(Member vo) {
		// Member vo : controller에게 받은 것 
		return dao.registerMember(vo);
	}
	
	public Member loginMember(Member vo) {
		return dao.loginMember(vo);
	}
	
	public int updateMember(Member vo) {
		return dao.updateMember(vo);
	}
	
	public List<Member> findMember(String keyword, String select){
		SearchDTO dto = new SearchDTO();
		dto.setKeyword(keyword);
		dto.setSelect(select);
		return dao.findMember(dto);
	}
}


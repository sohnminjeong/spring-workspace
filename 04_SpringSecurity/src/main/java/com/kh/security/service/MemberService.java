package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.model.dao.MemberDAO;
import com.kh.security.model.vo.Member;

// Spring Security에서 제공하는 UserDetailsService 인터페이스 상속
@Service
public class MemberService implements UserDetailsService{
	
	//4) 비밀번호 암호화 위해 
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	//3) dao 연결 위해 
	@Autowired
	private MemberDAO dao;
	
	
	// 1) -> 로그인 시 자동으로 여기로 와요!
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = dao.getMemeberById(username);
		return member;
	}
	
	// 2) 회원가입
	public int registerMember(Member vo) {
		// 비밀번호 암호화 처리한 후 멤버 정보 다시 담아서 DAO에게 전달! 
		// 암호화 처리
		String encodePw = bcpe.encode(vo.getPassword());
		// 암호화 처리 된 비밀번호로 다시 세팅
		vo.setPassword(encodePw);
		return dao.registerMember(vo);
	}
}

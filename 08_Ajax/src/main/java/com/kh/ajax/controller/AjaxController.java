package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AjaxController {
	
	
	@Autowired
	private MemberService service;
	
	private int count = 0;
	// 01_count
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax로 요청이 들어옴!");
		return ++count;
	}
	

	// 02_encoding
	@ResponseBody
	@GetMapping("/encoding")
	// jsp에서 nick으로 보내고 있기 때문에 매개변수에 작성 필요
	public String encoding(String nick) {
		System.out.println("요청 들어옴");
		return nick;
		
	}
	
	// 03_register
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		//System.out.println("요청 들어왔어요잉");
		Member member = service.memberId(id);
		//System.out.println(member);
		if(member == null) return false;
		return true;

	}
	
	// 04_serial
	@ResponseBody
	@PostMapping("/serial")
	public Member serial(Member member) {
		service.memberInsert(member);
		return member;
	}
}

package com.kh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.model.vo.Member;
import com.kh.service.MemberService;

@Controller
public class MemberController {
	
	// autowired로 service 연결 
	@Autowired
	private MemberService service;
	
	@GetMapping("allMember")
	public String allMember(Model model) {
		List<Member> list = service.showAllMember();
		//바인딩
		model.addAttribute("list", list);
		return "allMember";
	}
	
}

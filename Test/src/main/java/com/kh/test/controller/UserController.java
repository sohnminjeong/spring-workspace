package com.kh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.model.vo.User;
import com.kh.test.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("selectUser")
	public String selectUser(int userNo, Model model) {
		
		User user = service.selectUser(userNo);
		System.out.println(user);
		if(user!=null) {
			model.addAttribute("user", user);
			return "searchSuccess";
		} else {
			return "searchFail";
		}
		
		
	}
}

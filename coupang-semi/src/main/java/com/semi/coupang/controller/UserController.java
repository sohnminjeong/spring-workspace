package com.semi.coupang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.semi.coupang.model.vo.User;
import com.semi.coupang.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(User user) {
		service.register(user);
		return "redirect:/";
	}
	
}

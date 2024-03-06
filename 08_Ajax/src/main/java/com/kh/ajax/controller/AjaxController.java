package com.kh.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AjaxController {
	
	private int count = 0;
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax로 요청이 들어옴!");
		return ++count;
	}
	
	
	
	@ResponseBody
	@GetMapping("/encoding")
	// jsp에서 nick으로 보내고 있기 때문에 매개변수에 작성 필요
	public String encoding(String nick) {
		System.out.println("요청 들어옴");
		return nick;
		
	}
}

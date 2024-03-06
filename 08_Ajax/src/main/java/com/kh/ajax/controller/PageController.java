package com.kh.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/ajax01")
	public String ajax01() {
		return "01_count";
	}
	
	@GetMapping("/ajax02")
	public String ajax02() {
		return "02_encoding";
	}
}

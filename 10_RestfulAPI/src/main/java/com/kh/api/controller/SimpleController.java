package com.kh.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.vo.Animal;

@RestController
@RequestMapping("/simple")
// simple 통해서만 들어와야 찾을 수 있음 
public class SimpleController {
	
	// http://localhost:8080/api/simple/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello Restful API!!";
	}
	
	//http://localhost:8080/api/simple/greet
	@GetMapping("/greet")
	public Animal greet() {
		Animal vo = new Animal("비둘기", "안녕~");
		return vo;
	}
	
	//http://localhost:8080/api/simple/allGreet
	@GetMapping("/allGreet")
	public List<Animal> allGreet(){
		List<Animal> list = new ArrayList<Animal>();
		for(int i=0; i<3; i++) {
			Animal vo = new Animal();
			vo.setName("펭귄, " + i);
			vo.setMessage("안녕~~, " + i);
			list.add(vo);
		}
		return list;
	}
}

package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.model.vo.Film;
import com.kh.paging.model.vo.Paging;
import com.kh.paging.service.FilmService;

import lombok.Getter;

@Controller
public class FilmController {

	@Autowired
	private FilmService service;
	
	@GetMapping("list")
	public String showFilm(Model model, Paging paging) {
		
		System.out.println(paging);
		
		List<Film> list = service.showFilm(paging);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(paging.getPage(), service.total()));
		return ("list");
	}
	
	
}

package com.kh.paging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.paging.model.dao.FilmDAO;
import com.kh.paging.model.vo.Film;
import com.kh.paging.model.vo.Paging;

@Service
public class FilmService {

	@Autowired
	private FilmDAO dao;
	
	public List<Film> showFilm(Paging paging){
		
		/*
		 * 
		 * 만약에 limit가 10인 경우
		 * page = 2 -> offset = 10
		 * page = 3 -> offset = 20
		 * page = 4 -> offset = 30
		 * 
		 * 만약 limit가 5인 경우 
		 * page = 2 -> offset = 5
		 * page = 3 -> offset = 10
		 * page = 4 -> offset = 15
		 * 
		 *  offset = limit * (page-1)
		 * */
		paging.setOffset(paging.getLimit()*(paging.getPage()-1));
		return dao.showFilm(paging);
	}
	
	public int total() {
		return dao.total();
	}
}

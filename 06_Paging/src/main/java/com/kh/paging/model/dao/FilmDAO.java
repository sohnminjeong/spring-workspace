package com.kh.paging.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.paging.model.vo.Film;
import com.kh.paging.model.vo.Paging;

@Repository
public class FilmDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public List<Film> showFilm(Paging paging){
		return session.selectList("filmMapper.showFilm", paging);
	}
	
	public int total() {
		return session.selectOne("filmMapper.count");
	}
}

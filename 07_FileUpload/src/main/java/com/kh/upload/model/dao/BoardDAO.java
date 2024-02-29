package com.kh.upload.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.upload.model.vo.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public int insert(Board b) {
		return session.insert("boardMapper.insert", b);
	}
	
	public List<Board> selectAll() {
		return session.selectList("boardMapper.selectAll");
	}
	
	public Board select(int no) {
		return session.selectOne("boardMapper.select", no);
		
	}
	
	public int update(Board b){
		return session.update("boardMapper.update", b);
	}	
	
	public int delete(int no) {
		return session.delete("boardMapper.delete", no);
	}
	
}

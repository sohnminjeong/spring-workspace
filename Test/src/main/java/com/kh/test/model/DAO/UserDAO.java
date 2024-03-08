package com.kh.test.model.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.test.model.vo.User;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	public User selectUser(int userNum) {
		return session.selectOne("userMapper.selectUser", userNum);
	}
}

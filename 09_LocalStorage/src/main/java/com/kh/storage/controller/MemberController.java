package com.kh.storage.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class MemberController {
	
	@PostMapping("/login")
	public String login(String id, String pwd, Model model) {
		
		// 로그인 처리를 했다 가정하에 
		
		// 자동 로그인, 개인정보수정 - 기존 비밀번호 정보
		// JWT(JSON Web Token) 토큰을 만들어서 해당 정보를 localStorage에 담아서 사용
		String token = jwtToken(id, pwd);
		model.addAttribute("token", token);
		
		// 로그인 되었다 가정 하에 토큰 받아서 해당 정보들 다시 가져와보기
		Claims claims = decodeJwt(token);
		String password = claims.get("pwd", String.class);
		System.out.println(password);
		return "result";
	}
	
	private String jwtToken(String id, String pwd) {
		Date now = new Date();
		Date expireDate = new Date(now.getTime() + 3600000); // 유효시간 1시간
		return Jwts.builder()
				.setSubject(id)
				.claim("pwd", pwd)
				.setIssuedAt(now) // 토큰이 발급된 시간
				.setExpiration(expireDate) // 토큰 만료 시간
				.signWith(SignatureAlgorithm.HS512, "storage-token")
				.compact();
	}
	
	private Claims decodeJwt(String token) {
		Jws<Claims> claims = Jwts.parser()
								.setSigningKey("storage-token")
								.parseClaimsJws(token);
		return claims.getBody();
	}

	

}

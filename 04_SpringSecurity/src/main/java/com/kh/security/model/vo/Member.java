package com.kh.security.model.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

// Spring Security에서 제공하는 UserDetails 인터페이스 상속
@Data @NoArgsConstructor
public class Member implements UserDetails{
	private String id;
	private String password;
	private String name;
	private String auth;	// 권한
	private int enabled;   // 탈퇴여부 체크 
	
	// getAuthorities() 권한 관리 메서드 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority(auth));
		return authList;
	}
	
	@Override
	public String getUsername() {
		return id;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	// 회원 탈퇴 여부 
	@Override
	public boolean isEnabled() {
		return enabled==1 ? true : false; 
	}
}

package com.semi.coupang.model.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class User implements UserDetails{
	private String id;
	private String password;
	private String name;
	private String phone;
	private String address;
	private String email;
	private String role;
	
	// 권한 관리 메서드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority(role));
		return authList;
	}

	@Override
	public String getPassword() {
		return null;
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

	//탈퇴여부 -> 필요한 경우 컬럼하나 더 만들어서 조건 걸기(ex. SpringSecurity참조)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}

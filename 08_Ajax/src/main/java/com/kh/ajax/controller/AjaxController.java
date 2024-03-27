package com.kh.ajax.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.MemberService;

import lombok.RequiredArgsConstructor;


@Controller
public class AjaxController {
	
	//20240327 시험 관련 ----------------------------------------------
	public static final String serviceKey = "UNmnLkcNtzgMKivBzvyb3TdrsqmthwquJWOHYpkKXK6aXtSdhG1gbTQ6EOqATL5t3ApCJ2hySkej4pCTXuaAZg%3D%3D";
	
	@ResponseBody
	@GetMapping(value="/animal", produces="application/json; charset=utf-8")
	public String animal(String name) throws IOException {
		
		String url = "https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo";
		
		url += "?ServiceKey=" + serviceKey;
		url += "&care_nm=" + URLEncoder.encode(name, "UTF-8"); // 한글처리
		url += "&_type=json";
		
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseText = ""; // JSON이 담기는 변수 
		String line = null;
		while((line = br.readLine())!=null) {
			responseText += line;
		}
		br.close();
		urlConnection.disconnect();
		System.out.println(responseText);
		return responseText;
	}
	
	/*--------------------------------------------------------*/
	
	@Autowired
	private MemberService service;
	
	private int count = 0;
	// 01_count
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax로 요청이 들어옴!");
		return ++count;
	}
	

	// 02_encoding
	@ResponseBody
	@GetMapping("/encoding")
	// jsp에서 nick으로 보내고 있기 때문에 매개변수에 작성 필요
	public String encoding(String nick) {
		System.out.println("요청 들어옴");
		return nick;
		
	}
	
	// 03_register
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		//System.out.println("요청 들어왔어요잉");
		Member member = service.memberId(id);
		//System.out.println(member);
		if(member == null) return false;
		return true;

	}
	
	// 04_serial
	@ResponseBody
	@PostMapping("/serial")
	public Member serial(Member member) {
		service.memberInsert(member);
		return member;
	}
}

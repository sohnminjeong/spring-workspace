package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	private String path = "D:\\upload\\";
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("파일 사이즈 " + file.getSize());
		System.out.println("파일 명 : " + file.getOriginalFilename());
		System.out.println("파일 파라미터명 : " + file.getName());
		
		fileUpload(file);
		
		return "redirect:/";
	}
	
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		for(MultipartFile file : files) {
			fileUpload(file);
		}
		return "redirect:/";
	}
	
	// 파일 업로드 기능 
	public String fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File(path + filename);
		file.transferTo(copyFile);  // 업로드한 파일이 지정한 path 위치로 저장
		
		return filename;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	// 글 등록
	@PostMapping("/write")
	public String postWrite(Board b) throws IllegalStateException, IOException {
		
		// 파일 업로드 처리 로직
		String url = fileUpload(b.getFile());
		
		// Board에 url <-- 업로드 된 경로 set으로 넣고 
		b.setUrl(url);
		
		// 비즈니스 로직 처리 -> service.Boardwrite
		service.insert(b);
		System.out.println("추가 후 : " + b);
		return "redirect:/view?no=" + b.getNo();
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		//List<Board> list = service.selectAll();
		model.addAttribute("list", service.selectAll());
		return "list";
	}
	

	@GetMapping("/view")
	public void view(String no, Model model) {
		// int inNo = Integer.parseInt(no);
		// Board board = service.select(inNo);
		// model.addAttribute("vo", board);
		model.addAttribute("vo", service.select(Integer.parseInt(no)));
	}
	
	@PostMapping("/update")
	public String update(Board b) throws IllegalStateException, IOException {
		
		// b.getFile() --> 존재한다면! 이건 새로운 이미지 파일
		// --> 이미지 파일을 수정하겠다!
		if(!b.getFile().isEmpty()) {
			// b.geturl() --> 존재한다면! 이건 기존 이미지 파일 
			// null이 아닌 경우가 기존 이미지가 존재!
			// -> 이 기존 이미지는 삭제!
			if(b.getUrl()!=null) {
				File file = new File(path + b.getUrl());
				file.delete();
			}
			String url = fileUpload(b.getFile());
			b.setUrl(url);
		}
		
		service.update(b);
		
		return "redirect:/view?no="+b.getNo();
	}
	
	@GetMapping("/delete")
	public String delete(String no) {
		
		int parsingNo = Integer.parseInt(no);
		
		// 업로드한 파일도 삭제! 필요!!!!
		// 필요한 정보 가져오기
		Board b = service.select(parsingNo);
		if(b.getUrl()!=null) {
			// url이 null이 아닌 경우 정보 삭제!
			File file = new File(path+b.getUrl());
			file.delete();
		}
		
		// 삭제
		service.delete(parsingNo);
		return "redirect:/list";
	}
}


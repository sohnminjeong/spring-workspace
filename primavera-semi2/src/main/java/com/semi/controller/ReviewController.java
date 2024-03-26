package com.semi.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.semi.model.vo.Review;
import com.semi.model.vo.Paging;
import com.semi.service.ReviewService;

@Controller
public class ReviewController {

	private String path = "D:\\upload\\review\\";

	@Autowired
	private ReviewService service;

	@GetMapping("/review/write")
	public void write() {
	}

	@PostMapping("/review/write")
	public String write(Review b) throws IllegalStateException, IOException {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		b.setId(userDetails.getUsername());

		System.out.println("review  : " + b);
		if (b == null || b.getFile() == null) {
			System.out.println("Error: Review 객체 또는 파일이 null입니다.");
			return "redirect:/error";
		}

		if (!b.getFile().isEmpty()) {
			String url = fileUploadreview(b.getFile());
			b.setUrl(url);
		}
		service.insert(b);
		return "redirect:/review/view?no=" + b.getNo();
	}

	@GetMapping("/review/list")
	public String list(Model model, 
	        @RequestParam(value = "page", defaultValue = "1") int page,
	        @RequestParam(value = "sort", defaultValue = "dateDesc") String sort,
	        @RequestParam(value = "searchType", required = false) String searchType,
	        @RequestParam(value = "searchKeyword", required = false) String searchKeyword) throws UnsupportedEncodingException {
		
	    int total = service.total(searchType, searchKeyword);
	    Paging paging = new Paging(page, total);
	    paging.setSort(sort);

	    int totalPages = (int) Math.ceil((double) total / paging.getLimit());

	    if (page < 1 || page > totalPages) {
	        page = 1;
	        paging = new Paging(page, total);
	    }

	    List<Review> reviewList = service.selectPage(paging, searchType, searchKeyword);
	    model.addAttribute("list", reviewList);
	    model.addAttribute("paging", paging);
	    model.addAttribute("totalPages", totalPages);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isLoggedIn = authentication != null && authentication.isAuthenticated()
				&& !(authentication instanceof AnonymousAuthenticationToken);
		model.addAttribute("isLoggedIn", isLoggedIn);
		model.addAttribute("searchType", searchType);		
		model.addAttribute("searchKeyword", searchKeyword);

		return "review/list";
	} 

	@GetMapping("/review/view")
	public String view(String no, Model model) {	
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String currentLoggedInUserId = "";
		if (principal instanceof UserDetails) {
			currentLoggedInUserId = ((UserDetails) principal).getUsername();
		} else {
			currentLoggedInUserId = principal.toString();
		}
		model.addAttribute("currentUserId", currentLoggedInUserId);
		model.addAttribute("vo", service.select(Integer.parseInt(no)));
		return "review/view";
	}

	@PostMapping("/updatereview")
	public String update(Review review, @RequestParam("file") MultipartFile file,
	                     RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {
	    
	    if (!file.isEmpty()) {
	        String newUrl = fileUploadreview(file);
	        review.setUrl(newUrl);
	    } else {
	        File oldFile = new File(path + review.getUrl());
	        if (oldFile.exists()) {
	            oldFile.delete();
	        }
	        review.setUrl(null);
	    }

	    service.updatereview(review);
	    return "redirect:/review/view?no=" + review.getNo();
	}

	@PostMapping("/uploadreview")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 파라미터명 : " + file.getName());

		fileUploadreview(file);

		return "redirect:/";
	}

	@GetMapping("/deletereview")
	public String delete(String no) {
		int parsingNo = Integer.parseInt(no);
		Review b = service.select(parsingNo);
		if (b.getUrl() != null) {
			File file = new File(path + b.getUrl());
			file.delete();
		}
		service.deletereview(parsingNo);
		return "redirect:/review/list";
	}

	@PostMapping("/multiUploadreview")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		for (MultipartFile file : files) {
			fileUploadreview(file);
		}
		return "redirect:/";
	}

	@GetMapping("/error")
	public String errorPage() {
		return "/error";
	}

	public String fileUploadreview(MultipartFile file) throws IllegalStateException, IOException {
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString() + "_" + file.getOriginalFilename();

		File copyFile = new File(path + filename);
		file.transferTo(copyFile);

		return filename;
	}
}
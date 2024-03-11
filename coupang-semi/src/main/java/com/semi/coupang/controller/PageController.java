package com.semi.coupang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.coupang.model.vo.Pick;
import com.semi.coupang.model.vo.Product;
import com.semi.coupang.service.PickService;
import com.semi.coupang.service.ProductService;

// 페이지 이동 처리만 기능
@Controller
public class PageController {
	

	@Autowired
	private ProductService prodService;
	
	@Autowired
	private PickService pickService;
	
	@GetMapping("detail")
	public String detail(String code, Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) principal;
		
		Product product = prodService.select(Integer.parseInt(code));
		model.addAttribute("product", product);
		
		Pick vo = new Pick();
		vo.setProdCode(Integer.parseInt(code)); // 상품코드(prodCode)
		vo.setId(user.getUsername()); // 아이디(id)
		
		Pick pick = pickService.select(vo);
		model.addAttribute("pick", pick); // 데이터 바인딩
		
		return "detail";
	}
	@ResponseBody
	@PostMapping("/addPick")
	public boolean addPick(String code) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) principal;
		
		Pick vo = new Pick();
		vo.setProdCode(Integer.parseInt(code));
		vo.setId(user.getUsername());
		
		// 찜 추가
		pickService.insert(vo);
		
		return true;
	}
	
	@ResponseBody
	@PostMapping("/delPick")
	public boolean delPick(String code) {
		pickService.delete(Integer.parseInt(code));
		return true;
	}
	
}

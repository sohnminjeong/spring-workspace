package com.kh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.model.vo.Member;
import com.kh.service.MemberService;

@Controller
public class MemberController {
	
	// autowired로 service 연결 
	@Autowired
	private MemberService service;
	
	@GetMapping("allMember")
	public String allMember(Model model) {
		List<Member> list = service.showAllMember();
		//바인딩
		model.addAttribute("list", list);
		return "allMember";
	}
		
	// register -> register.jsp (회원 정보 : 아이디, 비밀번호, 이름)
	// 위에 페이지 이동은 @getMapping
	@GetMapping("register")
	public String register() {
		//System.out.println("register 요청!");
		return "register";
	}
	
	// @PostMapping : signUp (Member 매개변수로 받으면 됨-Model model, Member member 식으로 매개변수 영역에 추가되면 됨)
	// signUP : .jsp에서 form action값
	@PostMapping("signUp")
	public String signUp(Member vo) {
		//잘 되는지 확인 : System.out.println(vo);
		service.registerMember(vo);
		return "redirect:/";
	//-> 가입하고 redirect : 첫 페이지로 이동 return "redirect:/"
	}
	
	// login -> login.jsp (아이디, 비밀번호)
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	// @PostMapping : signIn으로 처리 추가 (Member 매개변수 받기)
	@PostMapping("signIn")
	public String signIn(HttpServletRequest request, Member vo) {
	// -> 로직 중 session에 멤버 정보 담아야 함(session에 바인딩)
	//   =>: 멤버 정보 저장을 위해 매개변수로 HttpServletRequest 필요
		//String id=request.getParameter("id");
		//String password=request.getParameter("password");
		HttpSession session = request.getSession();
		//Member vo = new Member(id, password);
		session.setAttribute("login",service.loginMember(vo));
		return "login_result";
	// -> login_result.jsp (회원 정보 보일 수 있도록)
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		// logout -> session 죽이기! : 매개변수로 HttpServletRequest 필요
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("login");
		if(member!=null) {
			session.invalidate();
		}
		System.out.println("로그아웃");
		return "redirect:/"; 
		// -> redirect : 첫 페이지로 이동!
	}
	
	@GetMapping("update")
	// update -> update.jsp (회원 정보가 보여진 상태 : 아이디, 비밀번호, 이름)
	public String update() {
		return "update";
	}
	
	@PostMapping("updateMember")
	public String updateMember(Member vo, HttpServletRequest request) {
	// @PostMapping : updateMember로 받기 (Member 매개변수로 받기)
		HttpSession session = request.getSession();
		if(service.updateMember(vo)==1) {
			session.setAttribute("vo", vo);
		}
		return "redirect:/";
	// -> redirect : 첫 페이지로 이동!
	}
	
	// search -> search.jsp (키워드 정보 하나만!)
	@GetMapping("search")
	public String search() {
		return "search";
	}
	
	// @GetMapping : find (String keyword 매개변수로)
	@GetMapping("find")
	public String find(Model model,String select, String keyword){
		// Model은 spring에서 기본적으로 제공하는 것
		List<Member> list = service.findMember(keyword, select);
		model.addAttribute("list", list);
		return "find_result";
		// -> find_result.jsp로 이동(검색된 정보 보일 수 있도록 여러명 가능)
	}
	
}

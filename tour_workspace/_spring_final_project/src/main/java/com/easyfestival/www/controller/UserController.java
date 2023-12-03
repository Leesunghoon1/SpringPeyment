package com.easyfestival.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.easyfestival.www.security.UserVO;
import com.easyfestival.www.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/user/**")
@RequiredArgsConstructor // 자동 생성자 주입
public class UserController {
	
	private final UserService usv;
	private final BCryptPasswordEncoder bcEncoder; // password 암호화 객체
	
	@GetMapping("join")
	public String joinUser() {
		return "/user/join";
	}
	
	@PostMapping("join")
	public String joinUser(UserVO uvo, RedirectAttributes re) {
		log.info(">>>>>>>>>>>>> join 도착 >>>>>>>>>>>>>>");
		
//		// id가 존재하면 메시지 3 리턴(jsp에서 alert띄우는 용도)
//		if(duplicateID != null) {
//			re.addFlashAttribute("message", 3);
//			return "redirect:/user/join";
//		}
//		// 패스워드 미입력시 메시지 2 리턴(jsp에서 alert띄우는 용도)
//		if(uvo.getPwd() == null || uvo.getPwd().isEmpty()) {
//			re.addFlashAttribute("message", 2);
//			return "redirect:/user/join";
//		}
//		// 필수 입력정보 미입력시
//		if(uvo.getName().isEmpty() || uvo.getAge() <= 0 || uvo.getPhoneNumber().isEmpty()
//				|| uvo.getEmail().isEmpty()) {
//			re.addFlashAttribute("message", 4);
//			return "redirect:/user/join";
//		}
		
		// 아이디, 패스워드 이상 없으면 회원가입 진행
		uvo.setPwd(bcEncoder.encode(uvo.getPwd()));
		int isOk = usv.userJoin(uvo);
		isOk *= usv.authUser(uvo.getId());
		
		log.info("user join >>>>> " + (isOk > 0 ? "Success" : "Fail"));
		re.addFlashAttribute("message", 1); // 성공하면 메시지로 1 리턴
		
		return "redirect:/";
	}
	
	@GetMapping(value="checkId/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> checkId(@PathVariable("id") String id, RedirectAttributes re){
		if(id == null || id.isEmpty()) {
			return new ResponseEntity<String>("blankId", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		UserVO duplicateID = usv.getId(id);
//		log.info(">>>>>>>>>>>>>>>>>>>>>>> checkId >>>>>>>>>>>>>>>>" + duplicateID.getId());
		return duplicateID != null ? new ResponseEntity<String>("2", HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<String>("1", HttpStatus.OK);
	}
	
	@GetMapping("login")
	public String loginUser(Model model) {
		
		
		
		
		
		
		
		
		return "/user/login";
	}
	
	@PostMapping("login")
	public String postLogin(HttpServletRequest request, RedirectAttributes re) {
		// 로그인 실패시 다시 로그인 페이지로 돌아와 오류 메시지 전송
		// 다시 로그인 유도
		re.addAttribute("id", request.getAttribute("id"));
		re.addAttribute("errMsg", request.getAttribute("errMsg"));
		return "redirect:/user/login";
	}
	
	@PostMapping("logout")
	public void logOut(HttpServletRequest request, HttpServletResponse response) {
		logout(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	// 시큐리티를 통한 로그아웃 메서드
	private void logout(HttpServletRequest request, HttpServletResponse response) {
	      //사용자 정보를 찾는 인자 ?
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      new SecurityContextLogoutHandler().logout(request, response, auth);
	   }
	
	
}


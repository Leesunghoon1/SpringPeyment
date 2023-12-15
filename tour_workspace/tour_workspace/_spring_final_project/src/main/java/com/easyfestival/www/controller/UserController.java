package com.easyfestival.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.easyfestival.www.handler.PagingHandler;
import com.easyfestival.www.security.AuthVO;
import com.easyfestival.www.security.UserVO;
import com.easyfestival.www.service.MemberShipService;
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
	
	@Autowired
	private MemberShipService memberShipService;
	
	@GetMapping("index")
	public String index() {
		return "redirect:index";
	}
	@GetMapping("join")
	public String joinUser() {
		return "/user/join";
	}
	
	@PostMapping("join")
	public String joinUser(UserVO uvo, RedirectAttributes re) {
		log.info(">>>>>>>>>>>>> join 도착 >>>>>>>>>>>>>>");
		
		uvo.setPwd(bcEncoder.encode(uvo.getPwd()));
		int isOk = usv.userJoin(uvo);
		AuthVO avo = new AuthVO();
		avo.setId(uvo.getId());
		avo.setAuth("ROLE_USER");
		isOk *= usv.authUser(avo);
		
		memberShipService.insertId(uvo.getId());
		
		log.info("user join >>>>> " + (isOk > 0 ? "Success" : "Fail"));
		if(isOk > 0) {
			re.addFlashAttribute("message", 1); // 성공하면 메시지로 1 리턴
			re.addFlashAttribute("joinID", uvo.getId()); // 회원가입 완료 아이디 전달
		}
		return "redirect:/user/index";
	}
	
	@GetMapping(value="checkId/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> checkId(@PathVariable("id") String id, RedirectAttributes re){
		if(id == null || id.isEmpty()) {
			return new ResponseEntity<String>("blankId", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		UserVO duplicateID = usv.getId(id);
		return duplicateID != null ? new ResponseEntity<String>("2", HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<String>("1", HttpStatus.OK);
	}
	
	@GetMapping("login")
	public String getLogin(Model model) {
		return "/user/login";
	}
	
	@PostMapping("login")
	public String postLogin(HttpServletRequest request, RedirectAttributes re) {
		// 로그인 실패시 다시 로그인 페이지로 돌아와 오류 메시지 전송
		// 다시 로그인 유도
		re.addAttribute("id", request.getAttribute("id"));
		re.addAttribute("errMsg", request.getAttribute("errMsg"));
		re.addFlashAttribute("loginFail", 2);
		return "redirect:/user/login";
	}
	
	@PostMapping("logout")
	public void logOut(HttpServletRequest request, HttpServletResponse response) {
		logout(request, response);
	}
	
	// 회원 리스트
	@GetMapping("list")
	public void getUserList(Model model, @RequestParam("pageNo")int pageNo) {
//		List<UserVO> uvoList = usv.getList();
		int totalCount = usv.getUserCount(); // 총 유저수 가하기
		log.info("유저수 >>>>>> {}", totalCount);
		PagingHandler ph = new PagingHandler(pageNo, 10, 5, totalCount); // 페이지네이션 설정 핸들
		log.info("ph >>>>>> {}", ph.toString());
		
		List<UserVO> uvoList = usv.getList(ph);
		model.addAttribute("ph", ph);
		model.addAttribute("uvoList", uvoList);
	}
	
	
	
	// 회원정보 수정
	@GetMapping("modify")
	public void getUserModify() {}
	
	@PostMapping("modify")
	public String postUserModify(UserVO uvo, HttpSession session) {
		log.info("uvo >>>>> " + uvo);
		if(!uvo.getPwd().isEmpty()) {
			uvo.setPwd(bcEncoder.encode(uvo.getPwd()));
		}
		int isOk = usv.modifyUser(uvo);
		if(isOk > 0) {
			uvo = usv.getId(uvo.getId());
			session.setAttribute("uvo", uvo);
		}
		return "redirect:/user/index";
	}
	
	// 회원탈퇴
	@GetMapping("delete/{id}")
	public String getDeleteUser(@PathVariable("id")String id,HttpServletRequest request, HttpServletResponse response) {
		int isOk = usv.deleteUser(id);
		if(isOk > 0) {
			log.info(">>>>>>>>>> 회원탈퇴 <<<<<<<<<");
		}
		logout(request, response);
		return "redirect:/user/index";
	}
	
	
	
	// 시큐리티를 통한 로그아웃 메서드
	private void logout(HttpServletRequest request, HttpServletResponse response) {
	      //사용자 정보를 찾는 인자 ?
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      new SecurityContextLogoutHandler().logout(request, response, auth);
	   }
	
	
}


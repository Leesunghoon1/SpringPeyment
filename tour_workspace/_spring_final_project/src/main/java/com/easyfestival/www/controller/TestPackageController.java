package com.easyfestival.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.easyfestival.www.domain.TestPackageVO;
import com.easyfestival.www.service.TestPackageService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/package/*")
@Slf4j
public class TestPackageController {

	private int isOK;

	@Inject
	private TestPackageService psv;

	@GetMapping("register")
	public void register() {
		log.info("register page 이동");
	}

	@PostMapping("/register")
	public String register(TestPackageVO pgvo) {
		log.info("들어옴 ?");
		isOK = psv.register(pgvo);
		log.info("register >> " + (isOK > 0 ? "성공" : "실패"));
		return "redirect:/package/list";

	}
	
	@GetMapping("/list")
	public void getList(Model m) {
		List<TestPackageVO> list = psv.getList();
		m.addAttribute("list", list);
	}
	
	@GetMapping("/detail")
    public String getDetail(Model m, @RequestParam("pkNo") int pkNo) {
        TestPackageVO pkvo = psv.getDetail(pkNo);
        m.addAttribute("pkvo", pkvo);
        
        return "/package/detail";
    }
}

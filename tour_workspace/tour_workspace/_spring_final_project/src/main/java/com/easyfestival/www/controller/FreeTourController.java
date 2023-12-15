package com.easyfestival.www.controller;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/freetour")
public class FreeTourController {

	
	
	@GetMapping("air")
	public String air() {
		
		return "/freetour/air";
	}
}

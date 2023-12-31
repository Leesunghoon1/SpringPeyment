package com.easyfestival.www.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.easyfestival.www.domain.AirplaneVO;
import com.easyfestival.www.domain.FestivalVO;
import com.easyfestival.www.domain.HotelVO;
import com.easyfestival.www.domain.PackageVO;
import com.easyfestival.www.domain.PlaceVO;
import com.easyfestival.www.domain.ProductBoardVO;
import com.easyfestival.www.domain.ProductDTO;
import com.easyfestival.www.domain.ProductFileVO;
import com.easyfestival.www.domain.ProductListDTO;
import com.easyfestival.www.handler.FileHandler;
import com.easyfestival.www.repository.PackageDAO;
import com.easyfestival.www.service.ProductService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

	@Inject
	private ProductService psv;
	
	@Inject
	private FileHandler fh;
	
	
	
	@GetMapping("register")
	public String register() {
		return "/product/register";
	}
	
	@PostMapping("register")
	public String productRegister(ProductBoardVO pbvo, @RequestParam(name="files",required = false)MultipartFile[] files) {
		log.info(pbvo+"pbvo <<<<<!!");
		
		List<ProductFileVO> pflist = null;
		if(files[0].getSize() > 0) {
			pflist = fh.uploadFile(files);
		}
		
		
		int isOk = psv.register(new ProductDTO(pbvo, pflist));

		return "index";
	}
	
	
	@GetMapping("list")
	public String list(Model m,@RequestParam("pkContinent") String pkContinent) {

		//List<ProductListDTO> pdto = psv.productList(pkContinent);
		
		
		List<ProductListDTO> pldto = psv.getdto(pkContinent);

		if(pldto.size() > 0) {
			m.addAttribute("pldto", pldto);
		}
		
		System.out.println("pdto >> " + pldto);
		
		return "/product/list";
	}
	
	@GetMapping("detail")
	public String detail(Model m , @RequestParam("pkNo") long pkNo) {
		List<ProductListDTO> pldto = psv.getdtoDetail(pkNo);
		log.info(pldto+"pldto");
		
		m.addAttribute("pldto", pldto.get(0));
		return "/product/detail";
	}

	@GetMapping("reservation")
	public String reservation(@RequestParam("pkNo")long pkNo , Model m) {
		List<ProductListDTO> pldto = psv.getdtoDetail(pkNo);
		log.info(pldto+"pldto");
		
		m.addAttribute("pldto", pldto.get(0));
		
		
		return "/product/reservation";
	}
	
	@GetMapping("modify")
	public String modify(@RequestParam("pkNo") long pkNo , Model m) {
		
		List<ProductListDTO> pldto = psv.getdtoDetail(pkNo);
		log.info(pldto+"pldto");
		
		m.addAttribute("pldto", pldto.get(0));
		
		
		return "/product/modify";
	}
	
	@PostMapping("modify")
	public String postModify(ProductBoardVO pbvo, @RequestParam(name="files",required = false)MultipartFile[] files, RedirectAttributes a) {
		
		String continent = pbvo.getPkContinent();
		
		log.info(pbvo + "pbvo<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		List<ProductFileVO> pflist = null;
		if(files[0].getSize() > 0) {
			pflist = fh.uploadFile(files);
		}
		pbvo.setPkPrice(pbvo.getApPrice()+pbvo.getFvPrice()+pbvo.getHtPrice());
		pbvo.setPkContinent(pbvo.getPlContinent());
		
		int isOk = psv.modify(new ProductDTO(pbvo, pflist));
		
		
		return "index";
	}
	@GetMapping("remove")
	public String remove(@RequestParam("pkNo") long pkNo) {
		
		int isOk = psv.removeProduct(pkNo);
		
		return "index";
	}
}

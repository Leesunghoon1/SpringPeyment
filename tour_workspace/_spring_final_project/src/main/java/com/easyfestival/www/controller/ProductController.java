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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		log.info(pbvo.getApArrival()+"pbvo");
		List<ProductFileVO> pflist = null;
		if(files[0].getSize() > 0) {
			pflist = fh.uploadFile(files);
		}
		int isOk = psv.register(new ProductDTO(pbvo, pflist));

		return "index";
	}
	
	
	@GetMapping("list")
	public String list(Model m) {
		
		
		// 필요한거 패키지리스트, 파일리스트
		List<PackageVO> packList = psv.getList();		
		List<ProductFileVO> pfList = psv.getFileList();
		List<PlaceVO> plvo = psv.getPlace();
		//ProductFileVO pfvo = psv.getFile();
		
		//log.info(pfList +"pfList << ");
		log.info(packList + "packList <<");
		m.addAttribute("plvo", plvo);
		m.addAttribute("pdto", new ProductListDTO(packList,pfList));

		
		return "/product/list";
	}
	
	@GetMapping(value="image", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductFileVO>> getImage(){
		
		
		return new ResponseEntity<List<ProductFileVO>>(psv.getImgList(),HttpStatus.OK);
	}
	
	@GetMapping("detail")
	public String getDetail(Model m ,@RequestParam("pkNo") long pkNo) {
		
		ProductDTO pdto = psv.getDetail(pkNo);
		
		PlaceVO plvo = psv.getPlaceDetail(pkNo);
		HotelVO hvo = psv.getHotelDetail(pkNo);
		AirplaneVO avo = psv.getAirplaneDetail(pkNo);
		FestivalVO fvo = psv.getFestivalVoDetail(pkNo);
		PackageVO packvo = psv.getPackageDetail(pkNo);
		
		m.addAttribute("pbvo", pdto.getPbvo());
		m.addAttribute("pfvo", pdto.getPflist());
		m.addAttribute("plvo", plvo);
		m.addAttribute("hvo", hvo);
		m.addAttribute("avo", avo);
		m.addAttribute("fvo", fvo);
		m.addAttribute("packvo", packvo);
		
		return "/product/detail";
	}
	@PostMapping("detail")
	public String postDetail() {
		
		return "/product/reservation";
	}
	
	@GetMapping("reservation")
	public String reservation() {
		return "/product/reservation";
	}
}

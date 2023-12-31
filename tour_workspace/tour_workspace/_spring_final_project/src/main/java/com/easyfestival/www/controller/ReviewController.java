package com.easyfestival.www.controller;


import java.io.IOException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.UUID;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.easyfestival.www.domain.ReviewLikeHistoryVO;
import com.easyfestival.www.domain.pagingVO;
import com.easyfestival.www.domain.reviewVO;
import com.easyfestival.www.handler.PagingHandler;
import com.easyfestival.www.handler.ReviewPagingHandler;
import com.easyfestival.www.security.UserVO;
import com.easyfestival.www.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/review")
public class ReviewController 
{
	private final String UPLOAD_DIR="C:\\upload_file\\review";
	@Inject
	private ReviewService rsv;
	
	private int isOk;
	
	@GetMapping("/reviewRegister")
	public String reviewRegister() {
		log.info("asdas21412421");
		return "/review/ReviewRegister";
	}	

	@PostMapping("/reviewRegister")
	public String reviewRegister(reviewVO rvo) {
		log.info("rvo는???" + rvo);
		isOk = rsv.reviewRegister(rvo);
		//이벤트 파일 db에 등록
		
		return "index";
	}

	@PostMapping("/image")
    public ResponseEntity<String> handleImageUpload(@RequestParam("file") MultipartFile file) {
        try {
            // 업로드된 파일의 원래 이름
            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            String baseName = FilenameUtils.getBaseName(originalFilename);
            String extension = FilenameUtils.getExtension(originalFilename);
            
            // 파일 저장 경로 설정
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String uniqueFileName = UUID.randomUUID().toString() + "_" + baseName+"."+extension;
            String urlEncodedFileName = URLEncoder.encode(uniqueFileName, StandardCharsets.UTF_8.toString());
            // 파일 저장
            Path filePath = uploadPath.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), filePath);

            // 이미지의 상대 경로를 반환 (예: /upload/filename.jpg)
            String relativePath = "/Rupload/" + urlEncodedFileName;

            return ResponseEntity.ok(relativePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading image");
        }
    }
	
	@GetMapping("/reviewList")
	public String reviewList(Model m,pagingVO pgvo)
	{
		
		m.addAttribute("list", rsv.list(pgvo));
		int totalCount=rsv.getTotalCount(pgvo);
		ReviewPagingHandler ph=new ReviewPagingHandler(pgvo, totalCount);
		m.addAttribute("ph", ph);
		
		return "/review/ReviewList";
	}
	@GetMapping("/reviewDetail")
	public String reviewDetail(Model m,@RequestParam("rvNo")int rvNo,HttpServletRequest request, RedirectAttributes re)
	{
		HttpSession ses= request.getSession();
		UserVO uvo=(UserVO)ses.getAttribute("uvo");
		log.info("uvo는???"+uvo);
		reviewVO rvo=rsv.detail(rvNo);
		if(uvo.getId().equals(rvo.getId()))
		{
			isOk=rsv.readCountUp(rvNo);
			m.addAttribute("rvo", rvo);
			return "/review/ReviewDetail";
		}
		re.addFlashAttribute("msg","secret");
		return "redirect:/review/reviewList";
		
	}
	@GetMapping("/remove")
	public String reviewRemove(@RequestParam("rvNo")int rvNo)
	{
		isOk=rsv.remove(rvNo);
		return "redirect:/review/reviewList";
	}
	@GetMapping("/modify")
	public String reviewModify(Model m,@RequestParam("rvNo")int rvNo)
	{
		reviewVO rvo=rsv.detail(rvNo);
		m.addAttribute("rvo", rvo);
		return "/review/ReviewModify";
	}
	@PostMapping("/modify")
	public String reviewModify(reviewVO rvo)
	{
		isOk=rsv.modify(rvo);
		return "redirect:/review/reviewList";
	}
	@PostMapping(value = "/{rvNo}")
	public ResponseEntity<String> reviewLike(@RequestBody ReviewLikeHistoryVO rlh)
	{
		log.info("reviewLike 들어옴");
		log.info("rlh는???"+rlh);
		ReviewLikeHistoryVO rlhvo=rsv.LikeDistinction(rlh);
		log.info("rlhvo는????"+rlhvo);
		if(rlhvo!=null) {	//이미 좋아요를 누른 기록이 있다면
			isOk=rsv.deleteLike(rlhvo);
			return  isOk > 0 ?new ResponseEntity<String>("2",HttpStatus.OK):new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		isOk=rsv.insertLike(rlh);
		return  isOk > 0 ?new ResponseEntity<String>("1",HttpStatus.OK):new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping(value = "/{rvNo}")
	public ResponseEntity<String> getLikeHistory(@RequestBody ReviewLikeHistoryVO rlh)
	{
		ReviewLikeHistoryVO rlhvo=rsv.LikeDistinction(rlh);
		if(rlhvo!=null)
			return new ResponseEntity<String>("1",HttpStatus.OK);
		
		
		return new ResponseEntity<String>("2",HttpStatus.OK);
	}
	@GetMapping("/BestReview")
	public String BestReview(Model m,pagingVO pgvo)
	{
		m.addAttribute("list", rsv.bestList(pgvo));
		int besttotalCount=rsv.getbestTotalCount(pgvo);
		ReviewPagingHandler ph=new ReviewPagingHandler(pgvo, besttotalCount);
		m.addAttribute("ph", ph);
		return "/review/ReviewList";
	}
	

}

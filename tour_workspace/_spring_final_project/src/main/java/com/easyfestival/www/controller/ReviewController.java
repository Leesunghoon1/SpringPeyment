package com.easyfestival.www.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.easyfestival.www.domain.reviewVO;
import com.easyfestival.www.service.ReviewService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/review")
public class ReviewController 
{
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

	@PostMapping(value = "/uploadSummernoteImageFile", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
		log.info("썸머노트 제발");
		JsonObject jsonObject = new JsonObject();

		String fileRoot = "D:\\image\\review\\"; // 저장될 외부 파일 경로
		String originalFileName = multipartFile.getOriginalFilename(); // 오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자

		String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명

		File targetFile = new File(fileRoot + savedFileName);
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile); // 파일 저장
			jsonObject.addProperty("url", "D:\\image\\review\\"+savedFileName);	
			jsonObject.addProperty("responseCode", "success");

		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile); // 저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		
		log.info("제이슨오브젝트:"+jsonObject);
		String jsonString = gson.toJson(jsonObject);
		
		return jsonString;
	}
	@GetMapping("/reviewList")
	public String reviewList(Model m)
	{
		List<reviewVO>rList=rsv.list();
		log.info("리뷰리스트:"+rList);
		m.addAttribute("list", rList);
		return "/review/ReviewList";
	}
	@GetMapping("/reviewDetail")
	public String reviewDetail(Model m,@RequestParam("rvNo")int rvNo)
	{
		isOk=rsv.readCountUp(rvNo);
		reviewVO rvo=rsv.detail(rvNo);
		m.addAttribute("rvo", rvo);
		return "/review/ReviewDetail";
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
//	@GetMapping("/like")
//	public String reviewLike(@RequestParam("rvNo")int rvNo)
//	{
//		
//	}

}

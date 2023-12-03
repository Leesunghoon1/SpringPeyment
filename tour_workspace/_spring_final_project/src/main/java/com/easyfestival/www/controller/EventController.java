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


import com.easyfestival.www.domain.eventVO;
import com.easyfestival.www.service.EventService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/event/*")
public class EventController {
	private int isOk;

	@Inject
	private EventService esv;

	@GetMapping("/eventRegister")
	public String eventRegister() {
		log.info("asdas21412421");
		return "/event/EventRegister";
	}

	@PostMapping("/eventRegister")
	public String eventRegister(eventVO evo) {
		log.info("evo는???" + evo);
		isOk = esv.eventRegister(evo);
		//이벤트 파일 db에 등록
		
		return "index";
	}

	@PostMapping(value = "/uploadSummernoteImageFile", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
		log.info("썸머노트 제발");
		JsonObject jsonObject = new JsonObject();

		String fileRoot = "D:\\image\\event\\"; // 저장될 외부 파일 경로
		String originalFileName = multipartFile.getOriginalFilename(); // 오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자

		String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명

		File targetFile = new File(fileRoot + savedFileName);
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile); // 파일 저장
			jsonObject.addProperty("url", "D:\\image\\event\\"+savedFileName);	
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
	
	@GetMapping("/eventList")
	public String eventList(Model m)
	{
		List<eventVO>eList=esv.list();
		log.info("이벤트리스트:"+eList);
		m.addAttribute("list", eList);
		return "/event/EventList";
	}
	
	@GetMapping("/eventDetail")
	public String eventDetail(Model m,@RequestParam("evNo")int evNo)
	{
		eventVO evo=esv.detail(evNo);
		m.addAttribute("evo", evo);
		return "/event/EventDetail";
	}
	
	@GetMapping("/eventRemove")
	public String eventRemove(@RequestParam("evNo")int evNo)
	{
		isOk=esv.eventRemove(evNo);
		return "redirect:/event/eventList";
	}
	@GetMapping("/eventModify")
	public String eventModify(Model m,@RequestParam("evNo")int evNo)
	{
		eventVO evo=esv.detail(evNo);
		m.addAttribute("evo", evo);
		return "/event/EventModify";
	}
	@PostMapping("/eventModify")
	public String eventModify(eventVO evo)
	{
		isOk=esv.eventModify(evo);
		return "redirect:/event/eventList";
	}
	
	

}

package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;

import com.javaex.vo.GuestVo;




@Controller 
public class GuestController {

	//테스트
	@RequestMapping(value="/test", method={RequestMethod.GET, RequestMethod.POST} )   
	public String test() {
		System.out.println("test");
		return "test";
	}
	
	//생성자
	//http://localhost:8088/phonebook3/phone/write?name=황일영&hp=999-9999-9999&company=888-8888-8888
	// 등록
		@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
		public String write (@RequestParam("name") String name, @RequestParam("hp") String hp, @RequestParam ("company") String company) {
		System.out.println("write");
			
		//묶어주기
		GuestVo guestVo =  new GuestVo(name, hp, company);
		System.out.println(guestVo.toString());
		
		GuestDao guestDao = new GuestDao();
		guestDao.personInsert(guestVo);
		
		return "redirect:guest/list";
		}
		
	//List
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("list");

	//Dao를 통해 리스트를 받아온다 
		GuestDao guestDao = new GuestDao();
		List<GuestVo> personList = guestDao.getList();
		System.out.println("personList.toString");

	//model--> data 보내는 방법 -> 모델(박스)에 담아 놓으면 된다 
		model.addAttribute("gList", personList);	
		System.out.println(personList.toString());
		return "list";
	}
	
	//writeForm
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeform() {

		System.out.println("writeForm");
	
		return "redirect:/guest/list";

		}
	
	//addlist
	@RequestMapping(value="/addlist", method={RequestMethod.GET, RequestMethod.POST} )   
	public String addList(Model model) {

		//Dao를 통해 리스트를 받아온다 
		GuestDao guestDao = new GuestDao();
		
	

		//model--> data 보내는 방법 -> 모델(박스)에 담아 놓으면 된다 
		model.addAttribute("gList", guestDao.getList());
		
		return "redirect:/guest/list";
	}
	
	//deleteForm
	@RequestMapping(value = "/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteform() {

		System.out.println("deleteForm");
	
		return "deleteForm";

		}

	
	//delete //질문:방명록에는 비번 입력해야 삭제되기 때문에 {}안에 "password"가 맞는지?
	@RequestMapping(value = "/delete/{password}", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete2(@PathVariable("password") int password) {
		System.out.println("delete");
		System.out.println("password");
		
		GuestDao guestDao = new GuestDao();
		guestDao.personDelete(password);
		
		return "redirect:/phone/list";
	}
	
	
	
	//메소드 게터 세터
	
	//메소드 일반 
	
	//method 마다 기능 1개씩 --> 기능마다 url부여
	
	//리스트 처리
	
	//등록폼 처리
	
	//삭제
}



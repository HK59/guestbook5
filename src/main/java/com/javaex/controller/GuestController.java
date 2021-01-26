package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value = "/guest")
public class GuestController {

	@Autowired
	private GuestDao guestDao;
	
	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("list");

		// dao를 통해 리스트 를 가져온다. 
		//여기도 보세요 어떻게 다른지
		List<GuestVo> guestlist = guestDao.getList();
		//List<GuestVo> guestlist = GuestDao.getList();

		// model -->data 를 보내는 방법 -->담아 놓으면 된다
		model.addAttribute("gList", guestlist);

		return "addList";
	}

	// 방명록 등록
	@RequestMapping(value = "/addlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(@ModelAttribute GuestVo guestVo) {
		System.out.println("addList");
		System.out.println(guestVo.toString());
		guestDao.GuestInsert(guestVo);

		return "redirect:/guest/list";

	}

	
	 //방명록 삭제 폼 deleteForm
	 
	  @RequestMapping(value = "/deleteForm", method = { RequestMethod.GET,
	  RequestMethod.POST }) public String deleteForm() {
	  
	 System.out.println("deleteF");
	  
	 return "deleteForm";
	 
	  }
	  

	  
	  
	 // 삭제 --> delete --> @PathVariable

		@RequestMapping(value = "/delete/{password}", method = {RequestMethod.GET, RequestMethod.POST}) 
		public String delete2(@PathVariable("password") GuestVo password) { System.out.println("delete"); System.out.println("password");

		GuestDao guestDao = new GuestDao();guestDao.guestDelete(password);

		return"redirect:/guest/list";
		
		}


	// 메소드 게터 세터

	// 메소드 일반

	// method 마다 기능 1개씩 --> 기능마다 url부여

	// 리스트 처리

	// 등록폼 처리

	// 삭제
}

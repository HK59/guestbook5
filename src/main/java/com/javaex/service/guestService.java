package com.javaex.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class guestService {

	@Autowired
	private GuestDao guestDao;

	SqlSession sqlSession;

	// List
	public String list(Model model) {
		List<GuestVo> guestList = guestDao.getList();
		model.addAttribute("guestList", guestList);

		return "list";
	}

	// addList
	public String addList(@ModelAttribute GuestVo guestVo) {

		guestDao.GuestInsert(guestVo);

		return "redirect:/guest/list";
	}

	// Delete
	public String delete(@PathVariable("password") GuestVo password) {
	GuestDao guestDao = new GuestDao();
	guestDao.guestDelete(password);

	return"redirect:/guest/list";
			
			}
}

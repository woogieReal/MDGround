package com.sist.feb.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

//	▼ 변수 ===============================================================

	final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	
//	▼ 생성자 ==============================================================	
	
	public MainController() {}
	
	
//	▼ 메소드 ===============================================================
	
	@RequestMapping(value = "main/main_view.do", method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	public String viewMain(Model model) throws Exception {
		LOG.debug("viewLogin");
		return "main/main";
	}
	
	
}

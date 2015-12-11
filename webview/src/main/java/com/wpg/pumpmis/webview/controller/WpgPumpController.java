package com.wpg.pumpmis.webview.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpg.pumpmis.webview.DO.User;
import com.wpg.pumpmis.webview.soap.service.WebService;

@Controller  
@RequestMapping("/wpg")  
public class WpgPumpController {

	@Inject
	private WebService  webService;
	
	@RequestMapping("/login")
	@ResponseBody
	public User login(String userName,String passWord){
		return webService.login(userName, passWord);
	}
}

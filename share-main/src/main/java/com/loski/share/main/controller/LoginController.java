package com.loski.share.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.loski.share.main.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/share/main/common/login", method = RequestMethod.POST)
	public String login(@RequestParam("name") String name, @RequestParam("password") String password){

		if(loginService.login(name, password)){
			return "share/main/common/success.html";
		}
		return "share/main/common/fail.html";
	}
}

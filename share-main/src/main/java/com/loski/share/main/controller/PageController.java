package com.loski.share.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("share/main/{url}.html")
	public String page(@PathVariable("url") String url) {
		return "share/main/" + url + ".html";
	}

}
package com.loski.share.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/share/main/resources/{type}/{url}.html")
	public String resourcesPage(@PathVariable("type") String type, @PathVariable("url") String url){
		return "/share/main/resources/" + type + "/" + url + ".html";
	}
	
	@RequestMapping("/share/main/common/{url}.html")
	public String commonPage(@PathVariable("url") String url){
		return "/share/main/common/" + url + ".html";
	}
	
	@RequestMapping("/share/common/ueditor/{url}.html")
	public String ueditorPage(@PathVariable("url") String url){
		return "/share/common/ueditor/" + url + ".html";
	}
}
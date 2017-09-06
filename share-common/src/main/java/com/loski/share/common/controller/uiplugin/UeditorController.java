package com.loski.share.common.controller.uiplugin;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UeditorController {
	
	private static Logger logger = Logger.getLogger(UeditorController.class);

	@RequestMapping("/share/common/ueditor/init")
	public void initUeditor(@RequestParam String action, HttpServletRequest request, HttpServletResponse response){
		try {
	        if ("config".equals(action)) {
	            OutputStream os = response.getOutputStream();    
	            IOUtils.copy(UeditorController.class.getClassLoader().getResourceAsStream("config.json"), os);    
	        }  
		} catch (Exception e) {
			logger.info("ueditor config º”‘ÿ ß∞‹£°");
		}
	}
}

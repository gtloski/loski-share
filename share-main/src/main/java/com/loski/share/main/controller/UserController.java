package com.loski.share.main.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loski.share.main.entity.User;
import com.loski.share.main.service.UserService;
import com.loski.share.main.utils.Result;

//@Controller
@RestController
public class UserController {

	@Autowired
	public UserService userService;
	
	@RequestMapping("/share/main/admin/insert")
//	@ResponseBody
	public Result insertUser(@RequestBody User user){
		user.setId(UUID.randomUUID().toString());
		userService.insertUser(user);
		return Result.ok("添加成功");
	}
}

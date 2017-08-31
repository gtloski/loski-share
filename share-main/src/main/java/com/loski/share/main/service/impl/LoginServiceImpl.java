package com.loski.share.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loski.share.main.entity.User;
import com.loski.share.main.persistence.UserPersistence;
import com.loski.share.main.service.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserPersistence userPersistence;

	public boolean login(String name, String password) {
		
		User user = userPersistence.getUser(name, password);
		if(user != null){
			return true;
		}
		return false;
	}
}

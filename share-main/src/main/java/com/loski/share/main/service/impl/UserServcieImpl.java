package com.loski.share.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loski.share.main.entity.User;
import com.loski.share.main.persistence.UserPersistence;
import com.loski.share.main.service.UserService;

@Service("userService")
@Transactional
public class UserServcieImpl implements UserService {

	@Autowired
	private UserPersistence userPersistence;
	
	@Override
	public void insertUser(User user) {
		
		userPersistence.insert(user);
	}

	
}

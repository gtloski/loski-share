package com.loski.share.main.persistence;

import com.loski.share.main.entity.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserPersistence extends Mapper<User>{

	User getUser(String username, String password);
	
}

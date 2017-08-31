package com.loski.share.main.persistence;

import com.loski.share.main.entity.User;

public interface UserPersistence {

	User getUser(String username, String password);
}

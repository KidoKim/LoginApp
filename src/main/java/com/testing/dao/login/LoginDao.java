package com.testing.dao.login;

import com.testing.models.login.Users;



public interface LoginDao {
	Users findByUserName(String username);
}

package com.agami.service;

import java.util.List;

import com.agami.model.UserTl;

public interface UserService {
	public UserTl insertUser(UserTl userTl);
	public void updateUser(UserTl userTl);
	public UserTl getUser(String emailId,String paswword);
	public List<UserTl> getUsers();
	public UserTl getUser(Integer userId);
	

}

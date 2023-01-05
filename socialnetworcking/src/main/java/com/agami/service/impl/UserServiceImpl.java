package com.agami.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agami.model.UserTl;
import com.agami.repository.UserRepository;
import com.agami.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserTl insertUser(UserTl userTl) {
		userTl.setCreatedOn(new java.sql.Date(new java.util.Date().getTime() ));
		return repository.save(userTl);
	}

	@Override
	public void updateUser(UserTl userTl) {
		UserTl u = repository.findById(userTl.getUserId().intValue());
		if (u != null) {
			u.setEmailId(userTl.getEmailId());
			u.setFullName(userTl.getFullName());
			u.setMobileNumber(userTl.getMobileNumber());
			u.setPassword(userTl.getPassword());
			repository.save(u);
			

		}

	}

	@Override
	public UserTl getUser(String emailId, String paswword) {

		return repository.findByEmailIdAndPassword(emailId, paswword);
	}

	@Override
	public List<UserTl> getUsers() {
		
		return repository.findAll();
	}

	@Override
	public UserTl getUser(Integer userId) {
		UserTl user=null;
		Optional<UserTl> us=repository.findById(userId);
		if(us!=null)
		{
			user=us.get();
		}
		return user;
	}

}

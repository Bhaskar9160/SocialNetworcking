package com.agami.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agami.model.FollowUser;
import com.agami.repository.FollowUserRepository;
import com.agami.service.FollowUserService;
@Service
public class FollowUserServiceImpl implements FollowUserService{
	
	@Autowired
	private FollowUserRepository repository;

	@Override
	public FollowUser insertFollowUser(FollowUser followUser) {
		
		return repository.save(followUser);
	}

	@Override
	public List<FollowUser> getFollowUsers() {
		
		return repository.findAll();
	}

}

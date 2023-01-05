package com.agami.service;

import java.util.List;

import com.agami.model.FollowUser;

public interface FollowUserService {
	public FollowUser insertFollowUser(FollowUser followUser);
	public List<FollowUser> getFollowUsers();

}

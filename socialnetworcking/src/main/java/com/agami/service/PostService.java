package com.agami.service;

import java.util.List;

import com.agami.model.PostTl;


public interface PostService {
	public PostTl insertPost(PostTl postTl);
	public List<PostTl> getPosts();
	public List<PostTl> getSharedPosts(Integer userId);
	
}

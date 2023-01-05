package com.agami.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agami.model.PostTl;
import com.agami.repository.PostRepository;
import com.agami.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;
	@Override
	public PostTl insertPost(PostTl postTl) {
		
		return postRepository.save(postTl);
	}

	@Override
	public List<PostTl> getPosts() {
		
		return postRepository.findAll();
	}

	@Override
	public List<PostTl> getSharedPosts(Integer userId) {
		
		return postRepository.getSharedPosts(userId);
	}

}

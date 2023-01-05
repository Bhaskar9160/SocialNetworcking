package com.agami.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agami.model.LikeTl;
import com.agami.repository.LikeRepository;
import com.agami.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private LikeRepository repository;

	@Override
	public Integer insertLike(LikeTl likeTl) {
		
		return repository.save(likeTl).getLikedId();
	}

	@Override
	public List<LikeTl> getLikes() {
		
		return repository.findAll();
	}

}

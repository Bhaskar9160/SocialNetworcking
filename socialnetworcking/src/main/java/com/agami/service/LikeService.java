package com.agami.service;

import java.util.List;

import com.agami.model.LikeTl;

public interface LikeService {
	public Integer insertLike(LikeTl likeTl);
	public List<LikeTl> getLikes();

}

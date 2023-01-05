package com.agami.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agami.model.CommentTl;
import com.agami.repository.CommentRepository;
import com.agami.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentRepository;
	@Override
	public CommentTl insertComment(CommentTl commentTl) {
		
		return commentRepository.save(commentTl);
	}

	@Override
	public List<CommentTl> getComments() {
		
		return commentRepository.findAll();
	}

}

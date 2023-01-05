package com.agami.service;

import java.util.List;
//

import com.agami.model.CommentTl;

public interface CommentService {
	public CommentTl insertComment(CommentTl commentTl);
	public List<CommentTl> getComments();

}

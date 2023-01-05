package com.agami.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agami.model.ShareTl;
import com.agami.repository.ShareRepository;
import com.agami.service.ShareService;

@Service
public class ShareServiceImpl implements ShareService{

	@Autowired
	private ShareRepository repository;
	@Override
	public ShareTl inserShare(ShareTl shareTl) {
		
		return repository.save(shareTl);
	}

	@Override
	public List<ShareTl> getShares() {
		
		return repository.findAll();
	}

}

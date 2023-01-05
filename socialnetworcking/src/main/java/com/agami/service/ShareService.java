package com.agami.service;

import java.util.List;

import com.agami.model.ShareTl;

public interface ShareService {
	public ShareTl inserShare(ShareTl shareTl);
	public List<ShareTl> getShares();

}

package com.agami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agami.model.ShareTl;

@Repository
public interface ShareRepository  extends JpaRepository<ShareTl, Integer>{

	
}

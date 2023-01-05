package com.agami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agami.model.LikeTl;

@Repository
public interface LikeRepository extends JpaRepository<LikeTl, Integer>{
	

}

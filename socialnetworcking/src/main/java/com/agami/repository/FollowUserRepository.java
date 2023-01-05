package com.agami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agami.model.FollowUser;

@Repository
public interface FollowUserRepository extends JpaRepository<FollowUser, Integer>{
	

}

package com.agami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agami.model.UserTl;


@Repository
public interface UserRepository  extends JpaRepository<UserTl, Integer>{
	
	public UserTl findById(int id);
	public UserTl findByEmailIdAndPassword(String emailId,String password);
	

}

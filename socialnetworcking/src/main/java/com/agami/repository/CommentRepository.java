package com.agami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agami.model.CommentTl;

@Repository
public interface CommentRepository extends JpaRepository<CommentTl, Integer>{

}

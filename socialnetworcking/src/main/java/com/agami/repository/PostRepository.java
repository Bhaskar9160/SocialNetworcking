package com.agami.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agami.model.PostTl;

@Repository
public interface PostRepository extends JpaRepository<PostTl, Integer>{
	
	@Query(value = "SELECT * FROM post_tl  where post_id in(SELECT post_id FROM share_tl where users_id=:p)",nativeQuery = true)
	public List<PostTl> getSharedPosts(@Param("p") Integer userId);

}

package com.agami.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class LikeTl {
	@Id
	@GeneratedValue
	private Integer likedId;
	
	private Integer postId;
	
	private Integer createdId;
	
	private Date createdOn;
	
	private String status;

}

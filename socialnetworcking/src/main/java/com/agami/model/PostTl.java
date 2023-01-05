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
public class PostTl {
	@Id
	@GeneratedValue
	private Integer postId;
	private String postTitle;
	private String  postDescription;
	private Date    postDate;
	private Integer postCreatedBy;

}

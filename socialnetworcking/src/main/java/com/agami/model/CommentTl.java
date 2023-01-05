package com.agami.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class CommentTl {
	@Id
	@GeneratedValue
	private Integer commentId;
	private String commentDescription;
	private Integer postId;
	private Date commentCreatedDate;
	private Integer commentCreatedBy;
	private String commentMailId;

}

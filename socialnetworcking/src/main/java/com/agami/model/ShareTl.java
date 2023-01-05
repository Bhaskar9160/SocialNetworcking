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
public class ShareTl {
	
	@Id
	@GeneratedValue
	private Integer shareId;
	private Integer postId;
	private Integer usersId;
	private Integer createdBy;
	private Date createdOn;
	
	

}

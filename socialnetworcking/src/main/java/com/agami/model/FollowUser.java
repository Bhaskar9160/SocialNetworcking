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
public class FollowUser {
	@Id
	@GeneratedValue
	private Integer followUserId;
	
	private Integer userId;
	
	private Date createdOn;
	
	private Integer createdBy;

}

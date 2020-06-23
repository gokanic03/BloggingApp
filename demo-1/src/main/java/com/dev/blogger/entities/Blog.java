package com.dev.blogger.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Table(name = "BLOG")
@Data
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long blogid;
	
	@Column(nullable = false, name="title")
	private String title;
	 
	@Column (name="content")
	private String content;
	
	
	//@Column
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Timestamp dnt;
	
	@JoinColumn(name = "userid")
	private Long userid;
	
}

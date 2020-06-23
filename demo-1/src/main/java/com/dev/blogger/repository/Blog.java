package com.dev.blogger.repository;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "BLOG")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long blogid;
	
	@Column(nullable = false, name="title")
	private String title;
	 
	@Column (name="content")
	private String content;
	
	//@Column (name="userid")
	//private Long userid;
	
	//@Basic
	//@Temporal(TemporalType.TIMESTAMP)
	//@Column
	//private Timestamp dnt;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private Long userid;
	
	public Long getUId() {
		return userid;
	}
	public void setUId(Long userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Long getBlogId() {
		return blogid;
	}

	public void setBlogId(Long blogid) {
		this.blogid = blogid;
	}
}

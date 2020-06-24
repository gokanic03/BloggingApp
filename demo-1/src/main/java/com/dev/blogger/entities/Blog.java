package com.dev.blogger.entities;

import java.util.Optional;

//import java.sql.Timestamp;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.dev.blogger.views.Views;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Entity
@Data
@Table(name = "BLOG")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "blogid")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.Public.class)
    private Long blogid;
	
	@Column(nullable = false, name="title")
	@JsonView(Views.Public.class)
	private String title;
	 
	@Column (name="content")
	@JsonView(Views.Public.class)
	private String content;
	
	
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    //private Date currentTime =new Date();
	
	@ManyToOne
	@JoinColumn(name = "userid")
	@JsonView(Views.Public.class)
	private User user;
	
}

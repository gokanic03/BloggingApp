package com.dev.blogger.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USER")
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long UID;
	
	@Column(nullable = false, name="Name")
	private String name;
	
	@OneToMany(mappedBy="userid",cascade=CascadeType.ALL)
	private List<Blog> blogList;
	
}

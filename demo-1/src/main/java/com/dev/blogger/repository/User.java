package com.dev.blogger.repository;

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
	
    public List<Blog> getblogList() {
        return blogList;
    }
    
    public void setblogList(List<Blog> blogList) {
        this.blogList=blogList;
    }
	
	public Long getUId() {
		return UID;
	}
	public void setUId(Long UID) {
		this.UID = UID;
	}

	public String getNme() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

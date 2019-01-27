package com.accolite.model;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Cacheable
@Table(name="likes")
public class Like {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String likedby;
	private Date likedtime;
	
	public String getLikedby() {
		return likedby;
	}
	
	public void setLikedby(String likedby) {
		this.likedby = likedby;
	}
	
	public Date getLikedtime() {
		return likedtime;
	}
	
	public void setLikedtime(Date likedtime) {
		this.likedtime = likedtime;
	}
	
	@Override
	public String toString() {
		return "Like [id=" + id + ", likedby=" + likedby + ", likedtime=" + likedtime + "]";
	}
	
}

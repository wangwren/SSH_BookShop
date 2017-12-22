package com.dhee.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Create table reward
(
		id int(10) NOT NULL AUTO_INCREMENT,
		address varchar(100) not null,	
		user_id int(10) not null,
		primary key(id)
)

 */
@Entity
@Table(name="reward")
public class RewardVo {

	private int id;
	private String address;
	private int user_id;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}

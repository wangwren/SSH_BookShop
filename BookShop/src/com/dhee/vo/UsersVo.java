package com.dhee.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * create table users
	(
		id int(10) NOT NULL AUTO_INCREMENT,
		username varchar(40) not null unique,	
		password varchar(40) not null,
		phone varchar(40) not null,
		email varchar(40) not null,
		ulimit int not null,
		primary key(id)
	);

 */

@Entity
@Table(name="users")
public class UsersVo {

	private int id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private int ulimit;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUlimit() {
		return ulimit;
	}
	public void setUlimit(int ulimit) {
		this.ulimit = ulimit;
	}
	
	
}

package com.dhee.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * create table orders
	(
		id int(10) NOT NULL AUTO_INCREMENT,
		ordertime datetime not null, 
		price double,	
		state boolean, 
		user_id int(10),
		address varchar(100),
		primary key(id)
	);

 */
@Entity
@Table(name="orders")
public class OrdersVo {

	private int id;
	@Column(name="ordertime")
	private Date ordertime;
	@Column(name="price")
	private double price;
	@Column(name="state")
	private boolean state;
	@Column(name="user_id")
	private int user_id;
	@Column(name="address")
	private String address;
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}

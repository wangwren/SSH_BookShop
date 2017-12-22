package com.dhee.vo;

import java.util.Date;

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
		primary key(id)
	);

 */
@Entity
@Table(name="orders")
public class OrdersVo {

	private int id;
	private Date ordertime;
	private double price;
	private boolean state;
	
	private int user_id;

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

package com.dhee.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * create table orderitem
	(
		id int(10) NOT NULL AUTO_INCREMENT, 
		quantity int, 
		price double,	
		order_id int(10), 
		book_id int(10), 
		primary key(id)
	);

 */
@Entity
@Table(name="orderitem")
public class OrderItemVo {

	private int id;
	@Column(name="quantity")
	private int quantity;
	@Column(name="price")
	private double price;
	@Column(name="order_id")
	private int order_id;
	@Column(name="book_id")
	private int book_id;
	
	/*private BooksVo book;
	private OrdersVo order;
	
	public BooksVo getBook() {
		return book;
	}
	public void setBook(BooksVo book) {
		this.book = book;
	}
	public OrdersVo getOrder() {
		return order;
	}
	public void setOrder(OrdersVo order) {
		this.order = order;
	}*/
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	
}

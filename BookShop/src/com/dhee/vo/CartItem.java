package com.dhee.vo;

public class CartItem {

	private BooksVo book;
	private int quantity;	//¹ºÂòµÄÊýÁ¿
	private double price;
	public BooksVo getBook() {
		return book;
	}
	public void setBook(BooksVo book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return this.getBook().getPrice() * this.quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

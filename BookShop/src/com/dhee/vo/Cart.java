package com.dhee.vo;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Integer,CartItem> map = new HashMap<Integer,CartItem>();
	private double price;	//总价格
	
	
	public Map<Integer, CartItem> getMap() {
		return map;
	}


	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}


	public double getPrice() {
		
		double totalPrice = 0;
		for(Map.Entry<Integer, CartItem> me : map.entrySet()){
			totalPrice = totalPrice + me.getValue().getPrice();
		}
		
		this.price = totalPrice;
		
		return price;
		
	}


	public void setPrice(double price) {
		this.price = price;
	}


	/**提供一个添加至购物车的方法**/
	public void add(BooksVo book){
		CartItem item = map.get(book.getId());
		
		//如果原本购物车中没有该图书
		if(item == null){
			item = new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);
		}else{
			item.setQuantity(item.getQuantity() + 1);
		}
	}
	
	public void deleteBook(int id) {
		
		CartItem item = map.get(id);
		if(item.getQuantity() > 1) {
			item.setQuantity(item.getQuantity() - 1);
		}else {
			map.remove(id);
		}
	}
	
	
	
	
}

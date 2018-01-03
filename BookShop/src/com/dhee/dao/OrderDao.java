package com.dhee.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dhee.vo.OrderItemVo;
import com.dhee.vo.OrdersVo;

public class OrderDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	/**
	 * 添加订单
	 * @param order
	 */
	public void addOrder(OrdersVo order) throws Exception{
		
		this.hibernateTemplate.save(order);
	}
	
	/**
	 * 添加订单项
	 * @param itemVo
	 * @throws Exception
	 */
	public void addOrderItem(OrderItemVo itemVo) throws Exception{
		
		this.hibernateTemplate.save(itemVo);
	}

	/**
	 * 查看订单
	 * id为指定用户的编号
	 * @param id
	 * @return
	 */
	public List<OrdersVo> findOrder(int id) throws Exception{
		
		String hql = "from OrdersVo where user_id=?";
		List<OrdersVo> list = this.hibernateTemplate.find(hql, new Object[] {id});
		
		return list;
	}
	
	/**
	 * 查询指定订单编号的订单信息
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public OrdersVo findOrderByOrderId(int orderId) throws Exception{
		
		String hql = "from OrdersVo where id=?";
		List<OrdersVo> list = this.hibernateTemplate.find(hql, orderId);
		OrdersVo order = null;
		for(OrdersVo or : list) {
			order = or;
		}
		
		return order;
	}

	/**
	 * 查询指定订单项
	 * @param id
	 * @return
	 */
	public List<OrderItemVo> findOrderItem(int id) {
		
		String hql = "from OrderItemVo where order_id=?";
		List<OrderItemVo> list = this.hibernateTemplate.find(hql, id);
		return list;
	}

	/**
	 * 后台查询所有订单
	 * @param st
	 */
	public List<OrdersVo> listAll(boolean st) {
		
		String hql = "from OrdersVo where state=?";
		List<OrdersVo> list = this.hibernateTemplate.find(hql, st);
		return list;
	}
	
	public void ship(int id) throws Exception{
		
		OrdersVo order = this.findOrderByOrderId(id);
		order.setState(true);
		
		this.hibernateTemplate.update(order);
	}

	/**
	 * 用户删除订单信息,和订单项信息
	 * @param id
	 */
	public void delete(int id) throws Exception{
		
		OrdersVo order = this.findOrderByOrderId(id);
		this.hibernateTemplate.delete(order);
		
		//删除订单项
		List<OrderItemVo> list = this.findOrderItem(id);
		this.hibernateTemplate.deleteAll(list);
	}
}

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

	public List<OrderItemVo> findOrderItem(int id) {
		
		String hql = "from OrderItemVo where order_id=?";
		List<OrderItemVo> list = this.hibernateTemplate.find(hql, id);
		return list;
	}
}

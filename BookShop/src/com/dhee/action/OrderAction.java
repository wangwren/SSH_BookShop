package com.dhee.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dhee.dao.OrderDao;
import com.dhee.dao.RewardDao;
import com.dhee.vo.Cart;
import com.dhee.vo.OrdersVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 完成人:王威人
 * 订单相关
 * @author wwr
 *
 */
public class OrderAction extends ActionSupport implements SessionAware,RequestAware{

	private OrderDao orderDao;
	private String userid;
	private Map<String,Object> session;
	private Map<String,Object> request;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}
	
	public void setRequest(Map<String, Object> request) {
		
		this.request = request;
		
	}
	
	/**
	 * 添加订单
	 * @return
	 * @throws Exception
	 */
	public String confirm() throws Exception{
		
		Cart cart = (Cart) session.get("cart");
		//System.out.println(cart.getPrice());
		//System.out.println(userid);
		
		int id = Integer.parseInt(userid);
		
		OrdersVo order = new OrdersVo();
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser_id(id);
		order.setOrdertime(new Date());
		
		orderDao.addOrder(order);
		
		//订单项没写
		
		request.put("message", "订单已生成，请等待发货！！！");
		session.remove("cart");
		
		return SUCCESS;
	}
	
	/**
	 * 查看订单
	 * @return
	 * @throws Exception
	 */
	public String findOrder() throws Exception{
		
		int id = Integer.parseInt(userid);
		List<OrdersVo> list = orderDao.findOrder(id);
		
		request.put("orders", list);
		
		return SUCCESS;
	}

}

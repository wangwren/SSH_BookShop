package com.dhee.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dhee.dao.BookDao;
import com.dhee.dao.OrderDao;
import com.dhee.dao.RewardDao;
import com.dhee.dao.UserDao;
import com.dhee.vo.BooksVo;
import com.dhee.vo.Cart;
import com.dhee.vo.CartItem;
import com.dhee.vo.OrderItemVo;
import com.dhee.vo.OrdersVo;
import com.dhee.vo.RewardVo;
import com.dhee.vo.UsersVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 订单相关
 * @author wwr
 *
 */
public class OrderAction extends ActionSupport implements SessionAware,RequestAware{

	private OrderDao orderDao;
	private BookDao bookDao;
	private UserDao userDao;
	private RewardDao rewardDao;
	private String userid;
	private Map<String,Object> session;
	private Map<String,Object> request;
	private int order_id = 40;	//订单编号，这是一个bug，应该让订单编号自动生成，而不是数据库编号自动增长
	//这个值随着服务器的重启随时都需要改，与数据库中订单编号最大的相同
	private String orderid;
	private String state;	//获取订单状态
	
	private String address;
	
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRewardDao(RewardDao rewardDao) {
		this.rewardDao = rewardDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

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
		
		int id = Integer.parseInt(userid);
		
		OrdersVo order = new OrdersVo();
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser_id(id);
		order.setOrdertime(new Date());
		
		String newAddress = new String(address.getBytes("iso-8859-1"), "UTF-8");
		if(newAddress == null || newAddress == "") {
			request.put("message", "请选择收货地址！！！");
			return "addressError";
		}
		order.setAddress(newAddress);
		
		
		orderDao.addOrder(order);
		
		order_id = order_id + 1;
		//订单项
		for(Map.Entry<Integer, CartItem> me : cart.getMap().entrySet()) {
			
			//得到一个购物项就生成一个订单项
			CartItem citem = me.getValue();
			OrderItemVo item = new OrderItemVo();
			item.setPrice(citem.getPrice());
			item.setQuantity(citem.getQuantity());
			item.setBook_id(citem.getBook().getId());
			item.setOrder_id(order_id);
			
			orderDao.addOrderItem(item);
		}
		
		
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
	
	/**
	 * 查看订单项
	 * @return
	 * @throws Exception
	 */
	public String orderItemFind() throws Exception{
		
		int id = Integer.parseInt(orderid);
		List<OrderItemVo> list = orderDao.findOrderItem(id);
		OrdersVo order = orderDao.findOrderByOrderId(id);
		
		request.put("item", list);
		request.put("order", order);
		
		//查询用户信息
		UsersVo user = userDao.findById(order.getUser_id());
		request.put("user", user);
		
		//查询用户地址
		List<RewardVo> rewardList = rewardDao.findAddress(user.getId());
		RewardVo reward = null;
		for(RewardVo re : rewardList) {
			reward = re;
		}
		request.put("reward", reward);
		
		return SUCCESS;
	}
	
	/**
	 * 查询所有订单
	 * @return
	 * @throws Exception
	 */
	public String listAll() throws Exception{
		
		boolean st = Boolean.parseBoolean(state);
		List<OrdersVo> list = orderDao.listAll(st);
		
		request.put("orders", list);
		
		return "listOrders";
	}
	
	/**
	 * 发货
	 * @return
	 * @throws Exception
	 */
	public String ship() throws Exception{
	
		int id = Integer.parseInt(orderid);
		orderDao.ship(id);
		request.put("message", "已确认发货!!!");
		return "ship";
	}
	
	public String delete() throws Exception{
		
		int id = Integer.parseInt(orderid);
		orderDao.delete(id);
		request.put("message", "删除成功!!!");
		
		return "delete";
	}

}

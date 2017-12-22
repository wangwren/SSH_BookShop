package com.dhee.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dhee.dao.RewardDao;
import com.dhee.vo.RewardVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 完成人:景思源，姜松
 * 用户地址
 * @author wwr
 *
 */
public class RewardAction extends ActionSupport implements RequestAware,SessionAware{

	private RewardDao rewardDao;
	private String userid;
	private RewardVo reward;
	private Map<String,Object> request;
	private Map<String,Object> session;
	

	public RewardVo getReward() {
		return reward;
	}

	public void setReward(RewardVo reward) {
		this.reward = reward;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public RewardDao getRewardDao() {
		return rewardDao;
	}

	public void setRewardDao(RewardDao rewardDao) {
		this.rewardDao = rewardDao;
	}
	
	public void setRequest(Map<String, Object> request) {
		
		this.request = request;
		
	}
	
	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}
	
	/**
	 * 查询用户地址
	 * @return
	 * @throws Exception
	 */
	public String find() throws Exception {
		
		int id = Integer.parseInt(userid);
		List<RewardVo> list = rewardDao.findAddress(id);
		
		session.put("reward", list);
		
		
		return SUCCESS;
	}
	
	/**
	 * 添加地址
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		
		reward.setAddress(new String(reward.getAddress().getBytes("iso-8859-1"),"utf-8"));
		
		rewardDao.addAddress(reward);
		request.put("message", "地址添加成功！！！");
		
		return SUCCESS;
	}

}

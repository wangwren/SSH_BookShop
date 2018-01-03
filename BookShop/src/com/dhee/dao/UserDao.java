package com.dhee.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dhee.vo.UsersVo;

public class UserDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	/**用户注册**/
	public void addUser(UsersVo user) throws Exception{
		
		this.hibernateTemplate.save(user);
	}
	
	/**用户登录**/
	public List<UsersVo> login(UsersVo user) throws Exception{
		
		String hql = "from UsersVo where username=? and password=?";
		Object[] values = {user.getUsername(),user.getPassword()};
		List<UsersVo> list = this.hibernateTemplate.find(hql, values);
		return list;
	}
	
	
	/**
	 * 查询指定用户的信息
	 * @param id
	 * @return
	 */
	public UsersVo findById(int id) {
		
		String hql = "from UsersVo where id=?";
		List<UsersVo> list = this.hibernateTemplate.find(hql, id);
		UsersVo user = null;
		for(UsersVo u : list) {
			user = u;
		}
		return user;
	}

	/**
	 * 查询全部用户
	 */
	public List<UsersVo> findAll() {
		
		List<UsersVo> list = this.hibernateTemplate.find("from UsersVo");
		return list;
	}
}

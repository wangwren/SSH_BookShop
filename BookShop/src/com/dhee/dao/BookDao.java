package com.dhee.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dhee.vo.BooksVo;

public class BookDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public List<BooksVo> findById(int id) throws Exception{
		
		String hql = "from BooksVo where id=?";
		List<BooksVo> list = this.hibernateTemplate.find(hql, new Object[] {id});
		return list;
	}
}

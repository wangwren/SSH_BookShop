package com.dhee.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dhee.vo.BooksVo;

public class IndexDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	//À˘”–Õº È
	public List<BooksVo> selectAllBooks() throws Exception{
		
		List<BooksVo> list = this.hibernateTemplate.find("from BooksVo");
		
		return list;
	}
}

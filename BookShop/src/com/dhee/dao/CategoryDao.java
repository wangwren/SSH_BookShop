package com.dhee.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dhee.vo.CategorysVo;

public class CategoryDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	/**
	 * 查询出所有的图书类型
	 */
	public List<CategorysVo> findAll(){
		
		List<CategorysVo> list = this.hibernateTemplate.find("from CategorysVo");
		
		return list;
	}
	
	/**
	 * 查询指定图书类型
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CategorysVo findById(String id) throws Exception{
		
		List<CategorysVo> list = this.hibernateTemplate.find("from CategorysVo where id=?", id);
		
		CategorysVo ca = null;
		for(CategorysVo c : list) {
			ca = new CategorysVo();
			ca = c;
		}
		
		return ca;
	}
}

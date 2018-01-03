package com.dhee.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	
	/**
	 * 获取数据库中category编号的最大值
	 * @return
	 * @throws Exception
	 */
	public String maxSize() throws Exception {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(CategorysVo.class);
		Projection po = Projections.max("id");
		criteria.setProjection(po);
		List<String> list = this.hibernateTemplate.findByCriteria(criteria);
		String max = null;
		for(String num : list) {
			max = num;
		}
		
		return max;
	}

	/**
	 * 添加图书类型
	 * @param category
	 */
	public void add(CategorysVo category) throws Exception{
		
		this.hibernateTemplate.save(category);
	}
	
	/**
	 * 图书类型删除
	 */
	public void delete(String id) throws Exception{
		
		CategorysVo ca = this.findById(id);
		this.hibernateTemplate.delete(ca);
	}

	/**
	 * 修改图书类型
	 * @param category
	 */
	public void update(CategorysVo category) {
		
		this.hibernateTemplate.update(category);
		
	}
}

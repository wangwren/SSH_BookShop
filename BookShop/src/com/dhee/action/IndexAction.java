package com.dhee.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dhee.dao.CategoryDao;
import com.dhee.dao.IndexDao;
import com.dhee.vo.BooksVo;
import com.dhee.vo.CategorysVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 首页，浏览所有图书
 * @author wwr
 *
 */
public class IndexAction extends ActionSupport implements RequestAware,SessionAware {

	private IndexDao indexDao;
	
	private List<BooksVo> books;
	
	private Map<String,Object> request;
	private CategoryDao categoryDao;
	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void setRequest(Map<String, Object> request) {
	
		this.request = request;
		
	}
	
	public List<BooksVo> getBooks() {
		return books;
	}



	public void setBooks(List<BooksVo> books) {
		this.books = books;
	}



	public IndexDao getIndexDao() {
		return indexDao;
	}



	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}



	/**
	 * 浏览所有图书
	 * 并查询出所有图书类型
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception{
		
		books = indexDao.selectAllBooks();
		List<CategorysVo> list = categoryDao.findAll();
		
		request.put("books", books);
		session.put("categorys", list);
		
		return SUCCESS;
	}

}

package com.dhee.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.dhee.dao.IndexDao;
import com.dhee.vo.BooksVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 完成人:佟荣新，王威人
 * 首页，浏览所有图书
 * @author wwr
 *
 */
public class IndexAction extends ActionSupport implements RequestAware {

	private IndexDao indexDao;
	
	private List<BooksVo> books;
	
	private Map<String,Object> request;
	
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
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception{
		
		books = indexDao.selectAllBooks();
		request.put("books", books);
		
		return SUCCESS;
	}

}

package com.dhee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.aspectj.util.FileUtil;

import com.dhee.dao.BookDao;
import com.dhee.dao.CategoryDao;
import com.dhee.vo.BooksVo;
import com.dhee.vo.CategorysVo;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 图书管理逻辑层
 */
public class BookAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = -3498173228078093869L;
	private CategoryDao categoryDao;
	private Map<String,Object> request;
	private BooksVo book;
	private File img;
	private String imgContentType;
	private String imgFileName;
	private BookDao bookDao;
	private String id;
	private String caid;
	
	

	public String getCaid() {
		return caid;
	}

	public void setCaid(String caid) {
		this.caid = caid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public BooksVo getBook() {
		return book;
	}

	public void setBook(BooksVo book) {
		this.book = book;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public void setRequest(Map<String, Object> request) {
		
		this.request = request;
		
	}


	/**
	 * 提供图书添加的界面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		
		List<CategorysVo> list = categoryDao.findAll();
		request.put("categorys", list);
		
		return SUCCESS;
	}
	
	/**
	 * 图书信息的添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		
		/*book.setName(new String(book.getName().getBytes("iso-8859-1"),"utf-8"));
		book.setAuthor(new String(book.getAuthor().getBytes("iso-8859-1"),"utf-8"));
		book.setDescription(new String(book.getDescription().getBytes("iso-8859-1"),"utf-8"));*/
		
		String realPath=ServletActionContext.getServletContext().getRealPath("/images");
		File file = new File(realPath);
		
		/*setImgFileName(UUID.randomUUID().toString() + ".gif");
		System.out.println(imgFileName);*/
		book.setImage(imgFileName);
		
		if(!file.exists())
            file.mkdirs();
		
		//new File(imgRealPath,this.uploadImageFileName) 意思是在前边的目录下创建后边的文件
	    //下边意思是复制文件，把前边的文件复制到后边的文件中
		FileUtil.copyFile(img, new File(realPath, imgFileName));
		
		//以下是自己编写的io流文件上传，服务器关闭后，不久后便会自动删除
		/*FileOutputStream out=
                new FileOutputStream(new File(file,getImgFileName()));
		
		FileInputStream in=new FileInputStream(getImg());
		
		
		byte[] buffer=new byte[1024];
        int len=0;
        while((len=in.read(buffer))>0)
            out.write(buffer,0,len);
        out.close();
        in.close();*/
		
        bookDao.add(book);
        request.put("message", "添加成功！！！");
		
		return "yes";
	}
	
	/**
	 * 后台查询所有图书信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		
		List<BooksVo> list = bookDao.list();
		request.put("books", list);
		
		return "list";
	}
	
	/**
	 * 删除图书
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		
		int bookid = Integer.parseInt(id);
		List<BooksVo> list = bookDao.findById(bookid);
		for(BooksVo b :list) {
			book = new BooksVo();
			book = b;
		}
		//需要删对象
		bookDao.delete(book);
		request.put("message", "删除成功!!!");
		
		return "delete";
	}
	
	/**
	 * 查询出指定图书
	 * @return
	 * @throws Exception
	 */
	public String findById() throws Exception{
		
		int bookid = Integer.parseInt(id);
		List<BooksVo> list = bookDao.findById(bookid);
		for(BooksVo b :list) {
			book = new BooksVo();
			book = b;
		}
		request.put("book", book);
		
		
		//查询指定类型
		CategorysVo ca = categoryDao.findById(book.getCategory_id() + "");
		request.put("ca", ca);
		
		//查询所有类型
		List<CategorysVo> categorys = categoryDao.findAll();
		request.put("categorys", categorys);
		
		return "find";
	}
	
	/**
	 * 修改图书
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		
		bookDao.update(book);
		request.put("message", "修改图书成功!!!");
		
		return "update";
	}
	
	/**
	 * 通过图书类型查询图书
	 * @return
	 * @throws Exception
	 */
	public String findByCid() throws Exception{
		
		int id = Integer.parseInt(caid);
		List<BooksVo> list = bookDao.findByCid(id);
		request.put("cbooks", list);
		return "findByCid";
	}

}

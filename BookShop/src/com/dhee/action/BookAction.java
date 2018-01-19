package com.dhee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
	
	/**
	 * 后台图书数据导出至Excel表
	 * @return
	 * @throws Exception
	 */
	public String table2Excel() throws Exception{
		
		//设置表头
		String[] headName = {"图书名称","作者","价格","描述"};
		
		//表的列数
		int cellNumber = headName.length;
		
		//创建一个Excel
		HSSFWorkbook workBook = new HSSFWorkbook();
		
		//表的列
		HSSFCell cell = null;
		
		//表的行
		HSSFRow row = null;
		
		//设置表头居中
		HSSFCellStyle headStyle = workBook.createCellStyle();
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		//设置数据居中
		HSSFCellStyle dataStyle = workBook.createCellStyle();
		dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		//设置字体
		HSSFFont font = workBook.createFont();
		
		//创建一个sheet，对应Excel的sheet
		HSSFSheet sheet = workBook.createSheet("sheet1");
		
		//得到sheet的头
		HSSFHeader header = sheet.getHeader();
		
		//得到所有图书数据
		List<BooksVo> books = bookDao.list();
		
		//如果得到的数据为空
		if(books.size() < 1 || books == null) {
			header.setCenter("暂无数据");
		}else {
			//如果有数据，将表头设置上
			header.setCenter("图书表");
			//设置表格第1行，即表头
			row = sheet.createRow(0);
			//设置行高
			row.setHeight((short) 400);
			
			//设置表头值
			for(int i = 0; i < cellNumber; i++) {
				//创建第1行第i列
				cell = row.createCell(i);
				//设置第1行第i列的数据，即将表头设置进去
				cell.setCellValue(headName[i]);
				
				sheet.setColumnWidth(i,8000);//设置列的宽度  
			    font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色.  
			    font.setFontHeight((short)350); //设置单元字体高度  
			    headStyle.setFont(font);//设置字体风格  
			    cell.setCellStyle(headStyle);  
			}
			
			//填充数据
			for(int i = 0; i < books.size();i++) {
				BooksVo book = books.get(i);
				row = sheet.createRow(i + 1);
				row.setHeight((short) 400);
				if(book.getName() != null) {
					cell = row.createCell(0);
					cell.setCellValue(book.getName());
					cell.setCellStyle(dataStyle);
				}
				if(book.getAuthor() != null) {
					cell = row.createCell(1);
					cell.setCellValue(book.getAuthor());
					cell.setCellStyle(dataStyle);
				}
				if(book.getPrice() != 0) {
					cell = row.createCell(2);
					cell.setCellValue(book.getPrice());
					cell.setCellStyle(dataStyle);
				}
				if(book.getDescription() != null) {
					cell = row.createCell(3);
					cell.setCellValue(book.getDescription());
					cell.setCellStyle(dataStyle);
				}
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			OutputStream out = response.getOutputStream();
			
			response.setHeader("Content-disposition","attachment; filename=" + "book" + ".xls");//filename是下载的xls的名，建议最好用英文  
            response.setContentType("application/msexcel;charset=UTF-8");//设置类型  
            response.setHeader("Pragma","No-cache");//设置头  
            response.setHeader("Cache-Control","no-cache");//设置头  
            response.setDateHeader("Expires", 0);//设置日期头  
            
            workBook.write(out);
            out.flush();
            
            if(out != null) {
            	out.close();
            }
            
		}
		
		return null;
	}

}

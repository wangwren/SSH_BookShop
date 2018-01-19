<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
    <h2>图书信息</h2>
    <br/>
    <table border="1" align="center" width="80%">
    	<tr>
    		<td>图书名称</td>
    		<td>作者</td>
    		<td>价格</td>
    		<td>图片</td>
    		<td>描述</td>
    		<td colspan="2">操作</td>
    	</tr>
    	
    	<s:iterator var="b" value="#request.books">
    		<tr>
    			<td><s:property value="#b.name"/></td>
    			<td><s:property value="#b.author"/></td>
    			<td><s:property value="#b.price"/></td>
    			<td><a href="${pageContext.request.contextPath }/images/${b.image}">查看图片</a></td>
    			<td><s:property value="#b.description"/></td>
    			<td>
	    			<a href="${pageContext.request.contextPath }/Book_findById?id=${b.id}">修改</a>
	    			<a href="${pageContext.request.contextPath }/Book_delete?id=${b.id}">删除</a>
	    		</td>
    		</tr>
    	</s:iterator>
    </table>
    <a href="${pageContext.request.contextPath }/Book_table2Excel.action">导出至Excel</a>
  </body>
</html>
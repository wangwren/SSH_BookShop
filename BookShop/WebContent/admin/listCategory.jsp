<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有图书类型</title>
</head>
<body>
	<body style="text-align: center;">
    <h2>图书类型信息</h2>
    <br/>
    <table border="1" align="center" width="80%">
    	<tr>
    		<td>类型编号</td>
    		<td>类型名称</td>
    		<td>描述</td>
    		<td colspan="2">操作</td>
    	</tr>
    	
    	<s:iterator var="ca" value="#request.categorys">
    		<tr>
    			<td><s:property value="#ca.id"/></td>
    			<td><s:property value="#ca.name"/></td>
    			<td><s:property value="#ca.description"/></td>
    			<td>
	    			<a href="${pageContext.request.contextPath }/Category_findById?id=${ca.id}">修改</a>
	    			<a href="${pageContext.request.contextPath }/Category_delete?id=${ca.id}">删除</a>
	    		</td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</body>
</html>
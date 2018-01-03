<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有用户</title>
</head>
<body style="text-align: center;">
    <h2>用户信息</h2>
    <br/>
    <table border="1" align="center" width="80%">
    	<tr>
    		<td>用户编号</td>
    		<td>用户名</td>
    		<td>密码</td>
    		<td>联系电话</td>
    		<td>email</td>
    		<td>权限</td>
    	</tr>
    	
    	<s:iterator var="user" value="#request.users">
    		<tr>
    			<td><s:property value="#user.id"/></td>
    			<td><s:property value="#user.username"/></td>
    			<td><s:property value="#user.password"/></td>
    			<td><s:property value="#user.phone"/></td>
    			<td><s:property value="#user.email"/></td>
    			<td>${user.ulimit==2?'普通用户':'管理员' }</td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
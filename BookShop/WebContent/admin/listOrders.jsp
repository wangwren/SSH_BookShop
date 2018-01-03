<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台订单信息</title>
</head>
<body style="text-align: center;">
    <h2>订单信息</h2>
    <br/>
    <table border="1" align="center" width="80%">
    	<tr>
    		<td>订单编号</td>
    		<td>订单时间</td>
    		<td>订单状态</td>
    		<td>订单总价</td>
    		<td>操作</td>
    	</tr>
    	
    	<s:iterator var="order" value="#request.orders">
    		<tr>
    			<td><s:property value="#order.id"/></td>
    			<td><s:property value="#order.ordertime"/></td>
    			<td style="color: red">${order.state==true?'已发货':'未发货' }</td>
    			<td><s:property value="#order.price"/></td>
    			<td>
	    			<s:a href="orderItemFind?orderid=%{#order.id}">查看</s:a>
	    		</td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单明细</title>
</head>
<body>
    <h3>订单明细</h3>
    <br/>
    <table style="text-align:center;" border="1" width="60%">
    	<tr>
    		<td>图书编号</td>
    		<td>单价</td>
    		<td>数量</td>
    		<td>小计(元*)</td>
    	</tr>
    	
    	<s:iterator var="it" value="#request.item">
    		<tr>
    			<td><s:property value="#it.book_id"/></td>
    			<td>${it.price/it.quantity}</td>
    			<td><s:property value="#it.quantity"/></td>
    			<td><s:property value="#it.price"/></td>
    		</tr>
    	</s:iterator>
    	<tr>
    		<td>总价钱</td>
    		<td colspan="3">${order.price}(元*)</td>
    	</tr>
    </table>
    
    
    <h3>收货人详细信息</h3>
    <table style="text-align:center;" border="1" width="60%">
    	<tr>
    		<td>用户名</td>
    		<td>电话</td>
    		<td>邮箱</td>
    		<!-- <td>地址</td> -->
    	</tr>
    	
    	<tr>
    		<td>${user.username }</td>
    		<td>${user.phone }</td>
    		<td>${user.email }</td>
    		<%-- <td>${reward.address}</td> --%>
    	</tr>
    </table>
    <br/>
    <s:if test="#session.user.ulimit==1 && #request.order.state==false">
    	<a href="${pageContext.request.contextPath }/Order_ship?orderid=${order.id}">确认发货</a>
    </s:if>
    <s:else>
    	<a href="index">点击返回首页</a>
    </s:else>
  </body>
</html>
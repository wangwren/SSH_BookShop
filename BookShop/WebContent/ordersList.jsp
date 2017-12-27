<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body style="text-align: center;">
    <h2>订单信息</h2>
    <br/>
    <s:if test="#request.orders!=null">
    <table border="1" align="center" width="80%">
    	<tr>
    		<td>订单人</td>
    		<td>订单时间</td>
    		<td>订单状态</td>
    		<td>订单总价</td>
    		<td colspan="2">操作</td>
    	</tr>
    	
    	<s:iterator var="order" value="#request.orders">
    		<tr>
    			<td><s:property value="#session.user.username"/></td>
    			<td><s:property value="#order.ordertime"/></td>
    			<td style="color: red">${order.state==true?'已发货':'未发货' }</td>
    			<td><s:property value="#order.price"/></td>
    			<td>
	    			<s:a href="orderItemFind?orderid=%{#order.id}">查看明细</s:a>
	    			<a href="#">删除</a>
	    		</td>
    		</tr>
    	</s:iterator>
    </table>
    </s:if>
	 <s:elseif test="#request.orders==null&&#session.user!=null">
	    	您的购物车是空的！！！
	 </s:elseif>
	 <s:elseif test="#session.user==null">
	    	请先登录！！！
	 </s:elseif>
	 <br/>
    <a href="index">点击返回首页</a>
  </body>
</body>
</html>
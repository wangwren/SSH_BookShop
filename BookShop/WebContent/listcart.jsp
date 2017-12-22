<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/css1.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
				<script type="text/javascript">
					$(document).ready(function () {
						$('#horizontalTab').easyResponsiveTabs({
							type: 'default', //Types: default, vertical, accordion           
							width: 'auto', //auto or any width like 600px
							fit: true   // 100% fit in a container
						});
					});
				   </script>
</head>
<body>
<!-- 顶部开始 -->
	<div class="top">

		<div class="top1">
			<div class="daohang1">
				<ul>
					<s:if test="#session.user==null">
						<li><a href="index">首页</a></li>
						<li><a href="${pageContext.request.contextPath }/ordersList.jsp">我的订单</a></li>
						<li>
							<a href="${pageContext.request.contextPath }/login.jsp" style="border-right:0px;">登录注册</a>
						</li>
					</s:if>
					<s:else>
						<li><a href="index">首页</a></li>
						<li><s:a href="findOrder?userid=%{#session.user.id}">我的订单</s:a></li>
						<li>
							<p style="border-right:0px;"><s:property value="#session.user.username"/></p>
						</li>
						<li><a href="${pageContext.request.contextPath }/userLoginOut" style="border-right:0px;">注销</a></li>
					</s:else>
				</ul>

			</div>
		</div>
		
		<div class="top3">
			<img src="images/3.jpg">
		</div>
		<div class="top2">
			<ul>
				<li><a href="">文艺</a></li>
				<li><a href="">童书</a></li>
				<li><a href="">教育</a></li>
				<li><a href="">人文社科</a></li>
				<li><a href="">经管</a></li>
				<li><a href="">励志</a></li>
				<li><a href="">科技</a></li>
				<li><a href="">科技</a></li>
				<li><a href="">科技</a></li>
				<li><a href="">科技</a></li>
				<li><a href="">人文社科</a></li>

			</ul>
		</div>

	</div>
	<!-- 顶部结束 -->

	<div class="gwc">
	
	<s:if test="#session.cart!=null">
		<s:iterator var="me" value="#session.cart.map">
			<div class="gwc1">
				<div class="gwc1z">
					<div class="gwc1zz">
						<img src="images/${me.value.book.image }">
					</div>
					<div class="gwc1zy">
						<h1><s:property value="#me.value.book.name"/></h1>
						<p>作者:<s:property value="#me.value.book.author"/></p>
					</div>
				</div>
				<div class="gwc1y">
					<table>
						<tr class="gwc1y1">
							<td>单价</td>
							<td>数量</td>
							<td>小计</td>
							<td></td>
						</tr>
						<tr class="gwc1y2">
							<td><s:property value="#me.value.book.price"/></td>
							<td><s:property value="#me.value.quantity"/></td>
							<td><s:property value="#me.value.price"/></td>
							<td><a href="deleteCart?bookid=${me.value.book.id}">删除</a></td>
						</tr>
					</table>
				</div>
			</div>
			</s:iterator>
			<div class="zongjia">
				<table>
					<td>总价:</td>
					<td>&nbsp;${cart.price}</td>
				</table>
			</div>
			
			<div class="shdz">
				<s:if test="#session.reward.size==0">
					<form action="addAddress" method="post">
						<table>
							<td>收货地址：</td>
							<td>
								<input placeholder="输入地址" name="reward.address" class="address" type="text" required="">
								<input type="hidden" name="reward.user_id" value="${user.id }">
							</td>
							<td><input type="submit" value="提交"/></td>
						</table>
					</form>
				</s:if>
				<s:else>
						<table>
							<td>收货地址：</td>
							<s:iterator var="re" value="#session.reward">
							<td><s:property value="#re.address"/></td>
							</s:iterator>
						</table>
						<div class="tijiao">
							<a href="${pageContext.request.contextPath }/confirmOrder?userid=${user.id}" class="tijiao">确认订单</a>
						</div>
				</s:else>
			</div>
		
		 </s:if>
	     
	    	<s:elseif test="#session.cart==null&&#session.user!=null">
		    	<div class="jinggao">
		    		<h1>您的购物车是空的！！！</h1>
		    	</div>
	    	</s:elseif>
		    <s:elseif test="#session.user==null">
			    <div class="jinggao">
			    	<h1>请先登录！！！</h1>
			    </div>
		    </s:elseif>
	    
	</div>
</body>
</html>
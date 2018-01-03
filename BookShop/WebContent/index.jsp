<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

<link href="css/index.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="css/swiper.min.css">
  <style>

    .swiper-container {
      width: 100%;
      height: 100%;

    }
    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;

      /* Center slide text vertically */
      display: -webkit-box;
      display: -ms-flexbox;
      display: -webkit-flex;
      display: flex;
      -webkit-box-pack: center;
      -ms-flex-pack: center;
      -webkit-justify-content: center;
      justify-content: center;
      -webkit-box-align: center;
      -ms-flex-align: center;
      -webkit-align-items: center;
      align-items: center;
    }
    .swiper-slide img{width:100%;hight:100%;}
  </style>

</head>
<body>
<div class="top">

		<div class="top1">
			<div class="daohang1">
				<ul>
					<s:if test="#session.user==null">
						<li><a href="${pageContext.request.contextPath }/listcart.jsp">购物车(<s:property value="#session.cart.map.size"/>)</a></li>
						<li><a href="${pageContext.request.contextPath }/ordersList.jsp">我的订单</a></li>
						<li>
							<a href="${pageContext.request.contextPath }/login.jsp" style="border-right:0px;">登录注册</a>
						</li>
					</s:if>
					<s:else>
						<li><s:a href="userAddress?userid=%{#session.user.id}">购物车(<s:property value="#session.cart.map.size"/>)</s:a></li>
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
				<li><a href="${pageContext.request.contextPath }/index">首页</a></li>
				<s:iterator var="ca" value="#session.categorys">
					<li><a href="${pageContext.request.contextPath }/Book_findByCid?caid=${ca.id}">${ca.name}</a></li>
				</s:iterator>
			</ul>
		</div>

	</div>
	<div class="banner">
		<div class="swiper-container">
		    <div class="swiper-wrapper">
		      	<div class="swiper-slide"><img src="images/top1.jpg"></div>
		      	<div class="swiper-slide"><img src="images/top2.jpg"></div>
		      	<div class="swiper-slide"><img src="images/top3.jpg"></div>
		      	<div class="swiper-slide"><img src="images/top4.jpg"></div>
		      	<div class="swiper-slide"><img src="images/top5.jpg"></div>
		      	<div class="swiper-slide"><img src="images/top6.jpg"></div>
		    </div>
		    <!-- Add Pagination -->
		    <div class="swiper-pagination"></div>
		    <!-- Add Arrows -->
		    <div class="swiper-button-next"></div>
	    	<div class="swiper-button-prev"></div>
	  	</div>

		  <!-- Swiper JS -->
	  	<script src="js/swiper.min.js"></script>

		  <!-- Initialize Swiper -->
		  	<script>
		    var swiper = new Swiper('.swiper-container', {
		      spaceBetween: 30,
		      centeredSlides: true,
		      autoplay: {
		        delay: 2500,
		        disableOnInteraction: false,
		      },
		      pagination: {
		        el: '.swiper-pagination',
		        clickable: true,
		      },
		      navigation: {
		        nextEl: '.swiper-button-next',
		        prevEl: '.swiper-button-prev',
		      },
		    });
	  	</script>
	</div>
	
	
	<!-- 显示图书 -->
	<div class="xianshi">
		<s:if test="#request.cbooks==null">
			<s:iterator var="book" value="#request.books">
				<div class="PX1_mid1">
					<div class="PX1_mid1z">
						<img src="images/${book.image }">
					</div>
					<div class="PX1_mid1y">
						<div class="PX1_mid1_text">
							<h2><s:property value="#book.name"/> </h2>
							<p class="PX1_mid1_text1"><s:property value="#book.description"/></p>
							<p class="PX1_mid1_text2">作者：<s:property value="#book.author"/></p>
							<h3>￥<s:property value="#book.price"/></h3>
						</div>
						<s:if test="#session.user!=null">
							<div class="PX1_mid1_buttom">
								<a href="${pageContext.request.contextPath }/buy?bookid=${book.id}" onclick="buySuccess()">加入购物车</a>
							</div>
						</s:if>
						<s:else>
							<div class="PX1_mid1_buttom">
								<a href="${pageContext.request.contextPath }/buy?bookid=${book.id}">加入购物车</a>
							</div>
						</s:else>
					</div>
				</div>
			</s:iterator>
		</s:if>
		<s:elseif test="#request.cbooks!=null">
			<s:iterator var="book" value="#request.cbooks">
				<div class="PX1_mid1">
					<div class="PX1_mid1z">
						<img src="images/${book.image }">
					</div>
					<div class="PX1_mid1y">
						<div class="PX1_mid1_text">
							<h2><s:property value="#book.name"/> </h2>
							<p class="PX1_mid1_text1"><s:property value="#book.description"/></p>
							<p class="PX1_mid1_text2">作者：<s:property value="#book.author"/></p>
							<h3>￥<s:property value="#book.price"/></h3>
						</div>
						<s:if test="#session.user!=null">
							<div class="PX1_mid1_buttom">
								<a href="${pageContext.request.contextPath }/buy?bookid=${book.id}" onclick="buySuccess()">加入购物车</a>
							</div>
						</s:if>
						<s:else>
							<div class="PX1_mid1_buttom">
								<a href="${pageContext.request.contextPath }/buy?bookid=${book.id}">加入购物车</a>
							</div>
						</s:else>
					</div>
				</div>
			</s:iterator>
		</s:elseif>
	</div>
	<script type="text/javascript">
		function buySuccess() {
			alert("添加成功！");
		}
	</script>
</body>
</html>
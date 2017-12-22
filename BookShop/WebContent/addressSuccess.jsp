<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var i = 5;
	var intervalid;
	intervalid = setInterval("fun()",1000);
	function fun() {
		if(i == 0){
			window.location.href = "userAddress?userid=${user.id}";
			clearInterval(intervalid);
		}
	document.getElementById("mes").innerHTML = i;
	i--
	}
</script>

</head>
<body>
	${message}<br/>
	<p>将在<span id="mes">5</span>秒钟后返回购物车界面！</p>
	<s:a href="userAddress?userid=%{#session.user.id}">点击返回购物车界面</s:a>
</body>
</html>
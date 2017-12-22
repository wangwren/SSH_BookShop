<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var i = 3;
	var intervalid;
	intervalid = setInterval("fun()",1000);
	function fun() {
		if(i == 0){
			window.location.href = "${pageContext.request.contextPath }/login.jsp";
			clearInterval(intervalid);
		}
	document.getElementById("mes").innerHTML = i;
	i--
	}
</script>
</head>
<body>
	注册成功!!!<br/>
	<p>将在<span id="mes">3</span>秒钟后返回登录界面！</p>
	<a href="${pageContext.request.contextPath }/login.jsp">点击返回登录界面</a>
</body>
</html>
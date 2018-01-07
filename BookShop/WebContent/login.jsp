<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<link href="css/index.css" rel="stylesheet" type="text/css" />
<!-- <script src="js/jquery.min.js"></script> -->
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script> --%>
				<script type="text/javascript">
					$(document).ready(function () {
						$('#horizontalTab').easyResponsiveTabs({
							type: 'default', //Types: default, vertical, accordion           
							width: 'auto', //auto or any width like 600px
							fit: true   // 100% fit in a container
						});
					});
</script>

<script type="text/javascript">
					$(document).ready(function () {
						$('#horizontalTab').easyResponsiveTabs({
							type: 'default', //Types: default, vertical, accordion           
							width: 'auto', //auto or any width like 600px
							fit: true   // 100% fit in a container
						});
					});
				   </script>
				   <script type="text/javascript">  
							function insertManager() {
								
								checkName();
								var prompt = $("#userPrompt").val();
								if(prompt != null && prompt !=""){
									return false;
								}
								
							    var password = document.getElementById("password").value;  
							    var repassword = document.getElementById("repassword").value;  
							         if(password!=repassword){  
							             window.alert("您输入的新密码与确认密码确认不一致");  
							             signupForm.repassword.focus();  
							             return false;  
							               
							             }  
							          return true;  
							    }  
					</script> 
<!-- 用户名是否存在验证 -->
<script type="text/javascript">
	function checkName() {
		//获取用户输入的登录名
		var username = $("#username").val();
		//判断，如果用户名为空则进行提示
		//alert(username);
		if(username.trim() == ""){
			$("#userPrompt").html("用户名不能为空");
		}else{
			//登录名不为空，ajax请求，验证数据库中是否存在该登录名
			var url = "${pageContext.request.contextPath }/userCheckName.action";
			//传递登录名参数
			var param = {"user.username" : username};
			$.post(url,param,function(data){
				if(data && data == "no"){
					$("#userPrompt").html("登录名已存在");
				}else{
					$("#userPrompt").html("");
				}
			});
		}
	}
	
</script>

</head>
<body>
<div class="dl">
	<div class="dl1" >
		<div class="main-content">
			<div class="sap_tabs">	
				<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;
">
					<div class="tab" >
						<ul>
							<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>注册</span></li>
							<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>登录</span></li>
						  
						</ul>
					</div>					
					<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
						
						<div class="register "style="margin-top:15px;">
							<form action="userAdd" method="post">											
								<input placeholder="用户名" id="username" name="user.username" class="user" type="text" required="" onblur="checkName()">
                				<SPAN class="user" id="userPrompt" style="FONT-WEIGHT: bold;"></SPAN>
								
								<input placeholder="电子邮箱" name="user.email" class="mess" type="text" required="">
								<input placeholder="手机号" name="user.phone" class="mess" type="text" required="">										
								<input placeholder="密码" id="password" name="user.password"  type="password" required="">	
								<input placeholder="确认密码" id="repassword" name="repassword"  type="password" required="">									
								<input type="hidden" name="user.ulimit" value="2">
								<div class="sign-up">
									<input type="submit" value="Sign Up" onclick="return insertManager()">
								</div>
							</form>

						</div>
					</div>
					<div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
						
						<div class="register">
							<form action="userLogin" method="post">	
								<input placeholder="用户名" name="user.username" class="user" type="text" required="">
								<input placeholder="密码" name="user.password" class="pass" type="password" required="">	
								<span><input type="checkbox" name="Remember">记住密码</span>
								<div class="sign-up">
									<input type="submit" value="Sign In"/>
								</div>
							</form>
							<h3><a href="#">忘记账号或者密码？</a></h3>
						</div>
					</div> 			        					            	      
				</div>	
			</div>
		</div>
	</div>
</div>
</body>
</html>
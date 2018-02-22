<%@ page language="java" import="java.util.*,java.net.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>天津工业大学纺织083</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.form{
      position:absolute;
      top:350px;
      left:500px;
}
</style>
<link href="<%=path %>/resources/css/homepage.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/head.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/foot.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/a.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/homepage.js"></script>
<script type="text/javascript">
window.onload = function(){   
    var foot = getFoot; //引用getFoot函数
    foot();
  };

</script> 
</head>

<body>
	<!--主页开始  -->
	<div class="homepage" style="height:500px;" >
		<!-- head图片开始 -->
		<div class="head">	
		<img src="<%=path %>/resources/images/logo.gif" width="100%" />	
		</div>
		<!-- head图片结束 -->

		<!-- 登陆表单开始 -->
		<div class="form">
            <a href="<%=path %>/Textile083/doLogin.action"><img src="<%=path %>/resources/images/button.jpg" width="50%"/></a>
			</div>
			<!-- 登陆表单结束 -->
			
		<!-- 友情链接 -->
 		<div class="foot" style="top: 525px;">
		</div>  

	</div>
	<!-- 主页结束 -->
</body>
</html>
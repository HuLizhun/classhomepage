<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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

<title>联系我们</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

</style>
<link href="<%=path %>/resources/css/homepage.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/head.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/foot.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/a.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation ul.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation li.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/white.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/textarea.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/search.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/homepage.js"></script>
<script type="text/javascript">
window.onload = function(){
    var head = getHead; //引用getHead函数
    head();  
    
    var search = getSearch; //引用getSearch函数
    search();
    
    var navigation = getNavigation; //引用getNavigation函数
    navigation();
    
    var foot = getFoot; //引用getFoot函数
    foot();
  };
</script>
</head>

<body>

	<!--主页开始  -->
	<div class="homepage">
		<img src="<%=path %>/resources/images/background2.jpg" height="99%" width="100%" />
		<!-- head图片开始 -->
		<div class="head">
		</div>
		<!-- head图片结束 -->
		<div class="welcome">
		<span style="position: absolute; top: 10px; left:20px;color:white;font-size:18px;font-family:Microsoft YaHei;">欢迎${student.name}同学！</span>
		</div> 
		<!-- 搜索标签开始 -->
		<div class="search" style="left: 1080px;">
		</div>
		<!-- 搜索标签结束 -->

		<!-- 输入文档 -->
		<div class="textarea">
			<p style="font-size:18px;font-family:Microsoft YaHei;">
			 地址：天津市西青区宾水西道399号<br><br>
			 电话：15122526195<br><br>
			 邮箱：<a href="mailto:hulizhun529907083@126.com">hulizhun529907083@126.com</a><br><br>
			 联系人：胡立准
			</p>
		</div>

		<!-- 左边导航栏开始 -->
		<div class="navigation">
		</div>
		<!-- 左边导航栏结束 -->

		<!-- 友情链接 -->
		<div class="foot">
		</div>
	</div>
	<!-- 主页结束 -->
</body>
</html>

<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style type="text/css"></style>
<link href="<%=path %>/resources/css/homepage.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/head.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/update.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/photo.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/liberature.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/introduce.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/foot.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/a.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/white.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/table.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/table tr.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/table div.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation ul.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation li.css" rel="stylesheet" type="text/css" />
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
    
    var update = getUpdate; //引用getUpdate函数
    update();
    
    var photo = getPhoto; //引用getUpdate函数
    photo();
    
    var introduce = getIntroduce; //引用getIntroduce函数
    introduce();
  };

</script>
</head>

<body style="overflow-y:visible;overflow-x:hidden">
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

		<!-- 左边导航栏开始 -->
		<div class="navigation">
		</div>
		<!-- 左边导航栏结束 -->

		<!-- update开始 -->
		<div class="update">
		</div>
		<!-- update结束 -->

		<!-- 相册开始 -->
		<div class="photo">

		</div>
		<!-- 相册结束 -->

		<!-- 文学开始 -->
		<div class="liberature">
			<a href="<%=path %>/Textile083/liberature.action" target="_blank" title="点击进入班级文学">班级文学</a><br>
			<div>
				<table>
				 <c:forEach items="${articleList1}" var="article" >		  
					<tr>
						<td style=" width:400px;"><div><a href="<%=path %>/Textile083/queryArticleByTitle.action?title=${article.title}" target="_blank">${article.title}</a></div></td>
						<td><div>${article.name}</div></td>
					</tr>
				 </c:forEach>
				</table>
			</div>
		</div>
		<!-- 文学结束 -->

		<!-- 简介开始 -->
		<div class="introduce">

		</div>
		<!-- 简介结束 -->

		<!-- 友情链接 -->
		<div class="foot">
		</div>
	</div>
	<!-- 主页结束 -->
</body>
</html>

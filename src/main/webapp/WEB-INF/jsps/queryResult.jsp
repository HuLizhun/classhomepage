<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.textile083.entity.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>班级文学</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
td div {
	height: 28px;
	font-size: 12px;
	width: 400px;
}

.fix {
	clear: both;
	zoom: 1;
}

.fix:after {
	display: block;
	clear: both;
	height: 0;
	overflow: hidden;
	visibility: hidden;
	content: ".";
}

.first {
	float: right;
	height: 18px;
	padding-left: 25px;
	background: url(../images/icon.png) no-repeat;
	color: #dbdbdb;
}
</style>
<link href="<%=path%>/resources/css/homepage.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/head.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/navigation.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/foot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/a.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/navigation ul.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/navigation li.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/white.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/class_liberature.css"
	rel="stylesheet" type="text/css" />
<link href="<%=path%>/resources/css/table tr.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/table div.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/resources/css/search.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/homepage.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var head = getHead; //引用getHead函数
		head();

		var search = getSearch; //引用getSearch函数
		search();

		var navigation = getNavigation; //引用getNavigation函数
		navigation();

		var foot = getFoot; //引用getFoot函数
		foot();
	};
    $(document).ready(function(){
       //点击链接的时候调用
      $("#go").click(function(){
 
          //得到currentPageText的值
          var currentPage = $("#currentPageText").val();
 
          //设置go的href的值
          $("#go").attr("href","<%=path %>/Textile083/liberature.action?currentPage="+currentPage);
      });
    });
</script>
</head>

<body>

	<!--主页开始  -->
	<div class="homepage">
		<img src="<%=path%>/resources/images/background2.jpg" height="98%" width="100%" />
		<!-- head图片开始 -->
		<div class="head"></div>
		<!-- head图片结束 -->
		<div class="welcome">
			<span
				style="position: absolute; top: 10px; left: 20px; color: white; font-size: 18px; font-family: Microsoft YaHei;">欢迎${user.name}同学！</span>

			<!-- 搜索标签开始 -->
			<div class="search" style="left: 80.5%;"></div>
			<!-- 搜索标签结束 -->

			<!-- introduce -->
			<div class="class_liberature">
				<h1>班级文学</h1>
				<a href="<%=path%>/Textile083/skip.action?name=write"
					target="_blank" title="点击进入班级文学"> <input type="submit"
					value="写文章" /></a> <a
					href="<%=path%>/Textile083/queryMyArtilce.action" target="_blank"
					title="点击进入班级文学"> <input type="submit" value="我的文章" /></a>
				<div><br>
					<table border="1px solid #000" cellspacing="0" style="text-align: center;">
								   <tr>
			      <th>序列</th>
			      <th style="width: 250px">标题</th> 
			      <th style="width:100px">作者</th>
			      <th>操作</th>			      
			   </tr>
						<c:forEach items="${articleList}" var="article" varStatus="status">
							<tr>
							<td style="position: ">
										${status.count}
									</td>
								<td style="text-align: left;">
										<a
											href="<%=path %>/Textile083/queryArticleByTitle.action?title=${article.title}">${article.title}</a>
									</td>
								<td>${article.name}</td>
								<c:forEach items="${permissionList}" var="permission">
								   <c:if test="${permission.url=='/Textile083/skip.action?name=delete'}">
								         <td><a href="<%=path %>/Textile083/deleteArticleById.action?id=${article.id}" onclick="confirm('确认删除吗？')" >删除</a></td>
								   </c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>


			<!-- 左边导航栏开始 -->
			<div class="navigation"></div>
			<!-- 左边导航栏结束 -->

			<!-- 友情链接 -->
			<div class="foot"></div>
		</div>
	</div>
	<!-- 主页结束 -->
</body>
</html>

<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<img src="<%=path%>/resources/images/background2.jpg" height="99%" width="100%" />
		<!-- head图片开始 -->
		<div class="head"></div>
		<!-- head图片结束 -->
		<div class="welcome">
			<span
				style="position: absolute; top: 10px; left: 20px; color: white; font-size: 18px; font-family: Microsoft YaHei;">欢迎${student.name}同学！</span>

			<!-- 搜索标签开始 -->
			<div class="search" style="left: 1080px;"></div>
			<!-- 搜索标签结束 -->

			<!-- introduce -->
			<div class="class_liberature">
				<h1>班级文学</h1>
				<a href="<%=path%>/Textile083/skip.action?name=write"
					target="_blank" title="点击进入班级文学"> <input type="submit"
					value="写文章" /></a> <a
					href="<%=path%>/Textile083/queryMyArtilce.action" target="_blank"
					title="点击进入班级文学"> <input type="submit" value="我的文章" /></a>
				<div>
					<table>
						<c:forEach items="${articleList}" var="article">
							<tr>
								<td><div>
										<a
											href="<%=path %>/Textile083/queryArticleByTitle.action?title=${article.title}">${article.title}</a>
									</div></td>
								<td><div>${article.name}</div></td>
							</tr>
						</c:forEach>
					</table>
				</div>
							<div class='page fix'>
				共 <b>${page.totalNumber}</b> 条
				<c:if test="${page.currentPage !=1 }">
					<a href="<%=path %>/Textile083/liberature.action?currentPage=1" class='first'>首页</a>
					<a href="<%=path %>/Textile083/liberature.action?currentPage=${page.currentPage-1}"
						class='pre'>上一页</a>
				</c:if>
				当前第<span>${page.currentPage}/${page.totalPage}</span>页
				<c:if test="${page.currentPage!=page.totalPage}">
					<a href="<%=path %>/Textile083/liberature.action?currentPage=${page.currentPage+1}"
						class='next'>下一页</a>
					<a href="<%=path %>/Textile083/liberature.action?currentPage=${page.totalPage}"
						class='last'>末页</a>
				</c:if>
				跳至&nbsp;<input id="currentPageText" type='text' value='${page.currentPage}' style="width:40px" />&nbsp;页&nbsp;
							<a href=""  id="go">GO</a>
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

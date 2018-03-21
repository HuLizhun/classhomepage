<%@ page language="java" import="java.util.*,java.util.ArrayList" contentType="text/html; charset=utf-8"%>
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

<title>班级简介</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table tr{
	line-height:18px;
}
table div{
	line-height:30px;
	font-size:15px;
	text-align:center;
	margin:0;
}

</style>
<link href="<%=path %>/resources/css/homepage.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/head.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/foot.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/a.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation ul.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/navigation li.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/white.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/css/class_introduce.css" rel="stylesheet" type="text/css" />
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
    
    var introduce = getClassIntroduce; //引用getIntroduce函数
    introduce();
  };

</script>
</head>

<body>

	<!--主页开始  -->
	<div class="homepage">
		<img src="<%=path %>/resources/images/background2.jpg" height="98%" width="100%" />
		<!-- head图片开始 -->
		<div class="head">
		</div>
		<!-- head图片结束 -->
   		<div class="welcome">
		<span style="position: absolute; top: 10px; left:20px;color:white;font-size:18px;font-family:Microsoft YaHei;">欢迎${student.name}同学！</span>
		</div> 		
		<!-- 搜索标签开始 -->
		<div class="search" style="left: 80.5%;">
		</div>
		<!-- 搜索标签结束 -->

		<!-- introduce -->
		<div class="class_introduce">
		   <div class="class_introduce1"></div>
			<table width="500px" border="1px solid #000" cellspacing="0">
			   <tr>
			      <th>序列</th>
			      <th>学号</th>
			      <th>性别</th>
			      <th>姓名</th>			      
			   </tr>
			   
			   	<c:forEach items="${studentList}" var="student" >
			    	<tr>
			          <td><div>${student.id}</div></td>
			          <td><div>${student.number}</div></td>
			          <td><div>${student.sex}</div></td>
			          <td><div>${student.name}</div></td>			      
			       </tr>		  
			   </c:forEach>
			</table>
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

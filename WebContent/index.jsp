<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取网站路径，例如这里获取的是/StrutsTest1
	//获取网站路径，例如这里获取的事http://localhost:8080//StrutsTest1
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试</title>
</head>
<script src="<%=basePath%>js/jquery-1.12.0.js"></script>
<script src="<%=basePath%>js/jquery_ajax_json_home.js"></script>
<body>

	<div class="is_login"></div>



</body>
</html>
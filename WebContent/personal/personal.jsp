<%@page import="com.onlineTest.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User user = (User) session.getAttribute("User");
	pageContext.setAttribute("User", user);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<script src="<%=basePath%>js/jquery-1.12.0.js"></script>
<script src="<%=basePath%>js/jquery_ajax_json_personal.js"></script>
<body>
	<div class="user-information-menu">
	
	</div>
	<div class="user-information-content">
		
	</div>



</body>
</html>
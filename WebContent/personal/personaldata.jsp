<%@page import="com.onlineTest.bean.Teacher"%>
<%@page import="com.onlineTest.bean.Student"%>
<%@page import="com.onlineTest.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("User");
	String content = null;
	content = "<ul id='menu'>";
	if (user instanceof Student) {
		content += "<li onclick='loadInfor(this)'>基本信息</li>";
		content += "<li onclick='loadInfor(this)'>选课</li>";
		content += "<li onclick='loadInfor(this)'>考试</li>";
		content += "<li onclick='loadInfor(this)'>查看成绩</li>";

	} else if (user instanceof Teacher) {
		content += "<li onclick='loadInfor(this)'>基本信息</li>";
		content += "<li onclick='loadInfor(this)'>查看选课学生</li>";
		content += "<li onclick='loadInfor(this)'>改卷</li>";

	}
	content += "</ul>";

	out.print("{\"content\":\"" + content + "\"}");
%>
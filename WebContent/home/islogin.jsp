<%@page import="com.onlineTest.bean.User"%>
<%@page import="com.onlineTest.bean.Customer"%>
<%@page import="com.onlineTest.bean.Teacher"%>
<%@page import="com.onlineTest.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//获取登录成功后的对象,通过session对象获取key值User的 
	//Student student = (Student) session.getAttribute("User");
	//Teacher teacher = (Teacher) session.getAttribute("User_teacher");
	User user = (User) session.getAttribute("User");
	String content = null;
	if (user == null) {//说明没有登录
		content = "<a href='login/login.jsp'>登录</a>";
	} else {
		//content = "<a href='personal/personal.jsp'>" + student.getName() + "</a>";
		content = "<a href='personal/personal.jsp'>" + user.getName() + "</a>";
		//如果user是学生类创建的那么返回为真
		/**if(user instanceof Student){
			content = "<a href='personal/personal.jsp'>" + student.getName() + "</a>";
		}*/

	}

	out.print("{\"content\":\"" + content + "\"}");
%>







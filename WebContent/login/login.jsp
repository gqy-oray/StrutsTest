<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入struts标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 使网页中，所有地址，默认为指定地址 -->
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="userLogin" method="post">
		<!-- 注意对应的action类中应该有一个customer的成员变量，并且实例化中包含id,password,career三个属性 -->
		登录帐号<input type="text" name="customer.id"><br /> 登录密码<input
			type="password" name="customer.password"><br /> <input
			type="radio" name="customer.career" value="student" checked="checked">学生
		<input type="radio" name="customer.career" value="teacher">老师<br />
		<input type="submit" value="登录">
	</form>


		<!-- 使用struts表单，配合struts校验 -->

	<s:form action="userLogin" method="post">
		<s:textfield name="customer.id" label="登录帐号"></s:textfield>
		<s:textfield name="customer.password" label="登录密码"></s:textfield>
		<s:radio name="customer.career"
			list="#{'student':'学生','teacher':'老师' }" value="'student'"></s:radio>
		<s:submit value="登录"></s:submit>
	</s:form>
	
	<!-- 使用国际化完成表单 -->
	<s:form action="userLogin" method="post">
		<s:textfield name="customer.id" key="customer.id.text"></s:textfield>
		<s:password name="customer.password" key="customer.password.text"></s:password>
		<s:radio name="customer.career" list="#{'student':'学生','teacher':'老师' }" value="student"></s:radio>
		<s:submit key="btn.submit"></s:submit>
	</s:form>
	<s:text name="login.page.title"></s:text>
	
<!-- 

	<s:form action="regist" method="post">
		<s:textfield name="registered.id" label="注冊帐号"></s:textfield>
		<s:textfield name="registered.password" label="注册密码"></s:textfield>
		<s:password name="registered.rePass" label="确认密码"></s:password>
		<s:radio name="registered.career"
			list="#{'student':'学生','teacher':'老师' }" value="student"></s:radio>
		<s:submit value="注册"></s:submit>
	</s:form>
	-->
</body>
</html>
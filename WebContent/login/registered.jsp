<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="regist" method="post">
	<s:textfield name="registered.id" label="注冊帐号"></s:textfield>
	<s:textfield name="registered.password" label="注册密码"></s:textfield>
	<s:textfield name="registered.rePass" label="确认密码"></s:textfield>
	<s:radio name="registered.career" list="#{'student':'学生','teacher':'老师' }" value="student" ></s:radio>
	<s:submit value="注册"></s:submit>
</s:form>
<s:form action="userLogin" method="post">
		<s:textfield name="customer.id" key="customer.id.text"></s:textfield>
		<s:password name="customer.password" key="customer.password.text"></s:password>
		<s:radio name="customer.career" list="#{'student':'学生','teacher':'老师' }" value="student"></s:radio>
		<s:submit key="btn.submit"></s:submit>
	</s:form>

</body>
</html>
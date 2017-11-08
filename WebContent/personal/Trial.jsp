<%@page import="com.opensymphony.xwork2.util.finder.Test"%>
<%@page import="com.onlineTest.bean.Course"%>
<%@page import="com.onlineTest.service.impl.CourseServiceImpl"%>
<%@page import="com.onlineTest.service.CourseService"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineTest.service.impl.ChoiceQuestionServiceImpl"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.onlineTest.bean.ChoiceQuestion"%>
<%@page import="com.onlineTest.service.ChoiceQuestionService"%>
<%@page import="com.onlineTest.bean.TestPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	WebApplicationContext wac = WebApplicationContextUtils
			.getWebApplicationContext(session.getServletContext());
//获取考试试卷
TestPage testPage=(TestPage)session.getAttribute("Page");
	//TestPage Page = (TestPage) request.getAttribute("Page");
	ChoiceQuestionService<ChoiceQuestion> cqs = wac.getBean("ChoiceQuestionService",
			ChoiceQuestionServiceImpl.class);
	List<ChoiceQuestion> list = cqs.findChoiceQuestion("from ChoiceQuestion where course=?0", testPage.getCourse());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷</title>
</head>
<body>
	<h3>一、选择题，每题两分，十题，共20分</h3>
	<%
		for (int i = 0; i < 10 && list.size() > 0; i++) {
			int index = (int) Math.random() * list.size();
			ChoiceQuestion cq = list.get(index);
			list.remove(index);
			out.println((i + 1) + "." + cq.getTitle());
	%></br>
	<input type="radio" name="<%=cq.getId()%>" value="<%=cq.getId()%>">
	<%
		out.print(cq.getChoiceA());
	%></br>
	<input type="radio" name="<%=cq.getId()%>" value="<%=cq.getId()%>">
	<%
		out.print(cq.getChoiceB());
	%></br>
	<input type="radio" name="<%=cq.getId()%>" value="<%=cq.getId()%>">
	<%
		out.print(cq.getChoiceC());
	%></br>
	<input type="radio" name="<%=cq.getId()%>" value="<%=cq.getId()%>">
	<%
		out.print(cq.getChoiceD());
	%></br>

	<%
		}
	%>




</body>
</html>
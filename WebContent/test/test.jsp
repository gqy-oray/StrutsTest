<%@page import="com.onlineTest.bean.JudgleQuestion"%>
<%@page import="com.onlineTest.service.impl.JudgleQuesrionServiceImpl"%>
<%@page import="com.onlineTest.service.JudgleQuesrionService"%>
<%@page import="com.onlineTest.service.impl.FillQuestionServiceImpl"%>
<%@page import="com.onlineTest.service.FillQuestionService"%>
<%@page import="com.onlineTest.bean.FillQuestion"%>
<%@page import="com.onlineTest.bean.ChoiceQuestion"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineTest.service.impl.ChoiceQuestionServiceImpl"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.onlineTest.service.ChoiceQuestionService"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>

<%@page import="com.onlineTest.bean.TestPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入自定义标签 -->
<%@ taglib prefix="mytaglib" uri="http://tomcat.apache.org/mytaglib"%>
<%
	TestPage testPage = (TestPage) session.getAttribute("Page");
	//TestPage Page = (TestPage) request.getAttribute("Page");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//获取applicationContext.xml文件；
	WebApplicationContext wac = WebApplicationContextUtils
			.getWebApplicationContext(session.getServletContext());
	//
	ChoiceQuestionService choiceQuestionService = wac.getBean("ChoiceQuestionService",
			ChoiceQuestionServiceImpl.class);
	List<ChoiceQuestion> choiceList = choiceQuestionService
			.findChoiceQuestion("from ChoiceQuestion where course=?0", testPage.getCourse());

	//
	FillQuestionService fillQuestionService = wac.getBean("FillQuestionService", FillQuestionServiceImpl.class);
	List<FillQuestion> fillQuestions = fillQuestionService.findFillQuestion("from FillQuestion where course=?0",
			testPage.getCourse());

	//将填空题存放在当前页面
	pageContext.setAttribute("listFill", fillQuestions);

	//
	JudgleQuesrionService judgleQuesrionService = wac.getBean("JudgleQuesrionServiceImpl",
			JudgleQuesrionServiceImpl.class);
	List<JudgleQuestion> judglist = judgleQuesrionService.find("from JudgleQuestion where course=?0",
			testPage.getCourse());
	//
	pageContext.setAttribute("listJudg", judglist);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试页面</title>
</head>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.12.0.js">
	
</script>
<body>
	<h2>一、选择题，每题两分，十题共20分</h2>
	<%
		for (int i = 1; i <= 10; i++) {
			int index = (int) (Math.random() * choiceList.size());
			ChoiceQuestion cq = choiceList.get(index);
			choiceList.remove(index);//删除链表中已加载的题目
			out.print(i + "." + cq.getTitle() + "</br>");
			String an=cq.getAnswer();
	%>
	<div id="Choice">
		<input type="radio" name="<%=cq.getId()%>" value="A">
		<%
			out.print(cq.getChoiceA());
		%></br> <input type="radio" name="<%=cq.getId()%>" value="B">
		<%
			out.print(cq.getChoiceB());
		%></br> <input type="radio" name="<%=cq.getId()%>" value="C">
		<%
			out.print(cq.getChoiceC());
		%></br> <input type="radio" name="<%=cq.getId()%>" value="D" id="<%=cq.getAnswer() %>>"> 
		<%
			out.print(cq.getChoiceD());
			
		%></br>
			<p >你的答案是</p>
			<h5 id="h5"></h5>
		<%
			}
		%>
	</div>
	<script type="text/javascript">
			$(document).ready(function() {
				$("#Choice > input").click(function() {
					var ch=$("input[type='radio']:checked").val();
					
					var obj1=document.getElementsByName("id");
				console.log("jqury     " + $("input[type='radio']:checked").val());
				for(var i = 0; i < obj1.length; i++) {
					
					if(obj1[i].checked) {

						console.log("通过标签" + obj1[i].value);
					

						}}
			//	console.log($("input[id='an']:checked").val());
				});
			});
		</script>




	<h2>二、填空题，每题两分，十题共20分</h2>
	<!-- collection是标签类中的属性，值等于上面存放填空题的链表 -->
	<mytaglib:fillQuestion collection="listFill" />
	<h2>三、判断题，每题两分，十题共20分</h2>
	<mytaglib:judgQuestion collectionJu="listJudg" />
</body>
</html>
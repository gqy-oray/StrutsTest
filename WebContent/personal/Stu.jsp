<%@page import="com.onlineTest.service.impl.JudgleQuesrionServiceImpl"%>
<%@page import="com.onlineTest.bean.JudgleQuestion"%>
<%@page import="com.onlineTest.service.JudgleQuesrionService"%>
<%@page import="com.onlineTest.service.impl.FillQuestionServiceImpl"%>
<%@page import="com.onlineTest.bean.FillQuestion"%>
<%@page import="com.onlineTest.service.FillQuestionService"%>
<%@page import="org.apache.catalina.ant.FindLeaksTask"%>
<%@page import="com.onlineTest.bean.TestPage"%>
<%@page import="com.onlineTest.service.impl.TestPageServiceImpl"%>
<%@page import="com.onlineTest.service.TestPageService"%>
<%@page import="com.onlineTest.service.impl.ChoiceQuestionServiceImpl"%>
<%@page import="com.onlineTest.bean.ChoiceQuestion"%>
<%@page import="com.onlineTest.service.ChoiceQuestionService"%>
<%@page import="com.onlineTest.service.impl.QuestionServiceImpl"%>
<%@page import="com.onlineTest.service.QuestionService"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineTest.bean.Course"%>
<%@page import="com.onlineTest.service.impl.CourseServiceImpl"%>
<%@page import="com.onlineTest.service.CourseService"%>
<%@page import="com.onlineTest.service.impl.LoginServiceImpl"%>
<%@page import="com.onlineTest.bean.Student"%>
<%@page import="com.onlineTest.service.LoginService"%>
<%@page import="com.onlineTest.bean.Score"%>
<%@page import="com.onlineTest.service.impl.AllServiceImpl"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.onlineTest.bean.Question"%>
<%@page import="com.onlineTest.service.AllService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	WebApplicationContext wac = WebApplicationContextUtils
			.getWebApplicationContext(session.getServletContext());
	Score score = (Score) session.getAttribute("score");
	LoginService<Student> stu = wac.getBean("LoginServiceImpl", LoginServiceImpl.class);
	Student snso = stu.login(Student.class, score.getStudent().getId());

	CourseService<Course> courseService = wac.getBean("CourseServiceImpl", CourseServiceImpl.class);
	Course ccid = courseService.find(Course.class, score.getCourse().getId());

	String hqla = "from Question where questionKey.pageId=(select id from TestPage where student=?0 and course=?1)";
	String hql = "from TestPage where student=?0 and course=?1";
	TestPageService te = wac.getBean("TestPageService", TestPageServiceImpl.class);
	List<TestPage> tep = te.find(hql, snso, ccid);
	for (int i = 0; i < tep.size(); i++) {
		TestPage testpage = tep.get(i);
		out.print(testpage.getId() + "  ");
	}
	QuestionService<Question> questionService = wac.getBean("QuestionService", QuestionServiceImpl.class);
	List<Question> questions = questionService.find(hqla, snso, ccid);
	out.print(questions.size() + " " + score.getStudent().getId() + " " + score.getCourse().getId());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>学生考试情况</h2>

	<%
		String content = null;
		int count = 1;
		for (int i = 0; i < questions.size(); i++) {
			Question q = questions.get(i);
			switch (q.getType()) {
			case 1:
				if (i % 10 == 0) {
					out.print("<h3>一、选择题（每题2分，10题，共20分）</h3>");
				}
				ChoiceQuestionService<ChoiceQuestion> choice = wac.getBean("ChoiceQuestionService",
						ChoiceQuestionServiceImpl.class);
				String hql1 = "from ChoiceQuestion where id=?0";
				List<ChoiceQuestion> cqs = choice.findChoiceQuestion(hql1, q.getQuestionKey().getQuestionId());
				if (questions.size() == 0) {
					return;
				}
				ChoiceQuestion cq = cqs.get(0);
				out.print(count + "." + cq.getTitle() + "</br>");
				out.print(cq.getChoiceA() + "</br>");
				out.print(cq.getChoiceB() + "</br>");
				out.print(cq.getChoiceC() + "</br>");
				out.print(cq.getChoiceD() + "</br>");
				if (cq.getAnswer().equals(q.getAnswer())) {
					out.print("正确：\t答案是：" + cq.getAnswer() + "\t你的答案是：" + q.getAnswer() + "" + "</br>");
				} else {
					out.print("錯誤：\t答案是：" + cq.getAnswer() + "\t你的答案是：" + q.getAnswer() + "" + "</br>");
				}
				count++;
				break;
			case 2:
				if (i % 10 == 0) {
					out.println("<h3>二、填空题（每题2分，10题，共20分）</h3>");
				}
				int count1 = 1;
				String hqlFill = "from FillQuestion where id=?0";
				FillQuestionService<FillQuestion> fillQuest = wac.getBean("FillQuestionService",
						FillQuestionServiceImpl.class);
				List<FillQuestion> fill = fillQuest.findFillQuestion(hqlFill, q.getQuestionKey().getQuestionId());
				FillQuestion fq = fill.get(0);
				out.println(count1 + "." + fq.getTitle() + "</br>");
				if (fq.getAnswer().equals(q.getAnswer())) {
					out.println("正确：\t答案是：" + fq.getAnswer() + "\t你的答案是：" + q.getAnswer() + "</br>");
				} else {
					out.println("错误：\t答案是：" + fq.getAnswer() + "\t你的答案是：" + q.getAnswer() + "</br>");
				}
				count1++;
				break;
			case 3:
				if (i % 10 == 0) {
					out.println("<h3>三、判断题（每题2分，10题，共20分）</h3>");
				}
				int count2 = 1;
				String hqlJudg = "from JudgleQuestion where id=?0";
				JudgleQuesrionService<JudgleQuestion> judgQuest = wac.getBean("JudgleQuesrionServiceImpl",
						JudgleQuesrionServiceImpl.class);
				List<JudgleQuestion> judg = judgQuest.find(hqlJudg, q.getQuestionKey().getQuestionId());
				JudgleQuestion jq = judg.get(0);
				out.println(count2 + "." + jq.getTitle() + "</br>");
				if (jq.getAnswer().equals(q.getAnswer())) {
					out.println("正确：\t答案是：" + jq.getAnswer() + "\t你的答案是：" + q.getAnswer() + "</br>");
				} else {
					out.println("错误：\t答案是：" + jq.getAnswer() + "\t你的答案是：" + q.getAnswer() + "</br>");
				}
				count2++;
				break;// 判断题
			}
		}
	%>





</body>
</html>
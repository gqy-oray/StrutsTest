<%@page import="com.onlineTest.service.ScoreService"%>
<%@page import="com.onlineTest.service.impl.ScoreServiceImpl"%>
<%@page import="com.onlineTest.bean.Score"%>
<%@page import="com.onlineTest.service.CourseService"%>
<%@page import="com.onlineTest.service.impl.CourseServiceImpl"%>
<%@page import="com.onlineTest.bean.Course"%>
<%@page import="java.util.List"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.onlineTest.bean.Teacher"%>
<%@page import="com.onlineTest.bean.Student"%>
<%@page import="com.onlineTest.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	WebApplicationContext wac = WebApplicationContextUtils
	.getWebApplicationContext(session.getServletContext());
	String name = request.getParameter("name");
	name = new String(name.getBytes("iso8859-1"), "UTF-8");
	User user = (User) session.getAttribute("User");
	String content = null;
	if (name.equals("基本信息")) {
		content = "<h2>基本信息</h2>";
		if (user instanceof Student) {
	content += "学号:" + user.getId() + "</br>";
		} else if (user instanceof Teacher) {
	content += "教师编号:" + user.getId() + "</br>";
		}
		content += "姓名:" + user.getName() + "</br>";
		content += "性别:" + user.getSex() + "</br>";
		content += "课程:" + user.getDepart().getId() + "</br>";
		content += "电话:" + user.getPhone() + "</br>";
		content += "邮箱:" + user.getEmail() + "</br>";

	} else if (name.equals("选课")) {
		CourseService service = wac.getBean("CourseServiceImpl", CourseServiceImpl.class);
		String hql = "from Course where depart=?0 and id not in(select scoreKey.courseId from Score where student=?1 )";
		//String hql="from Course where depart=?0";
		List<Course> list = service.findHqlCurse(hql, user.getDepart(), user);
		content = "<h2>你可以选择的课程如下所示</h2>";
		content += "<form action='choesCourse' method='post' >";
		content += "<table border='1'>";
		content += "<tr><td>选课</td><td>课程编号</td><td>课程名称</td><td>学分</td><td>院系名字</td><td>任课老师</td></tr>";
		for (int i = 0; i < list.size(); i++) {
	Course c = list.get(i);
	content += "<tr>";
	content += "<td><input type='checkbox' name='courses' value='" + c.getId() + "'></td>";
	content += "<td>" + c.getId() + "</td>";
	content += "<td>" + c.getName() + "</td>";
	content += "<td>" + c.getCredit() + "</td>";
	content += "<td>" + c.getDepart().getName() + "</td>";
	content += "<td>" + c.getTeacher().getName() + "</td>";
	content += "</tr>";
		}

		content += "<tr><td colspan='6'> <input type='submit' value='提交'>   </td></tr>";

		content += "</table></form>";
		//content+="<h2>请输入你想学的课程编号,输入e表示结束选课</h2>";

	} else if (name.equals("考试")) {
		CourseService service = wac.getBean("CourseServiceImpl", CourseServiceImpl.class);
		//String hql = "from Score where student=?0 and course not in(select course from TestPage where student=?1)";
		String hql = "from Course where id in(select scoreKey.courseId from Score where student=?0)";
		content = "<h2>你可以考试的课程如下所示</h2>";
		content += "<form action='closeScore' method='post'>";
		content += "<table border='1'>";
		List<Course> list = service.findHqlCurse(hql, user);
		if (list.size() > 0) {
	content += "<tr><td>课程编号</td><td>课程名字</td></tr>";
	for (int i = 0; i < list.size(); i++) {
		Course c = list.get(i);
		content += "<tr>";
		content += "<td><input type='radio' name='courses' value='" + c.getId() + "'></td>";
		content += "<td>" + c.getName() + "</td>";
		content += "</tr>";
	}
	content += "<tr><td colspan='2'><input type='submit' value='提交'></td></tr>";
		} else {
	content += "<h4>你选的课程，已经考试过了，请重新选课</h4>";
		}

		content += "</table></form>";
	} else if (name.equals("查看选课学生")) {
		content = "<h2>查看选课学生</h2>";
		String hql = "from Score where cid in (select id from Course where teacher=?0 )";
		ScoreService service = wac.getBean("ScoreServiceImpl", ScoreServiceImpl.class);
		content += "<table border='1'>";
		List<Score> list = service.findHql(hql, user);
		content += "<tr><td>学生编号</td><td>学生姓名</td><td>性别</td><td>所选课程</td><td>联系电话</td><td>邮箱</td><td>院系</td></tr>";
		if (list.size() > 0) {
	for (int i = 0; i < list.size(); i++) {
		Score s = list.get(i);
		content += "<tr>";
		content += "<td>" + s.getStudent().getId() + "</td>";
		content += "<td>" + s.getStudent().getName() + "</td>";
		content += "<td>" + s.getStudent().getSex() + "</td>";
		content += "<td>" + s.getCourse().getName() + "</td>";
		content += "<td>" + s.getStudent().getPhone() + "</td>";
		content += "<td>" + s.getStudent().getEmail() + "</td>";
		content += "<td>" + s.getStudent().getDepart().getName() + "</td>";
		content += "</tr>";
	}
		}
		content += "</table>";
	} else if (name.equals("改卷")) {
		content = "<h2>改卷</h2>";
		String hql = "from Score where cid in (select id from Course where teacher=?0 )";
		ScoreService service = wac.getBean("ScoreServiceImpl", ScoreServiceImpl.class);
		content += "<form action='closeTeaScore' method='post'>";
		content += "<table border='1'>";
		List<Score> list = service.findHql(hql, user);
		content += "<tr><td>学生编号</td><td>学生姓名</td><td>课程编号</td><td>所选课程</td></tr>";
		if (list.size() > 0) {
	for (int i = 0; i < list.size(); i++) {
		Score s = list.get(i);
		content += "<tr>";
		content += "<td><input type='radio' name='scores' value='" + s.getStudent().getId()	+ "' ></td>";
		content += "<td>" + s.getStudent().getName() + "</td>";
		content += "<td><input type='checkbox' name='cid' value='" + s.getCourse().getId()	+ "' ></td>";
		content += "<td >" + s.getCourse().getName() + "</td>";
		content += "</tr>";
	}
		}
		content += "<tr><td colspan='4'><input type='submit' value='提交'></td></tr>";
		content += "</table></form>";
	}
	out.print("{\"content\":\"" + content + "\"}");
%>
package com.onlineTest.action;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;

import com.onlineTest.bean.Course;
import com.onlineTest.bean.Score;
import com.onlineTest.bean.ScoreKey;
import com.onlineTest.bean.Student;
import com.onlineTest.bean.User;
import com.onlineTest.service.ScoreService;
import com.opensymphony.xwork2.ActionSupport;

public class CloseCourseAction extends ActionSupport {
	private ScoreService<Score> scoreService;
	private String[] Courses;// 表单中复选框name的值;存放的是已经选中的复选框的value值组成的数据

	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("User");// 获取当前登录的学生对象

		for (int i = 0; i < Courses.length; i++) {
			ScoreKey scoreKey = new ScoreKey(user.getId(), Courses[i]);
			Score score = new Score();
			score.setScoreKey(scoreKey);
			scoreService.scoreinsert(score);
		}
		return SUCCESS;
	}

	public ScoreService<Score> getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService<Score> scoreService) {
		this.scoreService = scoreService;
	}

	public String[] getCourses() {
		return Courses;
	}

	public void setCourses(String[] courses) {
		Courses = courses;
	}

}

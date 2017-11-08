package com.onlineTest.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.onlineTest.bean.Course;
import com.onlineTest.bean.Score;
import com.onlineTest.bean.Student;
import com.onlineTest.service.AllService;
import com.onlineTest.service.CourseService;
import com.onlineTest.service.LoginService;
import com.onlineTest.service.ScoreService;
import com.opensymphony.xwork2.ActionSupport;

public class closeTeaScore<T> extends ActionSupport {
	private ScoreService<Score> scoreService;
	private LoginService<Student> loginService;
	private CourseService<Course> courseService; 
	private String scores;
	private String cid;

	@Override
	public String execute() throws Exception {
		Student student = loginService.login(Student.class, scores);
		HttpSession session = ServletActionContext.getRequest().getSession();
		 Course course=courseService.find(Course.class, cid);
		List<Score> scores = scoreService.findHql("from Score where student=?0 and course=?1", student,course);
		Score score = null;
		if (scores != null) {
			for (int i = 0; i < scores.size(); i++) {
				score = scores.get(i);

				session.setAttribute("score", score);
			}

			return SUCCESS;
		}
		return INPUT;
	}

	public ScoreService<Score> getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService<Score> scoreService) {
		this.scoreService = scoreService;
	}

	public LoginService<Student> getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService<Student> loginService) {
		this.loginService = loginService;
	}
	

	public CourseService<Course> getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService<Course> courseService) {
		this.courseService = courseService;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}

package com.onlineTest.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.onlineTest.bean.Course;
import com.onlineTest.bean.Student;
import com.onlineTest.bean.TestPage;
import com.onlineTest.bean.User;
import com.onlineTest.service.CourseService;
import com.onlineTest.service.ScoreService;
import com.onlineTest.service.TestPageService;
import com.onlineTest.service.impl.TestPageServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CloseScoreActioin<T> extends ActionSupport {
	private TestPageService<TestPage> testPageService;
	private CourseService<Course> courseService;
	private String courses;

	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("User");
		Course course=courseService.find(Course.class, courses);
		List<TestPage> testPages =testPageService.find("from TestPage where student=?0 and course=?1", user,course);
		TestPage testPage=null;
		if(testPages==null&&testPages.size()==0){
			testPage.setStudent((Student) user);
			testPage.setCourse(course);
			testPageService.createPage(testPage);
		}else{
			testPage=testPages.get(0);
			
		}
		
		
		//= new TestPage();
		
		
		session.setAttribute("Page", testPage);
		//ServletActionContext.getRequest().setAttribute("Page", );
//		System.out.println("试卷生成成功");
		
		return SUCCESS;
	}

	public TestPageService<TestPage> getTestPageService() {
		return testPageService;
	}

	public void setTestPageService(TestPageService<TestPage> testPageService) {
		this.testPageService = testPageService;
	}

	public CourseService<Course> getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService<Course> courseService) {
		this.courseService = courseService;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	

}

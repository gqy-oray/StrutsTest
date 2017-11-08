package com.onlineTest.action;

import com.onlineTest.bean.Student;
import com.onlineTest.bean.Teacher;
import com.onlineTest.bean.User;
import com.onlineTest.bean.department;
import com.onlineTest.bean.registered;
import com.onlineTest.service.AllService;
import com.onlineTest.tool.MD5Encodes;
import com.opensymphony.xwork2.ActionSupport;

public class registAction extends ActionSupport {
	private registered registered;
	private AllService<User> allService;
	private MD5Encodes md5;

	@Override
	public String execute() throws Exception {
		if (registered.getCareer().equals("student")) {
			if (registered.getPassword().equals(registered.getRePass())) {
				Student student = new Student();
				department department=new department();
				department.setId("d103");
				student.setId(registered.getId());
				student.setName("甘二狗");
				student.setDepart(department);
				student.setPassword(md5.EncodeByMD5(registered.getPassword()));
				allService.sava(student);
				System.out.println("注册成功");
				return SUCCESS;
			} else {
				System.out.println("密码不一样");
			}

		} else if (registered.getCareer().equals("teacher")) {
			if (registered.getPassword() == registered.getRePass()) {
				Teacher teacher = new Teacher();
				teacher.setId(registered.getId());
				teacher.setPassword(registered.getPassword());
				allService.sava(teacher);
				System.out.println("注册成功");
			} else {
				System.out.println("密码不一样");
			}
			return SUCCESS;
		}

		return INPUT;
	}

	public registered getRegistered() {
		return registered;
	}

	public void setRegistered(registered registered) {
		this.registered = registered;
	}

	public AllService<User> getAllService() {
		return allService;
	}

	public void setAllService(AllService<User> allService) {
		this.allService = allService;
	}

	public MD5Encodes getMd5() {
		return md5;
	}

	public void setMd5(MD5Encodes md5) {
		this.md5 = md5;
	}
	

}

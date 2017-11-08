package com.onlineTest.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.onlineTest.bean.Customer;
import com.onlineTest.bean.Student;
import com.onlineTest.bean.Teacher;
import com.onlineTest.bean.User;
import com.onlineTest.service.LoginService;
import com.onlineTest.tool.MD5Encodes;
import com.opensymphony.xwork2.ActionSupport;

//action类需要继承ActionSupport,重写execute()方法
public class LoginAction extends ActionSupport {
	private Customer customer;
	private LoginService loginservice;
	private MD5Encodes md5;
	private User user;

	// 除了使用xml文件校验外，还可以使用validate()方法完成校验，validate()方法先于execute()方法
	//使用struts校验，action必须配置一个result name为input
	@Override
	public void validate() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		try {
			if (customer.getId() != null && !customer.getId().equals("")) {
				if (customer.getCareer().equals("student")) {
					user = (User) loginservice.login(Student.class, customer.getId());
				} else if (customer.getCareer().equals("teacher")) {
					user = (User) loginservice.login(Teacher.class, customer.getId());
				}
				if (user == null) {
					addFieldError("customer.id", "用户帐号不存在");
				} else if (!user.getPassword().equalsIgnoreCase(md5.EncodeByMD5(customer.getPassword()))) {
					addFieldError("customer.password", "密码与账户不匹配");
				}
				session.setAttribute("User", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String execute() throws Exception {
	
		
		// 获取网页的一次通话对象
		/*
		 * 
		 * User user = null; if (customer.getCareer().equals("student")) { user
		 * = (User) loginservice.login(Student.class, customer.getId()); } else
		 * if (customer.getCareer().equals("teacher")) { user = (User)
		 * loginservice.login(Teacher.class, customer.getId()); }
		 * 
		 * if (user != null) { if
		 * (user.getPassword().equalsIgnoreCase(md5.EncodeByMD5(customer.
		 * getPassword()))) { System.out.println("登录成功");
		 * session.setAttribute("User", user); return SUCCESS; } else {
		 * System.out.println("帐号与密码不匹配"); } } else {
		 * System.out.println("帐号不存在"); }
		 */
		/*
		 * if(customer.getCareer().equals("student")){ Student student=(Student)
		 * loginservice.login(Student.class, customer.getId());
		 * if(student!=null){//用户存在
		 * if(student.getPassword().equalsIgnoreCase(md5.EncodeByMD5(customer.
		 * getPassword()))){ System.out.println("登录成功");
		 * //登录成功以后将登陆客户对象保存在一次通话中，其中user是key，student是value
		 * session.setAttribute("User", student); return SUCCESS; }else{
		 * System.out.println("帐号与密码不匹配"); }
		 * 
		 * }else{ System.out.println("帐号不存在"); } } if
		 * (customer.getCareer().equals("teacher")) { Teacher teacher =
		 * (Teacher) loginservice.login(Teacher.class, customer.getId()); if
		 * (teacher != null) { if
		 * (teacher.getPassword().equalsIgnoreCase(md5.EncodeByMD5(customer.
		 * getPassword()))) { System.out.println("登录成功");
		 * session.setAttribute("User_teacher", teacher); return SUCCESS; } else
		 * { System.out.println("帐号与密码不匹配"); } } else {
		 * System.out.println("账户不存在"); } }
		 */

//		return INPUT;
		return SUCCESS;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LoginService getLoginservice() {
		return loginservice;
	}

	public void setLoginservice(LoginService loginservice) {
		this.loginservice = loginservice;
	}

	public MD5Encodes getMd5() {
		return md5;
	}

	public void setMd5(MD5Encodes md5) {
		this.md5 = md5;
	}

}

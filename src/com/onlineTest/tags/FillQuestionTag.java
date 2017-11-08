package com.onlineTest.tags;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.onlineTest.bean.FillQuestion;

public class FillQuestionTag extends SimpleTagSupport {
	private String collection;// 标签属性

	//
	@Override
	public void doTag() throws JspException, IOException {
		// 通过属性，获取对应的链表
		List<FillQuestion> fillQuestions = (List<FillQuestion>) getJspContext().getAttribute(collection);
		Writer out = getJspContext().getOut();// 获取页面的输出流
		for (int i = 1; i <= 10 && fillQuestions.size()>0; i++) {
			int index = (int) (Math.random() * fillQuestions.size());//
			FillQuestion fq = fillQuestions.get(index);
			fillQuestions.remove(index);
			out.write(i + "." + fq.getTitle()+"</br>");
			out.write("请输入答案：<input typr='text' name='" + fq.getId() + "'></br>");
		}

		// super.doTag();
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

}

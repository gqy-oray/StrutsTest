package com.onlineTest.tags;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.onlineTest.bean.JudgleQuestion;

public class JudgQuestionTag extends SimpleTagSupport {
	private String collectionJu;

	@Override
	public void doTag() throws JspException, IOException {
		List<JudgleQuestion> judgleQuestions = (List<JudgleQuestion>) getJspContext().getAttribute(collectionJu);
		Writer out = getJspContext().getOut();
		for (int i = 0; i < 10 && judgleQuestions.size() > 0; i++) {
			int index = (int) (Math.random() * judgleQuestions.size());
			JudgleQuestion jq = judgleQuestions.get(index);
			judgleQuestions.remove(index);
			out.write((i + 1) + "." + jq.getTitle()+"</br>");
			out.write("请输入答案<input type='text' name='" + jq.getId() + "'></br>");

		}
		super.doTag();

	}

	public String getCollectionJu() {
		return collectionJu;
	}

	public void setCollectionJu(String collectionJu) {
		this.collectionJu = collectionJu;
	}

}

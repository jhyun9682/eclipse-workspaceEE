package com.itwill.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IfBodyTag extends TagSupport{
	private boolean test;
	public IfBodyTag() {
		System.out.println("1.IfBodyTag()기본생성자");
	}
	public void setTest(boolean test) {
		System.out.println("2.IfBodyTag.setTest("+test+")");
		this.test = test;
	}
	@Override
	public int doStartTag() throws JspException {
		if(test) {
			return EVAL_BODY_INCLUDE;
		}else {
			return SKIP_BODY;
		}
	}
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}

package com.itwill.tag;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport{
	public HelloTag() {
		System.out.println("1.HelloTag  기본생성자");
	}
	@Override
	public int doStartTag() throws JspException {
		System.out.println("2.HelloTag.doStartTag()[시작태그를 만났습니다.]");
		try {
			JspWriter out=pageContext.getOut();
			String sUserId=(String)pageContext.getSession().getAttribute("sUserId");
			if(sUserId==null) {
				sUserId="GUEST";
			}
			out.println(sUserId+"  님안뇽하세요<br>");
			
		}catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		System.out.println("3.HelloTag.doEndTag()[종료태그를 만났습니다.]");
		try {
			pageContext.getOut().println("<hr>");
		}catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return EVAL_PAGE;
	}
}

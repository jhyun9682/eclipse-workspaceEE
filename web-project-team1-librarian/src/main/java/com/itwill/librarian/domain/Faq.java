package com.itwill.librarian.domain;

/*
 	FAQ_NO       NOT NULL NUMBER(3)      
	FAQ_QUESTION NOT NULL VARCHAR2(4000) 
	FAQ_ANSWER   NOT NULL VARCHAR2(4000) 
	FAQ_CATEGORY NOT NULL VARCHAR2(30) 
 */
public class Faq {
	private int faqNo;
	private String faqQuestion;
	private String faqAnswer;
	private String faqCategory;

	public Faq() {
		// TODO Auto-generated constructor stub
	}

	public Faq(int faqNo, String faqQuestion, String faqAnswer, String faqCategory) {
		super();
		this.faqNo = faqNo;
		this.faqQuestion = faqQuestion;
		this.faqAnswer = faqAnswer;
		this.faqCategory = faqCategory;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqQuestion() {
		return faqQuestion;
	}

	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}

	public String getFaqAnswer() {
		return faqAnswer;
	}

	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}

	public String getFaqCategory() {
		return faqCategory;
	}

	public void setFaqCategory(String faqCategory) {
		this.faqCategory = faqCategory;
	}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqQuestion=" + faqQuestion + ", faqAnswer=" + faqAnswer + ", faqCategory="
				+ faqCategory + "]";
	}

}

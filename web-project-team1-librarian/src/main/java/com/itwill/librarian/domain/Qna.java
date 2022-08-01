package com.itwill.librarian.domain;

import java.util.Date;
import java.util.List;

/*
이름           널?       유형             
------------ -------- -------------- 
QNA_NO       NOT NULL NUMBER(3)      
MEMBER_NO    NOT NULL NUMBER(3)      
QNA_TITLE    NOT NULL VARCHAR2(150)  
QNA_CONTENT  NOT NULL VARCHAR2(4000) 
QNA_REG_DATE NOT NULL DATE           
QNA_VISIBLE  NOT NULL NUMBER(1)      
QNA_FILE              VARCHAR2(256)  
QNA_VIEWS    NOT NULL NUMBER(4)  
 */

public class Qna {
	private int qnaNo;
	private int memberNo;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaRegDate;
	private int qnaVisible;
	private String qnaFile;
	private int qnaViews;
	private int qna_reply_count;
	private List<Reply> replys;
	
	public Qna() {
		// TODO Auto-generated constructor stub
	}
	
	public Qna(int qnaNo, String qnaTitle, Date qnaRegDate, int qnaVisible,	String qnaFile, int qnaViews) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaRegDate = qnaRegDate;
		this.qnaVisible = qnaVisible;
		this.qnaFile = qnaFile;
		this.qnaViews = qnaViews;
	} 
	
	public Qna(int qnaNo, int memberNo, String qnaTitle, String qnaContent,int qnaVisible,
			String qnaFile) {
		super();
		this.qnaNo = qnaNo;
		this.memberNo = memberNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaVisible = qnaVisible;
		this.qnaFile = qnaFile;
	}

	public Qna(int qnaNo, int memberNo, String qnaTitle, String qnaContent, Date qnaRegDate, int qnaVisible,
			String qnaFile, int qnaViews) {
		super();
		this.qnaNo = qnaNo;
		this.memberNo = memberNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaRegDate = qnaRegDate;
		this.qnaVisible = qnaVisible;
		this.qnaFile = qnaFile;
		this.qnaViews = qnaViews;
	}

	public int getQna_reply_count() {
		return qna_reply_count;
	}

	public void setQna_reply_count(int qna_reply_count) {
		this.qna_reply_count = qna_reply_count;
	}
	
	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getQnaRegDate() {
		return qnaRegDate;
	}

	public void setQnaRegDate(Date qnaRegDate) {
		this.qnaRegDate = qnaRegDate;
	}

	public int getQnaVisible() {
		return qnaVisible;
	}

	public void setQnaVisible(int qnaVisible) {
		this.qnaVisible = qnaVisible;
	}

	public String getQnaFile() {
		return qnaFile;
	}

	public void setQnaFile(String qnaFile) {
		this.qnaFile = qnaFile;
	}

	public int getQnaViews() {
		return qnaViews;
	}

	public void setQnaViews(int qnaViews) {
		this.qnaViews = qnaViews;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", memberNo=" + memberNo + ", qnaTitle=" + qnaTitle + ", qnaContent="
				+ qnaContent + ", qnaRegDate=" + qnaRegDate + ", qnaVisible=" + qnaVisible + ", qnaFile=" + qnaFile
				+ ", qnaViews=" + qnaViews + ", qna_reply_count=" + qna_reply_count + ", replys=" + replys + "]";
	}

	
	
	
	
	
}

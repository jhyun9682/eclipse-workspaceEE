package com.itwill.librarian.domain;
/*
이름            널?       유형             
------------- -------- -------------- 
REPLY_NO      NOT NULL NUMBER(3)      
REPLY_CONTENT NOT NULL VARCHAR2(4000) 
QNA_NO        NOT NULL NUMBER(3)      
MEMBER_NO     NOT NULL NUMBER(3) 
 */

public class Reply {
	private int replyNo;
	private String replyContent;
	private int qnaNo;
	private int memberNo;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int replyNo, String replyContent, int qnaNo, int memberNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.qnaNo = qnaNo;
		this.memberNo = memberNo;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", qnaNo=" + qnaNo + ", memberNo="
				+ memberNo + "]";
	}
	
	

}

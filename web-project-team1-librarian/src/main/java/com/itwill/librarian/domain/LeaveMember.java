package com.itwill.librarian.domain;

import java.util.Date;

public class LeaveMember {
	private int leaveNo;
	private String memberId;
	private String memberOpinion;
	private Date leaveDate;
	
	public LeaveMember() {
		// TODO Auto-generated constructor stub
	}
	
	public LeaveMember(String memberId, String memberOpinion) {
		super();
		this.memberId = memberId;
		this.memberOpinion = memberOpinion;
	}
	
	public LeaveMember(int leaveNo, String memberId, String memberOpinion, Date leaveDate) {
		this.leaveNo = leaveNo;
		this.memberId = memberId;
		this.memberOpinion = memberOpinion;
		this.leaveDate = leaveDate;
	}

	public int getLeaveNo() {
		return leaveNo;
	}

	public void setLeaveNo(int leaveNo) {
		this.leaveNo = leaveNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberOpinion() {
		return memberOpinion;
	}

	public void setMemberOpinion(String memberOpinion) {
		this.memberOpinion = memberOpinion;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	@Override
	public String toString() {
		return "LeaveMember [leaveNo=" + leaveNo + ", memberId=" + memberId + ", memberOpinion=" + memberOpinion
				+ ", leaveDate=" + leaveDate + "]";
	}

}

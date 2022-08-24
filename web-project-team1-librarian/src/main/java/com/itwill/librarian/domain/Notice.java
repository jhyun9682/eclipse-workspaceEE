package com.itwill.librarian.domain;

import java.util.Date;

public class Notice {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeRegDate;
	private String noticeFile;
	private int noticeViews;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int noticeNo, String noticeTitle, Date noticeRegDate, int noticeViews) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeRegDate = noticeRegDate;
		this.noticeViews = noticeViews;
	}
	
	public Notice(String noticeTitle, String noticeContent, Date noticeRegDate, String noticeFile) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeRegDate = noticeRegDate;
		this.noticeFile = noticeFile;
	}
	
	public Notice(int noticeNo, String noticeTitle, String noticeContent, Date noticeRegDate, String noticeFile,
			int noticeViews) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeRegDate = noticeRegDate;
		this.noticeFile = noticeFile;
		this.noticeViews = noticeViews;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeRegDate() {
		return noticeRegDate;
	}

	public void setNoticeRegDate(Date noticeRegDate) {
		this.noticeRegDate = noticeRegDate;
	}

	public String getNoticeFile() {
		return noticeFile;
	}

	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}

	public int getNoticeViews() {
		return noticeViews;
	}

	public void setNoticeViews(int noticeViews) {
		this.noticeViews = noticeViews;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeRegDate=" + noticeRegDate + ", noticeFile=" + noticeFile + ", noticeViews=" + noticeViews
				+ "]";
	}
	
}

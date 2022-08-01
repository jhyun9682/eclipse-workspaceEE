package com.itwill.librarian.domain;

import java.util.Date;

public class HopeBook {
	private int hopeNO;
	private int memberNo;
	private String bookTitle;
	private String publisher;
	private String author;
	private int ibStatus;
	private Date hopeRegDate;

	public HopeBook() {
		// TODO Auto-generated constructor stub
	}
	
	public HopeBook(int memberNo, String bookTitle, String publisher, String author) {
		this.memberNo = memberNo;
		this.bookTitle = bookTitle;
		this.publisher = publisher;
		this.author = author;
	}

	public HopeBook(int hopeNO, int memberNo, String bookTitle, String publisher, 
					String author, int ibStatus,Date hopeRegDate) {
		this.hopeNO = hopeNO;
		this.memberNo = memberNo;
		this.bookTitle = bookTitle;
		this.publisher = publisher;
		this.author = author;
		this.ibStatus = ibStatus;
		this.hopeRegDate = hopeRegDate;
	}

	

	public int getHopeNO() {
		return hopeNO;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getAuthor() {
		return author;
	}

	public int getIbStatus() {
		return ibStatus;
	}

	public Date getHopeRegDate() {
		return hopeRegDate;
	}

	public void setHopeNO(int hopeNO) {
		this.hopeNO = hopeNO;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIbStatus(int ibStatus) {
		this.ibStatus = ibStatus;
	}

	public void setHopeRegDate(Date hopeRegDate) {
		this.hopeRegDate = hopeRegDate;
	}

	@Override
	public String toString() {
		return "HopeBook [hopeNO=" + hopeNO + ", memberNo=" + memberNo + ", bookTitle=" + bookTitle + ", publisher="
				+ publisher + ", author=" + author + ", ibStatus=" + ibStatus + ", hopeRegDate=" + hopeRegDate + "]";
	}

}

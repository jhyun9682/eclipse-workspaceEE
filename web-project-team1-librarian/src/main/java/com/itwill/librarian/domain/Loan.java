package com.itwill.librarian.domain;

import java.util.Date;

public class Loan {
	
	//대출 기간
	public final static int LOAN_TERM = 7;
	
	private int loanNo;
	private int memberNo;
	private String bookNo;
	private Date loanRegDate;
	private Date loanReturnDate;
	private boolean loanAccess;

	public Loan() {
		
	}
	
	public Loan(int loanNo, int memberNo, String bookNo, Date loanRegDate, boolean loanAccess) {
		this.loanNo = loanNo;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
		this.loanRegDate = loanRegDate;
		this.loanAccess = loanAccess;
	}

	public Loan(int loanNo, int memberNo, String bookNo, Date loanRegDate, Date loanReturnDate, boolean loanAccess) {
		this.loanNo = loanNo;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
		this.loanRegDate = loanRegDate;
		this.loanReturnDate = loanReturnDate;
		this.loanAccess = loanAccess;
	}
	
	public int getLoanNo() {
		return loanNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public String getBookNo() {
		return bookNo;
	}

	public Date getLoanRegDate() {
		return loanRegDate;
	}

	public Date getLoanReturnDate() {
		return loanReturnDate;
	}

	public boolean isLoanAccess() {
		return loanAccess;
	}
	
	public void setLoanNo(int loanNo) {
		this.loanNo = loanNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public void setLoanRegDate(Date loanRegDate) {
		this.loanRegDate = loanRegDate;
	}

	public void setLoanReturnDate(Date loanReturnDate) {
		this.loanReturnDate = loanReturnDate;
	}

	public void setLoanAccess(boolean loanAccess) {
		this.loanAccess = loanAccess;
	}

	@Override
	public String toString() {
		return "Loan [loanNo=" + loanNo + ", memberNo=" + memberNo + ", bookNo=" + bookNo + ", loanRegDate="
				+ loanRegDate + ", loanReturnDate=" + loanReturnDate + ", loanAccess=" + loanAccess + "]";
	}

	
	
	
}

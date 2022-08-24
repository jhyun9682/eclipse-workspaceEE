package com.itwill.librarian.domain;

import java.util.Date;

public class Reservation {
	
	private int memberNo;
	private String bookNo;
	private Date reservationRegDate;
	

	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(String memberNo, String bookNo) {
        super();
        this.memberNo = Integer.parseInt(memberNo);
        this.bookNo = bookNo;
    }
	
	public Reservation(String memberNo, String bookNo, Date reservationRegDate) {
        super();
        this.memberNo = Integer.parseInt(memberNo);
        this.bookNo = bookNo;
		this.reservationRegDate = reservationRegDate;
    }
	
	public Reservation(int memberNo, String bookNo, Date reservationRegDate) {
		super();
		this.memberNo = memberNo;
		this.bookNo = bookNo;
		this.reservationRegDate = reservationRegDate;
	}
	
	public Reservation(int memberNo, String bookNo) {
		super();
		this.memberNo = memberNo;
		this.bookNo = bookNo;
	}


	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public Date getReservationRegDate() {
		return reservationRegDate;
	}

	public void setReservationRegDate(Date reservationRegDate) {
		this.reservationRegDate = reservationRegDate;
	}

	@Override
	public String toString() {
		return "Reservation [memberNo=" + memberNo + ", bookNo=" + bookNo + ", reservationRegDate=" + reservationRegDate
				+ "]";
	}

	
	
	
	
}

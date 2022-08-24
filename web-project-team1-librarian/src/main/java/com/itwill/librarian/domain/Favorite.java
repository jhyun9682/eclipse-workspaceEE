package com.itwill.librarian.domain;

public class Favorite {
	private int memberNo;
	private String bookNo;
	
	
	public Favorite() {
		// TODO Auto-generated constructor stub
	}

	public Favorite(String memberNo, String bookNo) {
        super();
        this.memberNo = Integer.parseInt(memberNo);
        this.bookNo = bookNo;
    }
	
	public Favorite(int memberNo, String bookNo) {
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

	@Override
	public String toString() {
		return "Favorite [memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}

	
	
}
	
	
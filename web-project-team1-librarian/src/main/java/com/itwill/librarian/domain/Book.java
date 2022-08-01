package com.itwill.librarian.domain;

import java.util.Date;

public class Book {
	private String bookNo;
	private String bookTitle;
	private String bookCategory;
	private String bookAuthor;
	private String bookPublisher;
	private Date bookYop;
	private String bookInfo;
	private String bookIndex;
	private String bookImageURL;
	private int bookHoldings;
	private int bookLoan;
	private int bookReservation;

	public Book() {
	}

	public Book(String bookNo, String bookTitle, String bookCategory, String bookAuthor, String bookPublisher,
			Date bookYop, String bookInfo, String bookIndex, String bookImageURL, int bookHoldings) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookCategory = bookCategory;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookYop = bookYop;
		this.bookInfo = bookInfo;
		this.bookIndex = bookIndex;
		this.bookImageURL = bookImageURL;
		this.bookHoldings = bookHoldings;
	}

	public Book(String bookNo, String bookTitle, String bookCategory, String bookAuthor, String bookPublisher,
			Date bookYop, String bookInfo, String bookIndex, String bookImageURL, int bookHoldings, int bookLoan,
			int bookReservation) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookCategory = bookCategory;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookYop = bookYop;
		this.bookInfo = bookInfo;
		this.bookIndex = bookIndex;
		this.bookImageURL = bookImageURL;
		this.bookHoldings = bookHoldings;
		this.bookLoan = bookLoan;
		this.bookReservation = bookReservation;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Date getBookYop() {
		return bookYop;
	}

	public void setBookYop(Date bookYop) {
		this.bookYop = bookYop;
	}

	public String getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}

	public String getBookIndex() {
		return bookIndex;
	}

	public void setBookIndex(String bookIndex) {
		this.bookIndex = bookIndex;
	}

	public String getBookImageURL() {
		return bookImageURL;
	}

	public void setBookImageURL(String bookImageURL) {
		this.bookImageURL = bookImageURL;
	}

	public int getBookHoldings() {
		return bookHoldings;
	}

	public void setBookHoldings(int bookHoldings) {
		this.bookHoldings = bookHoldings;
	}

	public int getBookLoan() {
		return bookLoan;
	}

	public void setBookLoan(int bookLoan) {
		this.bookLoan = bookLoan;
	}

	public int getBookReservation() {
		return bookReservation;
	}

	public void setBookReservation(int bookReservation) {
		this.bookReservation = bookReservation;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookCategory=" + bookCategory
				+ ", bookAuthor=" + bookAuthor + ", bookPublisher=" + bookPublisher + ", bookYop=" + bookYop
				+ ", bookInfo=" + bookInfo + ", bookIndex=" + bookIndex + ", bookImageURL=" + bookImageURL
				+ ", bookHoldings=" + bookHoldings + ", bookLoan=" + bookLoan + ", bookReservation=" + bookReservation
				+ "]";
	}

}

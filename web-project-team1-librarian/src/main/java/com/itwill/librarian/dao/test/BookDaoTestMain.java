package com.itwill.librarian.dao.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.itwill.librarian.dao.BookDao;
import com.itwill.librarian.domain.Book;

public class BookDaoTestMain {

	public static void main(String[] args) throws Exception {
		BookDao bookDao = new BookDao();
		/* 전체 리스트
		 * ArrayList<Book> totBookList = bookDao.getBookList(); for (Book book :
		 * totBookList) { System.out.println(book); }
		 */
		
		System.out.println(">> 번호로 찾기");
		Book book = bookDao.getBookByNo("8");
		System.out.println(book);
		
		System.out.println(">> 통합 검색");
		ArrayList<Book> bookList = bookDao.getBookByAll("맑은");
		for (Book book2 : bookList) {
			System.out.println(book2);
		}
		
		/*
		System.out.println(">> 책 추가");
				book = new Book("테스트", "테스트제목", "테스트저자", "테스트정보", "테스트카테고리",
				new SimpleDateFormat("yyyy-MM-dd").parse("2011-01-01"), "테스트목차", "테스트출판사", "테스트URL", 3);
		bookDao.add(book);
		Book addBook = bookDao.searchNo("테스트번호");
		System.out.println(addBook);
		*/
		
		System.out.println(">> 제목 검색");
		bookList = bookDao.getBookByTitle("아"); for (Book book2 : bookList) {
		System.out.println(book2); }
		
		System.out.println(">> 저자 검색");
		bookList = bookDao.getBookByAuthor("최은");
		for (Book book2 : bookList) {
			System.out.println(book2);
		}
		
		System.out.println(">> 출판사 검색");
		bookList = bookDao.getBookByPublisher("문학");
		for (Book book2 : bookList) {
			System.out.println(book2);
		}
		
		System.out.println(">> 책 카테고리 검색");
		bookList = bookDao.getBookByCategory("철학");
		for (Book book2 : bookList) {
			System.out.println(book2);
		}
		
		System.out.println(">> 책 수정");
		book = new Book("테스트", "제목", "수정테스트", "저자", "출판사", new SimpleDateFormat("yyyy-MM-dd").parse("2002-02-02"), "정보", "목차", "abcd", 2);
		bookDao.modifyBook(book);
		System.out.println(bookDao.getBookByNo("테스트"));
		
		System.out.println(">> 책 대출 증가");
		bookDao.addBookLoan("테스트");
		System.out.println(bookDao.getBookByNo("테스트"));
		
		System.out.println(">> 책 대출 감소");
		bookDao.subBookLoan("테스트");
		System.out.println(bookDao.getBookByNo("테스트"));
		
		System.out.println(">> 책 예약 증가");
		bookDao.addBookReservation("테스트");
		System.out.println(bookDao.getBookByNo("테스트"));
		
		System.out.println(">> 책 예약 감소");
		bookDao.subBookReservation("테스트");
		System.out.println(bookDao.getBookByNo("테스트"));
		
		/*
		System.out.println(">> 책 삭제");
		bookDao.delete("테스트");
		*/
	}

}

package com.itwill.librarian.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.librarian.common.PageMaker;
import com.itwill.librarian.dao.BookDao;
import com.itwill.librarian.domain.Book;
import com.itwill.librarian.domain.PageMakerDto;

public class BookService {
	private BookDao bookDao;

	public BookService() {
		this.bookDao = new BookDao();
	}
	
	/**
	 * BOOK 전체 리스트 페이지 보기
	 * @param currentPage 현재 페이지
	 * @return
	 * @throws Exception
	 */
	public PageMakerDto<Book> getBookList(int currentPage) throws Exception {
		// 전체 글 개수
		int totRecordCount = bookDao.getTotBookCount();
		
		// 페이지 계산
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 3, 5);
		
		// 게시물 데이터 얻기
		List<Book> bookList = bookDao.getBookList(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		
		PageMakerDto<Book> pageMakerBookList = new PageMakerDto<Book>(bookList, pageMaker, totRecordCount);
		
		return pageMakerBookList;
	}
	
	/**
	 * 책 전체 리스트 조회
	 * @return 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookList() throws Exception {
		return bookDao.getBookList();
	}
	
	
	/**
	 * 새 책을 생성한다
	 * @param book
	 * @throws Exception
	 */
	public void addBook(Book book) throws Exception {
		// 번호 중복 체크
		Book checkBook = bookDao.getBookByNo(book.getBookNo());

		if (checkBook != null) {
			throw new Exception(book.getBookNo() + "는 이미 존재하는 책 입니다.");
		}

		bookDao.addBook(book);
	}

	/**
	 * 책 번호와 일치하는 책을 삭제한다
	 * @param bookNo
	 * @throws Exception
	 */
	public void removeBook(String bookNo) throws Exception {
		bookDao.removeBookByNo(bookNo);
	}

	/**
	 * 책 객체를 매개변수로 받아 정보를 수정한다.
	 * 책 번호로 수정할 책을 정하고, 나머지 필드 값으로 해당 책의 정보가 수정된다.
	 * @param book
	 * @throws Exception
	 */
	public void modifyBook(Book book) throws Exception {
		bookDao.modifyBook(book);
	}

	
	/**
	 * 책 번호로 책 1권 조회
	 * @param bookNo
	 * @return 책 1권
	 * @throws Exception
	 */
	public Book getBookByNo(String bookNo) throws Exception {
		return bookDao.getBookByNo(bookNo);
	}
	

	/**
	 * 통합 검색(책 제목, 저자, 출판사)
	 * @param keyword
	 * @return 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByAll(String keyword) throws Exception {
		return bookDao.getBookByAll(keyword);
	}
	/**
	 * 통합 검색 리스트 페이지((책 제목, 저자, 출판사)
	 * @param keyword
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	public PageMakerDto<Book> getBookByAll(String keyword, int currentPage) throws Exception {
		int totRecordCount = bookDao.getBookByAll(keyword).size();
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 3, 5);
		List<Book> bookList = bookDao.getBookByAll(keyword, pageMaker.getPageBegin(), pageMaker.getPageEnd());		
		PageMakerDto<Book> pageMakerBookList = new PageMakerDto<Book>(bookList, pageMaker, totRecordCount);
		
		return pageMakerBookList;
	}
	/**
	 * 책 제목 검색
	 * @param keyword
	 * @return 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByTitle(String keyword) throws Exception {
		return bookDao.getBookByTitle(keyword);
	}
	
	/**
	 * 책 제목 검색 페이지
	 * @param keyword
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	public PageMakerDto<Book> getBookByTitle(String keyword, int currentPage) throws Exception {
		int totRecordCount = bookDao.getBookByTitle(keyword).size();
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 3, 5);
		List<Book> bookList = bookDao.getBookByTitle(keyword, pageMaker.getPageBegin(), pageMaker.getPageEnd());		
		PageMakerDto<Book> pageMakerBookList = new PageMakerDto<Book>(bookList, pageMaker, totRecordCount);
		
		return pageMakerBookList;
	}
	/**
	 * 저자 검색
	 * @param keyword
	 * @return 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByAuthor(String keyword) throws Exception {
		return bookDao.getBookByAuthor(keyword);
	}
	/**
	 * 저자 검색 페이지
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public PageMakerDto<Book> getBookByAuthor(String keyword, int currentPage) throws Exception {
		int totRecordCount = bookDao.getBookByAuthor(keyword).size();
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 3, 5);
		List<Book> bookList = bookDao.getBookByAuthor(keyword, pageMaker.getPageBegin(), pageMaker.getPageEnd());		
		PageMakerDto<Book> pageMakerBookList = new PageMakerDto<Book>(bookList, pageMaker, totRecordCount);
		
		return pageMakerBookList;
	}
	
	/**
	 * 출판사 검색
	 * @param keyword
	 * @return 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByPublisher(String keyword) throws Exception {
		return bookDao.getBookByPublisher(keyword);
	}
	/**
	 * 출판사 검색 페이지
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public PageMakerDto<Book> getBookByPublisher(String keyword, int currentPage) throws Exception {
		int totRecordCount = bookDao.getBookByPublisher(keyword).size();
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 3, 5);
		List<Book> bookList = bookDao.getBookByPublisher(keyword, pageMaker.getPageBegin(), pageMaker.getPageEnd());		
		PageMakerDto<Book> pageMakerBookList = new PageMakerDto<Book>(bookList, pageMaker, totRecordCount);
		
		return pageMakerBookList;
	}
	/**
	 * 카테고리 검색
	 * @param keyword
	 * @return 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByCategory(String keyword) throws Exception {
		return bookDao.getBookByCategory(keyword);
	}
	/**
	 * 카테고리 검색 페이지
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public PageMakerDto<Book> getBookByCategory(String keyword, int currentPage) throws Exception {
		int totRecordCount = bookDao.getBookByCategory(keyword).size();
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 3, 5);
		List<Book> bookList = bookDao.getBookByCategory(keyword, pageMaker.getPageBegin(), pageMaker.getPageEnd());		
		PageMakerDto<Book> pageMakerBookList = new PageMakerDto<Book>(bookList, pageMaker, totRecordCount);
		
		return pageMakerBookList;
	}
}

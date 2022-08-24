package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Book;
import com.itwill.librarian.sql.BookSql;

public class BookDao {
	private DataSource dataSource;
	
	public BookDao() {
		this.dataSource = Librarian.getDataSource();
	}
	
	/**
	 * 책 전체 리스트와 각 전체 속성을 조회
	 * @return ArrayList<Book> 책 리스트
	 */
	public ArrayList<Book> getBookList() throws Exception{
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_LIST);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
									 rs.getString("book_title"),
									 rs.getString("book_category"),
									 rs.getString("book_author"),
									 rs.getString("book_publisher"),
									 rs.getDate("book_yop"),
									 rs.getString("book_info"),
									 rs.getString("book_index"),
									 rs.getString("book_image_url"),
									 rs.getInt("book_holdings"),
									 rs.getInt("book_loan"),
									 rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	
	public ArrayList<Book> getBookList(int start, int last) throws Exception{
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_LIST_PAGE);
			pstmt.setInt(1, start);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book(rs.getString("book_no"),
						rs.getString("book_title"),
						rs.getString("book_category"),
						rs.getString("book_author"),
						rs.getString("book_publisher"),
						rs.getDate("book_yop"),
						rs.getString("book_info"),
						rs.getString("book_index"),
						rs.getString("book_image_url"),
						rs.getInt("book_holdings"),
						rs.getInt("book_loan"),
						rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	/**
	 * 책 번호로 책 조회
	 * @param bookNo
	 * @return 일치하는 책 1권
	 * @throws Exception
	 */
	public Book getBookByNo(String bookNo) throws Exception{
		Book book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_NO);
			pstmt.setString(1, bookNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getString("book_no"),
								rs.getString("book_title"),
								rs.getString("book_category"),
								rs.getString("book_author"),
								rs.getString("book_publisher"),
								rs.getDate("book_yop"),
								rs.getString("book_info"),
								rs.getString("book_index"),
								rs.getString("book_image_url"),
								rs.getInt("book_holdings"),
								rs.getInt("book_loan"),
								rs.getInt("book_reservation"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return book;
	}
	
	/**
	 * 하나의 검색어로 통합 검색(책 제목, 저자, 출판사)
	 * @return ArrayList<Book>
	 */
	public ArrayList<Book> getBookByAll(String keyword) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_ALL);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
									 rs.getString("book_title"),
									 rs.getString("book_category"),
									 rs.getString("book_author"),
									 rs.getString("book_publisher"),
									 rs.getDate("book_yop"),
									 rs.getString("book_info"),
									 rs.getString("book_index"),
									 rs.getString("book_image_url"),
									 rs.getInt("book_holdings"),
									 rs.getInt("book_loan"),
									 rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	/**
	 * 하나의 검색어로 통합 검색(책 제목, 저자, 출판사) 페이지
	 * @param keyword
	 * @param start
	 * @param last
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByAll(String keyword, int start, int last) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_ALL_LIST);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setInt(4, start);
			pstmt.setInt(5, last);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
						rs.getString("book_title"),
						rs.getString("book_category"),
						rs.getString("book_author"),
						rs.getString("book_publisher"),
						rs.getDate("book_yop"),
						rs.getString("book_info"),
						rs.getString("book_index"),
						rs.getString("book_image_url"),
						rs.getInt("book_holdings"),
						rs.getInt("book_loan"),
						rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	/**
	 * 제목으로 책 검색
	 * @param keyword
	 * @return ArrayList<Book> 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByTitle(String keyword) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_TITLE);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
									 rs.getString("book_title"),
									 rs.getString("book_category"),
									 rs.getString("book_author"),
									 rs.getString("book_publisher"),
									 rs.getDate("book_yop"),
									 rs.getString("book_info"),
									 rs.getString("book_index"),
									 rs.getString("book_image_url"),
									 rs.getInt("book_holdings"),
									 rs.getInt("book_loan"),
									 rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	
	/**
	 * 제목으로 책 검색 페이지
	 * @param keyword
	 * @param start
	 * @param last
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByTitle(String keyword, int start, int last) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_TITLE_LIST);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, last);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
						rs.getString("book_title"),
						rs.getString("book_category"),
						rs.getString("book_author"),
						rs.getString("book_publisher"),
						rs.getDate("book_yop"),
						rs.getString("book_info"),
						rs.getString("book_index"),
						rs.getString("book_image_url"),
						rs.getInt("book_holdings"),
						rs.getInt("book_loan"),
						rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	
	/**
	 * 저자 이름으로 책 검색
	 * @param keyword
	 * @return ArrayList<Book> 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByAuthor(String keyword) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_AUTHOR);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
									 rs.getString("book_title"),
									 rs.getString("book_category"),
									 rs.getString("book_author"),
									 rs.getString("book_publisher"),
									 rs.getDate("book_yop"),
									 rs.getString("book_info"),
									 rs.getString("book_index"),
									 rs.getString("book_image_url"),
									 rs.getInt("book_holdings"),
									 rs.getInt("book_loan"),
									 rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	/**
	 * 저자로 책 검색 페이지
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByAuthor(String keyword, int start, int last) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_AUTHOR_LIST);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, last);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
						rs.getString("book_title"),
						rs.getString("book_category"),
						rs.getString("book_author"),
						rs.getString("book_publisher"),
						rs.getDate("book_yop"),
						rs.getString("book_info"),
						rs.getString("book_index"),
						rs.getString("book_image_url"),
						rs.getInt("book_holdings"),
						rs.getInt("book_loan"),
						rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	/**
	 * 출판사 명으로 검색
	 * @param keyword
	 * @return ArrayList<Book> 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByPublisher(String keyword) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_PUBLISHER);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
									 rs.getString("book_title"),
									 rs.getString("book_category"),
									 rs.getString("book_author"),
									 rs.getString("book_publisher"),
									 rs.getDate("book_yop"),
									 rs.getString("book_info"),
									 rs.getString("book_index"),
									 rs.getString("book_image_url"),
									 rs.getInt("book_holdings"),
									 rs.getInt("book_loan"),
									 rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	
	/**
	 * 출판사로 검색 페이지
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByPublisher(String keyword, int start, int last) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_PUBLISHER_LIST);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, last);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
						rs.getString("book_title"),
						rs.getString("book_category"),
						rs.getString("book_author"),
						rs.getString("book_publisher"),
						rs.getDate("book_yop"),
						rs.getString("book_info"),
						rs.getString("book_index"),
						rs.getString("book_image_url"),
						rs.getInt("book_holdings"),
						rs.getInt("book_loan"),
						rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	
	/**
	 * 카테고리로 책 검색
	 * @param keyword
	 * @return ArrayList<Book> 해당 책 리스트
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByCategory(String keyword) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_CATEGORY);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
									 rs.getString("book_title"),
									 rs.getString("book_category"),
									 rs.getString("book_author"),
									 rs.getString("book_publisher"),
									 rs.getDate("book_yop"),
									 rs.getString("book_info"),
									 rs.getString("book_index"),
									 rs.getString("book_image_url"),
									 rs.getInt("book_holdings"),
									 rs.getInt("book_loan"),
									 rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	
	/**
	 * 카테고리로 책 검색 페이지
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Book> getBookByCategory(String keyword, int start, int last) throws Exception {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SEARCH_CATEGORY_LIST);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, last);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("book_no"),
						rs.getString("book_title"),
						rs.getString("book_category"),
						rs.getString("book_author"),
						rs.getString("book_publisher"),
						rs.getDate("book_yop"),
						rs.getString("book_info"),
						rs.getString("book_index"),
						rs.getString("book_image_url"),
						rs.getInt("book_holdings"),
						rs.getInt("book_loan"),
						rs.getInt("book_reservation"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return bookList;
	}
	/**
	 * 책 추가
	 * 대출 수와 예약 수는 기본값 0으로 설정됨
	 * @param book
	 * @throws Exception
	 */
	public void addBook(Book book) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_INSERT);
			pstmt.setString(1, book.getBookNo());
			pstmt.setString(2, book.getBookTitle());
			pstmt.setString(3, book.getBookAuthor());
			pstmt.setString(4, book.getBookInfo());
			pstmt.setString(5, book.getBookCategory());
			pstmt.setString(6, book.getBookImageURL());
			pstmt.setString(7, book.getBookIndex());
			pstmt.setString(8, book.getBookPublisher());
			pstmt.setDate(9, new Date(book.getBookYop().getTime()));
			pstmt.setInt(10, book.getBookHoldings());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
	}
	
	/**
	 * 책 정보 수정
	 * 대출 수와 예약 수는 수정할 수 없음
	 * @param book
	 * @throws Exception
	 */
	public void modifyBook(Book book) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_UPDATE);
			pstmt.setString(1, book.getBookTitle());
			pstmt.setString(2, book.getBookCategory());
			pstmt.setString(3, book.getBookAuthor());
			pstmt.setString(4, book.getBookPublisher());
			pstmt.setDate(5, new Date(book.getBookYop().getTime()));
			pstmt.setString(6, book.getBookInfo());
			pstmt.setString(7, book.getBookIndex());
			pstmt.setString(8, book.getBookImageURL());
			pstmt.setString(9, book.getBookNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
	}
	
	/**
	 * 해당 책 대출 수 1 증가
	 * @param bookNo
	 * @throws Exception
	 */
	public void addBookLoan(String bookNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_ADD_LOAN);
			pstmt.setString(1, bookNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	/**
	 * 해당 책 대출 수 1 감소
	 * @param bookNo
	 * @throws Exception
	 */
	public void subBookLoan(String bookNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SUB_LOAN);
			pstmt.setString(1, bookNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	/**
	 * 해당 책 예약 수 1 증가
	 * @param bookNo
	 * @throws Exception
	 */
	public void addBookReservation(String bookNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_ADD_RESERVATION);
			pstmt.setString(1, bookNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	/**
	 * 해당 책 예약 수 1 감소
	 * @param bookNo
	 * @throws Exception
	 */
	public void subBookReservation(String bookNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_SUB_RESERVATION);
			pstmt.setString(1, bookNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	/**
	 * 책 번호로 책 삭제
	 * @param bookNo
	 * @throws Exception
	 */
	public void removeBookByNo(String bookNo) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(BookSql.BOOK_DELETE);
			pstmt.setString(1, bookNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
	}
	
	/**
	 * 전체 책 개수 조회
	 * @return 전체 책 개수
	 * @throws Exception
	 */
	public int getTotBookCount() throws Exception {
		int totBookCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select count(*) from book");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totBookCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return totBookCount;
	}
	
	public int getTotBookCount(String keyword) throws Exception {
		int totBookCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select count(*) from book where BOOK_TITLE like ? or BOOK_AUTHOR like ? or BOOK_PUBLISHER like ?");
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totBookCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return totBookCount;
	}
}

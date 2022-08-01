package com.itwill.librarian.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.librarian.dao.BookDao;
import com.itwill.librarian.dao.LoanDao;
import com.itwill.librarian.dao.MemberDao;
import com.itwill.librarian.domain.Book;
import com.itwill.librarian.domain.Loan;

public class LoanService {

	private LoanDao loanDao;
	private BookDao bookDao;
	private MemberDao memberDao;
	
	public LoanService() {
		this.loanDao = new LoanDao();
		this.bookDao = new BookDao();
		this.memberDao = new MemberDao();
	}
	
	//대출 도서 목록
	public ArrayList<Book> getLoanList(int memberNo) throws Exception {
		ArrayList<Book> loanBookList = null;
		
		//대출 목록을 불러오는데 없다면 null
		List<Loan> loanList = loanDao.getLoanList(memberNo, true);
		
		//null이 아닌 대출 목록이 있다면 책의 정보를 담음
		if(loanList != null) {
			loanBookList = new ArrayList<Book>();
			
			for (Loan loan : loanList) {
				loanBookList.add(bookDao.getBookByNo(loan.getBookNo()));
			}
		}
		
		return loanBookList;
	}
	
	//대출 반납 도서 목록
	public ArrayList<Book> getLoanReturnList(int memberNo) throws Exception {
		ArrayList<Book> loanReturnBookList = null;
		
		//대출 목록을 불러오는데 없다면 null
		List<Loan> loanReturnList = loanDao.getLoanList(memberNo, false);
				
		//null이 아닌 대출 목록이 있다면 책의 정보를 담음
		if(loanReturnList != null) {
			loanReturnBookList = new ArrayList<Book>();
			
			for (Loan loan : loanReturnList) {
				loanReturnBookList.add(bookDao.getBookByNo(loan.getBookNo()));
			}
		}
		
		return loanReturnBookList;
	}
	
	//유저 한 명의 대출 목록(access = true) or 반납 목록(access = false)
	public ArrayList<Loan> getLoanList(int memberNo, boolean access) throws Exception {
		return loanDao.getLoanList(memberNo, access);
	}
	
	/* 
	 * 도서 대출 추가
	 * 추가 하기 전에 이미 대출이 되어 있는 책인지 확인하고 넣기
	 */
	public int addLoan(int memberNo, String bookNo) throws Exception {
		int rowCount = 0;
		
		if(loanDao.isExistLoanBook(memberNo, bookNo)) {
			rowCount += loanDao.addLoan(memberNo, bookNo);
			bookDao.addBookLoan(bookNo);
			memberDao.modifyMemberLoan(memberNo, true);
		}
		
		return rowCount;
	}
	
	//도서 반납
	public int modifyLoan(int loanNo, String bookNo, int memberNo) throws Exception {
		int rowCount = 0;
		
		rowCount = loanDao.modifyLoan(loanNo);
		bookDao.subBookLoan(bookNo);
		memberDao.modifyMemberLoan(memberNo, false);
		
		return rowCount;
	}
	
	/* 
	 * 도서 대출 기록 삭제(반납 페이지에서만 사용)
	 */
	public int removeLoan(int loanNo) throws Exception {
		return loanDao.removeLoan(loanNo);
	}
	
	
	
	
}

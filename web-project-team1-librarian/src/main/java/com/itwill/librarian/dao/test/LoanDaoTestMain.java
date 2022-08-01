package com.itwill.librarian.dao.test;

import java.util.List;

import com.itwill.librarian.dao.LoanDao;
import com.itwill.librarian.domain.Loan;

public class LoanDaoTestMain {

	public static void main(String[] args) throws Exception {
		//dao객체 생성
		LoanDao ld = new LoanDao();
		List<Loan> ll = null;
		int rc = 0;
		
		//memberNo가 2인 유저가 가지고 있는 대출 목록
		ll = ld.getLoanList(2, true);
		//대출 목록이 있어야 리스트 출력 
		if(ll != null) {
			System.out.println("=== LoanList ===");
			for (Loan loan : ll) {
				System.out.println(loan);
			}
		} else {
			System.out.println("대출 목록 없음");
		}
		
		/*
		 * memberNo가 2인 유저가 bookNo가 "2"인 책을 대출 추가
		 */
		rc = ld.addLoan(2, "2");
		//영향을 받은 행이 1개(한 명의 유저가 하나의 책을 대출)이면 성공
		if(rc == 1) {
			System.out.println("insert 성공");
		}
		
		//memberNo가 2인 유저가 가지고 있는 대출 목록
		ll = ld.getLoanList(2, true);
		//대출 목록이 있어야 리스트 출력 
		if(ll != null) {
			System.out.println("=== LoanList ===");
			for (Loan loan : ll) {
				System.out.println(loan);
			}
		} else {
			System.out.println("대출 목록 없음");
		}
		
		/*
		 * loanNo가 9번인 책 반납
		 */
		rc = ld.modifyLoan(10);
		//영향을 받은 행이 1개(한 명의 유저가 하나의 책을 반납)이면 성공
		if(rc == 1) {
			System.out.println("update 성공");
		}
		
		//memberNo가 2인 유저가 가지고 있는 반납 목록
		ll = ld.getLoanList(2, false);
		//대출 목록이 있어야 리스트 출력 
		if(ll != null) {
			System.out.println("=== LoanReturnList ===");
			for (Loan loan : ll) {
				System.out.println(loan);
			}
		} else {
			System.out.println("반납 목록 없음");
		}
		
		/*
		 * loanNo가 9번인 대출 기록 삭제
		 */
		rc = ld.removeLoan(10);
		//영향을 받은 행이 1개(한 명의 유저가 하나의 반납 기록을 삭제)이면 성공
		if(rc == 1) {
			System.out.println("delete 성공");
		}
		
		//memberNo가 2인 유저가 가지고 있는 반납 목록
		ll = ld.getLoanList(2, false);
		//대출 목록이 있어야 리스트 출력 
		if(ll != null) {
			System.out.println("=== LoanReturnList ===");
			for (Loan loan : ll) {
				System.out.println(loan);
			}
		} else {
			System.out.println("반납 목록 없음");
		}
		
	}

}

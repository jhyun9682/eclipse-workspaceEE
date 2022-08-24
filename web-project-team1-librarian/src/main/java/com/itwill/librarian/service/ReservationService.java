package com.itwill.librarian.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.librarian.dao.BookDao;
import com.itwill.librarian.dao.MemberDao;
import com.itwill.librarian.dao.ReservationDao;
import com.itwill.librarian.domain.Reservation;
import com.itwill.librarian.domain.Book;

public class ReservationService {

	private ReservationDao reservationDao;
	private BookDao bookDao;
	private MemberDao memberDao;
	
	public ReservationService() throws Exception{
		reservationDao = new ReservationDao();
		bookDao = new BookDao();
		memberDao = new MemberDao();
	}
	
	//한 멤버의 예약 도서 목록
	public ArrayList<Reservation> getReservationsList(int memberNo) throws Exception{
		return reservationDao.getReservationList(memberNo);
	}
	
	//예약된 책 목록
	public ArrayList<Book> getReservationBookList(int memberNo) throws Exception{
		ArrayList<Book> reservationBookList = null;

		//예약 목록을 불러오는데 없다면 null
		List<Reservation> reservationList = reservationDao.getReservationList(memberNo);
		
		//null이 아닌 예약 목록이 있다면 책의 정보를 담음
		if (!reservationList.isEmpty()) {
			reservationBookList = new ArrayList<Book>();
			
			for (Reservation reservation : reservationList) {
				reservationBookList.add(bookDao.getBookByNo(reservation.getBookNo()));
			}
		}
		return reservationBookList;
	}
	
	
	
	
	//예약 1개 추가
	public int addReservation(Reservation reservation) throws Exception{
		
		boolean isExist = reservationDao.isExistReservationBook(reservation);
		
		if(isExist==true) {
			return 0; 
		} else {
	
		//멤버 예약 추가
		int memberNo = reservation.getMemberNo();
		memberDao.modifyMemberReservation(memberNo, true);
		//책 예약 추가
		bookDao.addBookReservation(reservation.getBookNo());
		}
		
		return reservationDao.addReservation(reservation);
	}
	
	//예약 1개 삭제
	public int removeReservation(Reservation reservation) throws Exception{
		
		//멤버 예약 삭제
		int memberNo = reservation.getMemberNo();
		memberDao.modifyMemberReservation(memberNo, false);
		//책 예약 삭제
		bookDao.subBookReservation(reservation.getBookNo());
		return reservationDao.removeReservation(reservation);
	}
	
	//예약 전체 삭제
	public int removeAllReservation(int memberNo) throws Exception{
		return reservationDao.removeAllReservation(memberNo);
	}
	
	//1명의 예약 도서 개수
	
	public int getReservationCount(int MemberNo) throws Exception{
		return reservationDao.getreservationCount(MemberNo);
	}
	
	
}






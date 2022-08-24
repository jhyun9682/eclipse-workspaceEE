package com.itwill.librarian.dao.test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.itwill.librarian.dao.ReservationDao;
import com.itwill.librarian.domain.Reservation;

public class ReservationDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		ReservationDao reservationDao = new ReservationDao();
		
		System.out.println("--------reservation delete------");
		//System.out.println(reservationDao.deleteReservation(new Reservation(11, "38")));
		System.out.println(reservationDao.removeReservation(new Reservation(6, "12")));
		
		System.out.println("--------reservation delete All------");
		//System.out.println(reservationDao.removeAllReservation(11));
		
		
		
		
		System.out.println("--------reservation count------");
		//System.out.println(reservationDao.getreservationCount(3));
		

		
		//System.out.println(reservationDao.addReservation(new Reservation(6, "1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-01"))));
		//System.out.println(reservationDao.addReservation(new Reservation(6, "2", new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-01"))));
		//System.out.println(reservationDao.addReservation(new Reservation(6, "3", new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-01"))));
		//System.out.println(reservationDao.addReservation(new Reservation(2, "33")));
		
		System.out.println("--------reservation list------");
		System.out.println(reservationDao.getReservationList(125));
		
		System.out.println("--------reservation isExist------");
		//System.out.println(reservationDao.isExistReservationBook(new Reservation(125, "9")));
		
		System.out.println("--------reservation add------");
		//System.out.println(reservationDao.addReservation(new Reservation(125, "9")));
	}

}

package com.itwill.librarian.dao.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itwill.librarian.dao.HopeBookDao;
import com.itwill.librarian.domain.HopeBook;
import com.itwill.librarian.sql.HopeBookSql;

public class HopeBookDaoTestMain {
	public static void main(String[] args) throws Exception {
		 HopeBookDao hopeBookDao = new HopeBookDao();		 
		
		 /*
		ArrayList<HopeBook> hopeBookList = hopeBookDao.getHopeBookList(1,5);
		for (HopeBook hopeBook : hopeBookList) {
			System.out.println(hopeBook);
		}
		System.out.println(hopeBookDao.getHopeByBookTitle("상속자들"));
		*/
		/*
		System.out.println("1. HopeBook List 전체 출력");
		ArrayList<HopeBook> hopeBookList = hopeBookDao.getHopeBookList();
		for (HopeBook hopeBook : hopeBookList) {
			System.out.println(hopeBook);
		}
		 */
		 /*
		System.out.println("2. HopeBook ADD 출력");
		HopeBook hopeBook = new HopeBook(101,2,"채크","출판사","작가",0,new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-20"));
		System.out.println(hopeBookDao.addHopeBook(hopeBook));
		*/
		 //BOOK_TITLE로 상세 검색
		/*
  		System.out.println("3. HopeBook DETAIL 출력");
		System.out.println(hopeBookDao.getHopeByBookTitle("상속자들"));
		*/
		
		 
	}
}

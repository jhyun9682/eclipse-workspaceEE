package com.itwill.librarian.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.librarian.common.PageMaker;
import com.itwill.librarian.dao.HopeBookDao;
import com.itwill.librarian.domain.HopeBook;
import com.itwill.librarian.domain.PageMakerDto;

public class HopeBookService {
	private HopeBookDao hopeBookDao;

	public HopeBookService() throws Exception {
		hopeBookDao = new HopeBookDao();
	}

	/**
	 * 상세페이지
	 * 
	 * @param currentPage(현재 페이지)
	 * @return
	 * @throws Exception
	 */
	/*public PageMakerDto<HopeBook> getHopeBookList(int currentPage) throws Exception {
		// 전체 글의 개수
		int totRecordCount = hopeBookDao.getHopeBookCount();
		// paging 계산(PageMaker 유틸클래스)
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage);
		// 게시물 데이터 얻기
		List<HopeBook> hopeBookList = hopeBookDao.getHopeBookList(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<HopeBook> pageMakerHopeBookList = new PageMakerDto<HopeBook>(hopeBookList, pageMaker,
				totRecordCount);
		return pageMakerHopeBookList;
	}*/
	
	
	public ArrayList<HopeBook> getHopeBookList(int memberNo) throws Exception{
		return hopeBookDao.getHopeBookList(memberNo);
	}

	/**
	 * HopeBook 상세페이지 조회
	 * 
	 * @param BookTitle
	 * @return
	 * @throws Exception
	 */
	public HopeBook getHopeByBookTitle(String BookTitle) throws Exception {
		return hopeBookDao.getHopeByBookTitle(BookTitle);
	}

	/**
	 * 희망도서 생성
	 * 
	 * @param hopebook
	 * @return
	 * @throws Exception
	 */
	public int addHopeBook(HopeBook hopebook) throws Exception {
		return hopeBookDao.addHopeBook(hopebook);
	}
}

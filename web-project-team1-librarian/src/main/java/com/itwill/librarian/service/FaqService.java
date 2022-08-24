package com.itwill.librarian.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.librarian.common.PageMaker;
import com.itwill.librarian.dao.FaqDao;
import com.itwill.librarian.domain.Faq;
import com.itwill.librarian.domain.PageMakerDto;

public class FaqService {
	private FaqDao faqDao;
	
	public FaqService() throws Exception{
		faqDao = new FaqDao();
	}
	
	public PageMakerDto<Faq> getFaqList(int currentPage) throws Exception {
		//전체 글 개수
		int totRecordCount = faqDao.getFaqCount();
		//Paging 계산(PageMaker 유틸클래스)
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage);
		//게시물 데이터 얻기
		List<Faq> faqList = faqDao.getFaqList(pageMaker.getPageBegin(),
											  pageMaker.getPageEnd());
		PageMakerDto<Faq> pageMakerFaqList = new PageMakerDto<Faq>(faqList, pageMaker, totRecordCount);
		return pageMakerFaqList;
		
	}
	
	public ArrayList<Faq> getFaqList() throws Exception {
		return faqDao.getFaqList(0, 0); //이거 인자는 왜 있는거죠? 함수에서 인자를 활용하는게 없습니다
	}
	
	// FAQ 상세 페이지 조회
	public Faq getFaqByNo(int faqNo) throws Exception{
		return faqDao.getFaqByNo(faqNo);
	}
	
}

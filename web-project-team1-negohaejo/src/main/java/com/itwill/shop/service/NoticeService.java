package com.itwill.shop.service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.dao.NoticeDao;
import com.itwill.shop.dto.Notice;
import com.itwill.shop.dto.NoticeListPageMakerDto;
import com.itwill.shop.dto.PageInputDto;
import com.itwill.shop.util.PageMaker;

public class NoticeService {
	private NoticeDao noticeDao;
	public NoticeService() throws Exception{
		noticeDao = new NoticeDao();
	}
	
	//공지글 작성
	public int create(Notice notice) throws Exception{
		return noticeDao.create(notice);
	}
	
	//공지글 수정
	public int update(Notice notice)throws Exception{
		return noticeDao.update(notice);
	}
	
	//공지글 보기(상세보기)
	public Notice selectByNo(int noti_no) throws Exception{
		return noticeDao.selectByNo(noti_no);
	}
	
	//공지글 전체보기(리스트)
	public List<Notice> selectAll() throws Exception{
		return noticeDao.selectAll();
	}
	
	//공지글 삭제
	public int delete(int noti_no) throws Exception{
		return noticeDao.remove(noti_no);
	}
	//게시물리스트
	public NoticeListPageMakerDto findNoticeList(int currentPage) throws Exception{
		int totalRecordCount = noticeDao.getNoticeCount();
		
		PageMaker pageMaker = new PageMaker(totalRecordCount,currentPage);
		      
		List<Notice> noticeList=
				noticeDao.findNoticeList(pageMaker.getPageBegin(),pageMaker.getPageEnd());
		NoticeListPageMakerDto pageMakerNoticeList = new NoticeListPageMakerDto();
		pageMakerNoticeList.totRecordCount=totalRecordCount;
		pageMakerNoticeList.itemList=noticeList;
		pageMakerNoticeList.pageMaker=pageMaker;
		return pageMakerNoticeList;
	}
	
	
	
	
	
}





















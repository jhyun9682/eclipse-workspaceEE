package com.itwill.librarian.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.librarian.common.PageMaker;
import com.itwill.librarian.dao.NoticeDao;
import com.itwill.librarian.domain.*;

public class NoticeService {
	private static NoticeService _instance;
	
	private NoticeDao noticeDao;
	public NoticeService() {
		noticeDao = new NoticeDao();
	}
	public static NoticeService getInstance() throws Exception{
		if(_instance==null) {
			_instance=new NoticeService();
		}
		return _instance;
	}
	
	// 공지사항 목록 조회
	public PageMakerDto<Notice> getNoticeList(int currentPage) throws Exception {
		int totRecordCount = noticeDao.getNoticeCount();
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 10, 10);
		List<Notice> noticeList = noticeDao.getNoticeList(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<Notice> pageMakerNoticeList = new PageMakerDto<Notice>(noticeList, pageMaker, totRecordCount);
		return pageMakerNoticeList;
	}
	
//	public NoticeListPageDto getNoticeList(NoticePageInputDto pageConfig) throws Exception{
//		//1.전체글의 갯수
//		int totalRecordCount = noticeDao.getNoticeCount();
//		//2.paging계산(PageCounter 유틸클래스)
//		//BoardListPageDto 클래스-->결과데이타 DTO,VO(Board ArrayList + Paging)
//		NoticeListPageDto boardListPageDto=NoticePageCalculator.getPagingInfo(
//								Integer.parseInt(pageConfig.getSelectPage()),
//								pageConfig.getRowCountPerPage(),
//								pageConfig.getPageCountPerPage(),
//								totalRecordCount);
//		
//		//3.게시물 데이터 얻기
//		List<Notice> noticeList=
//				noticeDao.getNoticeList(boardListPageDto.getStartRowNum(), boardListPageDto.getEndRowNum());
//		boardListPageDto.setList(noticeList);
//		return boardListPageDto;
//	}
	
	// 공지사항 상세 조회
	public Notice getNoticeDetail(int noticeNo) throws Exception{
		return noticeDao.getNoticeDetail(noticeNo);
	}
	
	// 공지사항 추가
	public int addNotice(Notice notice) throws Exception{
		return noticeDao.addNotice(notice);
	}
	
	// 공지사항 수정
	public void modifyNotice(Notice notice) throws Exception{
		noticeDao.modifyNotice(notice);
	}
	
	// 공지사항 삭제
	public int removeNotice(int noticeNo) throws Exception{
		return noticeDao.removeNotice(noticeNo);
	}

	// 공지사항 조회수 증가
	public void updateHitCount(int noticeNo) throws Exception{
		noticeDao.increaseNoticeReadCount(noticeNo);
	}

}

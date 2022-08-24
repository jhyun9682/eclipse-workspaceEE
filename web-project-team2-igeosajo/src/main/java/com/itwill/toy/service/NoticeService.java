package com.itwill.toy.service;

import java.util.List;

import com.itwill.toy.common.PageMaker;
import com.itwill.toy.dao.NoticeDao;
import com.itwill.toy.domain.Notice;
import com.itwill.toy.domain.PageMakerDto;

public class NoticeService {
	private NoticeDao noticeDao;

	public NoticeService() {
		noticeDao = new NoticeDao();
	}

	/*
	 * 공지사항 목록 조회
	 */
	public PageMakerDto<Notice> selectNoticeList(int currentPage) throws Exception {
		int totRecordCount = noticeDao.selectNoticeCount();
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 10, 10);
		List<Notice> noticeList = noticeDao.selectNoticeList(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<Notice> pageMakerNoticeList = new PageMakerDto<Notice>(noticeList, pageMaker, totRecordCount);
		return pageMakerNoticeList;
	}

	/*
	 * 공지사항 상세 조회
	 */
	public Notice selectNoticeDetail(int noticeNo) throws Exception {
		return noticeDao.selectNoticeDetail(noticeNo);
	}

	/*
	 * 공지사항 조회수 증가
	 */
	public void updateNoticeReadCount(int n_no) throws Exception {
		noticeDao.updateReadCount(n_no);
	}

	/*
	 * 공지사항 총 개수 반환
	 */
	public int selectNoticeCount() throws Exception {
		return noticeDao.selectNoticeCount();
	}

}

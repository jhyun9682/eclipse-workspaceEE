package com.itwill.toy.dao.test;

import java.util.ArrayList;

import com.itwill.toy.dao.NoticeDao;
import com.itwill.toy.domain.Notice;

public class NoticeDaoTestMain {
	
	public static void main(String[] args) throws Exception {
		NoticeDao noticeDao = new NoticeDao();
		
		ArrayList<Notice> noticeList = noticeDao.selectNoticeList(1, 10);
		System.out.println("noticeList >>>>");
		System.out.println(noticeList);
		System.out.println("noticeCount >>>>");
		System.out.println(noticeDao.selectNoticeCount());
		System.out.println("noticeDetail >>>>"); 
		System.out.println(noticeDao.selectNoticeDetail(10));
		System.out.println("noticeReadCountUpdate >>>>");
		noticeDao.updateReadCount(1);
	}

}

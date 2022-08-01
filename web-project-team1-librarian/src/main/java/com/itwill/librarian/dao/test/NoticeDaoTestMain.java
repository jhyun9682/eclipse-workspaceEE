package com.itwill.librarian.dao.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.itwill.librarian.dao.NoticeDao;
import com.itwill.librarian.domain.Notice;

public class NoticeDaoTestMain {

	public static void main(String[] args) throws Exception {
		NoticeDao noticeDao = new NoticeDao();
		
//		System.out.println("==== 공지사항 목록 조회 ====");
//		ArrayList<Notice> noticeList = noticeDao.getNoticeList(1,5);
//		for(Notice notice : noticeList)
//			System.out.println(notice);
		
//		System.out.println("==== 공지사항 상세 조회 ====");
//		System.out.println(noticeDao.getNoticeDetail(1));
		
//		System.out.println("==== 공지사항 추가 ====");
//		Notice notice = new Notice(8, "공지", "내용무", new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-16"), null, 0);
//		System.out.println(noticeDao.addNotice(notice));
		
//		System.out.println("==== 공지사항 수정 ====");
//		Notice notice = new Notice(9, "공지합니다.", "내용없습니다.", new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-17"), null, 0);
//		System.out.println(noticeDao.modifyNotice(notice));
		
		System.out.println("==== 공지사항 삭제 ====");
		System.out.println(noticeDao.removeNotice(26));

	}

}

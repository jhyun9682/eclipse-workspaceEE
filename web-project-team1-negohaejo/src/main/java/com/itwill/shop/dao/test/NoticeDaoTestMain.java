package com.itwill.shop.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.dao.NoticeDao;
import com.itwill.shop.dto.Notice;

public class NoticeDaoTestMain {

	public static void main(String[] args) throws Exception {
		NoticeDao noticeDao = new NoticeDao();
		System.out.println(noticeDao.create(new Notice(1,"테스트11","테스트텍스트1",null,"첨부테스트1")));
		List<Notice> noticeList = noticeDao.selectAll();
		for (Notice notice : noticeList) {
			System.out.println(notice);
		}
		System.out.println(noticeDao.selectByNo(1));
		System.out.println(noticeDao.create(new Notice(7,"테스트","테스트텍스트",null,"첨부테스트")));
		System.out.println(noticeDao.update(new Notice(7,"테트","테트",null,"첨부테스트")));
		System.out.println(noticeDao.remove(7));
	}

}

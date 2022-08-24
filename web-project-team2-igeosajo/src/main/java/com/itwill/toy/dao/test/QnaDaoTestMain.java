package com.itwill.toy.dao.test;

import com.itwill.toy.dao.QnaDao;
import com.itwill.toy.domain.Qna;

public class QnaDaoTestMain {
	public static void main(String[] args) throws Exception {
		QnaDao qnaDao = new QnaDao();

		Qna testQna1 = new Qna();
		testQna1.setQ_no(10);
		testQna1.setQ_title("제목이다");
		testQna1.setQ_content("내용이다");
		testQna1.setQ_title("제목이다");
		testQna1.setQ_step(1);
		testQna1.setQ_depth(0);
		testQna1.setM_id("toto");
		
		Qna testQna2 = new Qna();
		testQna2.setQ_no(10);
		testQna2.setQ_title("제목이다333");
		testQna2.setQ_content("내용이다333");
		testQna2.setQ_title("제목이다333");
		testQna2.setQ_step(1);
		testQna2.setQ_depth(0);
		testQna2.setM_id("toto");
		
		System.out.println("insertTest >>>>>");
		System.out.println(qnaDao.insertNewQna(testQna1));
		System.out.println("selectQnaTest >>>>>"); 
		System.out.println(qnaDao.selectQna(10));
		System.out.println("insertReplyTest >>>>>");
		System.out.println(qnaDao.insertReply(testQna1));
		System.out.println("selectQnaList >>>>>");
		System.out.println(qnaDao.selectBoardList(30, 35));
		System.out.println("deleteQna >>>>>");
		System.out.println(qnaDao.deleteQna(20)); 
		System.out.println("updateQna >>>>>");
		System.out.println(qnaDao.updateQna(testQna2));
		System.out.println("updateQnaReadCount >>>>>");
		qnaDao.updateReadCount(8);
		System.out.println("selectQnaAllCount >>>>>");
		System.out.println(qnaDao.selectQnaCount());
		
	}
}

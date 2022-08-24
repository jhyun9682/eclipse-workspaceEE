package com.itwill.librarian.dao.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.itwill.librarian.dao.QnaDao;
import com.itwill.librarian.domain.Member;
import com.itwill.librarian.domain.Qna;
import com.itwill.librarian.domain.Reply;

public class QnaDaoTestMain {

	public static void main(String[] args) throws Exception {

		QnaDao qnaDao = new QnaDao();
		/*
		ArrayList<Qna> qnaList = qnaDao.getQnaList(10, 30);
		for(Qna qna : qnaList) {
			System.out.println(qna);
		}
		
		System.out.println(qnaDao.getQnaByNo(16));

		System.out.println("1. QNA LIST 전체 출력");
		ArrayList<Qna> qnaList = qnaDao.getQnaList();
		for (Qna qna : qnaList) {
			System.out.println(qna);
		}
		
		System.out.println("2. QNA DETAIL 출력");
		System.out.println(qnaDao.getQnaDetail(1));
		*/
		/*
		System.out.println("3. QNA ADD 출력");
		Qna addQna = new Qna(2, 100, "추가", "추가내용", new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-17"), 0, null, 0);
		int a = qnaDao.addCreate(addQna);
		System.out.println(a);
		
		System.out.println("4. QNA REMOVE 출력");
		qnaDao.removeQna(13);
		
		
		System.out.println("5. QNA MODIFIY 출력");
		Qna updateQna = new Qna(5, 6, "수정", "내용수정", null, 1, null, 10);
		qnaDao.modifyQna(updateQna);
		
		//QNA 조회수 증가
		qnaDao.increaseQnaReadCount(2);
		
		//공개여부 확인
		int a = qnaDao.openSettings(17);
		System.out.println(a);

	
		
		//답변 수정
		Reply reply = new Reply(9, "답변수정해보깅", 0, 0);
		qnaDao.modifyReply(reply);
		//답변 삭제
		qnaDao.removeReply(9);
		
		//답변 남기기
		Reply reply = new Reply(0, "퇴사준비생의 런던", 26, 20);
		qnaDao.addReply(reply);
		 */
		
		ArrayList<Qna> qnaList = qnaDao.getQnaListByTitleContent("추",1,3);
		for (Qna qna : qnaList) {
			System.out.println(qna);
		}
		
		System.out.println(qnaDao.getQnaListByTitleContentCount("용"));
	}
}
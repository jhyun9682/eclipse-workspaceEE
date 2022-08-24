package com.itwill.toy.service;

import java.util.List;

import com.itwill.toy.common.PageMaker;
import com.itwill.toy.dao.QnaDao;
import com.itwill.toy.domain.PageMakerDto;
import com.itwill.toy.domain.Qna;

public class QnaService {
	private QnaDao qnaDao;
	
	public QnaService() {
		qnaDao= new QnaDao();
	}
	
	/**
	 * 새로운 게시물을 추가하는 메써드.
	 */
	public int insertNewQna(Qna qna) throws Exception {
		return qnaDao.insertNewQna(qna);
	}
	
	/**
	 * 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	public Qna selectQna(int q_no) throws Exception {
		return qnaDao.selectQna(q_no);
	}
	
	/**
	 * 답글 게시물을 추가하는 메써드
	 */
	public int insertReply(Qna qna) throws Exception {
		return qnaDao.insertReply(qna);
	}
	
	/**
	 * 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	public PageMakerDto<Qna> selectQnaList(int currentPage) throws Exception {
		// 1.전체글의 갯수
		int totRecordCount = qnaDao.selectQnaCount();
		// 2.paging계산(PageMaker 유틸클래스)
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 10, 10);
		// 3.게시물데이타 얻기
		List<Qna> qnaList = qnaDao.selectBoardList(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<Qna> pageMakerQnaList = new PageMakerDto<Qna>(qnaList, pageMaker, totRecordCount);
		return pageMakerQnaList;
	}
	
	/**
	 * 게시물을 삭제하는 메써드
	 */
	public int deleteQna(int q_no) throws Exception {
		return qnaDao.deleteQna(q_no);
	}
	
	/**
	 * 게시물내용을 수정하는 메써드.
	 */
	public int updateQna(Qna qna) throws Exception {
		return qnaDao.updateQna(qna);
	}
	
	/**
	 * 게시물 조회수를 1 증가.
	 */
	public void updateReadCount(int q_no) throws Exception {
		qnaDao.updateReadCount(q_no);
	}
	
	/**
	 * 게시물 총 건수를 조회, 반환
	 */
	public int selectQnaCount() throws Exception {
		return qnaDao.selectQnaCount();
	}
	
}

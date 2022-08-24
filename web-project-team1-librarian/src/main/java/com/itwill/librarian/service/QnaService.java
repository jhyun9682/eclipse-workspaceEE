package com.itwill.librarian.service;

import java.util.List;

import com.itwill.librarian.common.PageMaker;
import com.itwill.librarian.dao.MemberDao;
import com.itwill.librarian.dao.QnaDao;
import com.itwill.librarian.dao.ReplyDao;
import com.itwill.librarian.domain.Book;
import com.itwill.librarian.domain.PageMakerDto;
import com.itwill.librarian.domain.Qna;
import com.itwill.librarian.domain.Reply;

public class QnaService {
	private QnaDao qnaDao;
	private MemberDao memberDao;
	private ReplyDao replyDao;

	public QnaService() throws Exception {
		qnaDao = new QnaDao();
	}
	
	/**
	 * QNA LIST 페이지
	 * @param currentPage (현재 페이지)
	 * @return
	 * @throws Exception
	 */
	public PageMakerDto<Qna> getQnaList(int currentPage) throws Exception {
		// 1.전체글의 갯수
		int totRecordCount = qnaDao.getQnaCount();
		// 2.paging계산(PageMaker 유틸클래스)
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage);

		// 3.게시물데이타 얻기
		List<Qna> qnaList = qnaDao.getQnaList(pageMaker.getPageBegin(), pageMaker.getPageEnd());

		PageMakerDto<Qna> pageMakerQnaList = new PageMakerDto<Qna>(qnaList, pageMaker, totRecordCount);
		
		return pageMakerQnaList;
	}
	/*
	public QnaListPageMakerDto getQnaList(int currentPage) throws Exception {
		// 1.전체글의 갯수
		int totalRecordCount = qnaDao.getQnaCount();
		// 2.paging계산(PageMaker 유틸클래스)
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);

		// 3.게시물데이타 얻기
		List<Qna> qnaList = qnaDao.getQnaList(pageMaker.getPageBegin(), pageMaker.getPageEnd());

		QnaListPageMakerDto pageMakerQnaList = new QnaListPageMakerDto();
		pageMakerQnaList.totRecordCount = totalRecordCount;
		pageMakerQnaList.itemList = qnaList;
		pageMakerQnaList.pageMaker = pageMaker;
		return pageMakerQnaList;
	}
	*/
	
	/**
	 * QNA 상세 페이지 조회
	 * @param qnaNo
	 * @return
	 * @throws Exception
	 */
	public Qna getQnaByNo(int qnaNo) throws Exception {
		return qnaDao.getQnaByNo(qnaNo);
	}

	/**
	 * QNA 작성
	 * @param qna
	 * @return
	 * @throws Exception
	 */
	public int addQna(Qna qna) throws Exception {
		return qnaDao.addQna(qna);
	}
	
	/**
	 * QNA 게시글 조회수 증가
	 * @param qnaNo
	 * @throws Exception
	 */
	public void updateHitCount(int qnaNo) throws Exception {
		qnaDao.increaseQnaReadCount(qnaNo);
	}

	/**
	 * QNA 공개 여부 설정
	 * @param qnaNo
	 * @return
	 * @throws Exception
	 */
	public int openSettings(int qnaNo) throws Exception {
		return qnaDao.openSettings(qnaNo);
	}

	/**
	 * QNA 작성 글 수정
	 * @param qna
	 * @throws Exception
	 */
	public void modifyQna(Qna qna) throws Exception {
		qnaDao.modifyQna(qna);
	}
	
	/**
	 * QNA 작성 글 삭제
	 * @param qnaNo
	 * @throws Exception
	 */
	public void removeQna(int qnaNo) throws Exception {
		qnaDao.removeQna(qnaNo);
	}

	/**
	 * QNA 답변 작성
	 * @param reply
	 * @throws Exception
	 */
	public void addReply(Reply reply) throws Exception {
		qnaDao.addReply(reply);
	}

	/**
	 * QNA 답변 삭제
	 * @param reply
	 * @throws Exception
	 */
	public void removeReply(int replyNo) throws Exception {
		qnaDao.removeReply(replyNo);
	}

	/**
	 * QNA 답변 수정
	 * @param reply
	 * @throws Exception
	 */
	public void modifyReply(Reply reply) throws Exception {
		qnaDao.modifyReply(reply);
	}
	
	/**
	 * QNA 제목+내용 검색 페이지
	 * @param keyword
	 * @param currentPage
	 * @return PageMakerList
	 * @throws Exception
	 */
	public PageMakerDto<Qna> getQnaListByTitleContent(String keyword, int currentPage) throws Exception {
		int totRecordCount = qnaDao.getQnaListByTitleContentCount(keyword);
		PageMaker pageMaker = new PageMaker(totRecordCount, currentPage, 5, 5);
		List<Qna> qnaList = qnaDao.getQnaListByTitleContent(keyword, pageMaker.getPageBegin(), pageMaker.getPageEnd());		
		PageMakerDto<Qna> pageMakerQnaList = new PageMakerDto<Qna>(qnaList, pageMaker, totRecordCount);
		
		return pageMakerQnaList;
	}
}

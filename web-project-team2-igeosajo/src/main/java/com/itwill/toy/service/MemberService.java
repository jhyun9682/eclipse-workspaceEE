package com.itwill.toy.service;

import java.util.List;

import com.itwill.toy.dao.MemberDao;
import com.itwill.toy.domain.Member;

public class MemberService {
	private MemberDao memberDao;

	public MemberService() throws Exception {
		memberDao = new MemberDao();
	}

	/*
	* 회원가입
	*/
	public int create(Member member) throws Exception {
		// 1.아이디중복체크
		if (memberDao.existedMember(member.getM_id())) {
			// 중복
			return -1;
		} else {
			// 가입
			int rowCount = memberDao.create(member);
			return rowCount;
		}

	}

	/*
	* 회원로그인
	*/
	public int login(String m_id, String m_password) throws Exception {
		/*
		 * 0:실패
		 * 1:성공
		 */
		int loginResult = 0;
		if (memberDao.existedMember(m_id)) {
			// 아이디 존재
			Member loginMember = memberDao.findMember(m_id);
			if (loginMember.getM_password().equals(m_password)) {
				// 비밀번호 O
				loginResult = 1;
			} else {
				// 비밀번호 x
				loginResult = 0;
			}
		} else {
			// 회원존재x
			loginResult = 2;
		}
		return loginResult;

	}

	/* 
	 *회원전체검색
	 */
	public List<Member> findAll() throws Exception {
		List<Member> memberList = memberDao.selectAll();
		return memberList;

	}

	/*
	 * 회원 정보 찾기
	 */
	public Member findMember(String m_id) throws Exception {
		return memberDao.findMember(m_id);
	}

	/*
	 * 회원 정보 수정
	 */
	public int updateAll(Member member) throws Exception {
		return memberDao.update(member);
	}

	/*
	 *회원 비밀번호 변경
	 */
	public int updatePassword(Member member) throws Exception {
		return memberDao.updatePassword(member);
	}

	/*
	 * 회원 적립금 수정
	 */
	public int updatePoint(Member member) throws Exception {
		return memberDao.updatePoint(member);
	}

	/*
	 *회원 탈퇴
	 */
	public int remove(String m_id) throws Exception {
		return memberDao.remove(m_id);
	}

	/*
	 * 회원 아이디 중복 확인
	 */

	public boolean existedMember(String m_id) throws Exception {
		return memberDao.existedMember(m_id);
	}

}
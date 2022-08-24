package com.itwill.librarian.service;

import com.itwill.librarian.dao.MemberDao;
import com.itwill.librarian.domain.Member;

public class MemberService {

	private MemberDao memberDao;

	public MemberService() {
		this.memberDao = new MemberDao();
	}
	
	//멤버 로그인 확인
	public Member login(String memberId, String memberPass) throws Exception {
		//memberId로 회원의 정보를 가져옴
		Member member = memberDao.getMember(memberId);
		
		//member가 null이면 가입된 회원이 아니고 맞다면 비밀번호까지 확인
		if(member != null && member.getMemberPass().equals(memberPass)) {
			return member;
		}
		
		return null;
	}
	
	//멤버 번호로 정보 보기
	public Member getMember(int memberNo) throws Exception {
		return memberDao.getMember(memberNo);
	}
	
	//ID 중복 확인
	public boolean isDuplicateId(String memberId) throws Exception {
		Member isExistId = memberDao.getMember(memberId);
		
		//중복이 아니면 true
		if(isExistId == null) {
			return true;
		}
		
		//중복 되면 false
		return false;
	}
	
	//멤버 회원 가입
	public int addMember(Member newMember) throws Exception {
		//newMember의 ID가 존재하지 않는다면 addMember
		if(isDuplicateId(newMember.getMemberId())) {
			return memberDao.addMember(newMember);
		}
		
		return 0;
	}
	
	//멤버 정보 수정
	public int modifyMember(Member member) throws Exception {
		return memberDao.modifyMember(member);
	}
	
	//멤버 회원 탈퇴
	public int removeMember(int memberNo) throws Exception {
		return memberDao.removeMember(memberNo);
	}
	
	//도서 대출 시 제약 증가
	public int increaseMemberLoan(int memberNo) throws Exception {
		return memberDao.modifyMemberLoan(memberNo, true);
	}
	
	//대출 반납 시 제약 감소
	public int decreaseMemberLoan(int memberNo) throws Exception {
		return memberDao.modifyMemberLoan(memberNo, false);
	}
	
	//예약 시 제약 증가
	public int increaseMemberReservation(int memberNo) throws Exception {
		return memberDao.modifyMemberReservation(memberNo, false);
	}
	
	//예약 제거 시 제약 감소
	public int decreaseMemberReservation(int memberNo) throws Exception {
		return memberDao.modifyMemberReservation(memberNo, false);
	}
	
	
}

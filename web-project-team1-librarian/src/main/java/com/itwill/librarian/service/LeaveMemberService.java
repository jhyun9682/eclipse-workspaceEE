package com.itwill.librarian.service;

import java.util.ArrayList;

import com.itwill.librarian.dao.LeaveMemberDao;
import com.itwill.librarian.domain.LeaveMember;

public class LeaveMemberService {
	private LeaveMemberDao leaveMemberDao;
	public LeaveMemberService() {
		leaveMemberDao = new LeaveMemberDao();
	}
	
	// 회원 삭제(요건 Member에 있습니다)
	public int removeMember(int memberNo) throws Exception{
		return leaveMemberDao.removeMember(memberNo);
	}
	
	// 탈퇴회원 추가
	public int addLeaveMember(LeaveMember leaveMember) throws Exception{
		return leaveMemberDao.addLeaveMember(leaveMember);
	}
	
	// 탈퇴회원 목록 조회
	public ArrayList<LeaveMember> getLeaveMemberList() throws Exception{
		return leaveMemberDao.getLeaveMemberList();
	}

}

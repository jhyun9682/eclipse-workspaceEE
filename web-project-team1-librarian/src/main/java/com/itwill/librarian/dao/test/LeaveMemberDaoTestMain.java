package com.itwill.librarian.dao.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.itwill.librarian.dao.LeaveMemberDao;
import com.itwill.librarian.domain.LeaveMember;

public class LeaveMemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		LeaveMemberDao leaveMemberDao = new LeaveMemberDao();
		
//		System.out.println("==== 회원 삭제 ====");
//		System.out.println(leaveMemberDao.removeMember(101));
		
//		System.out.println("==== 탈퇴회원 추가 ====");
//		LeaveMember leaveMember = new LeaveMember(102, "육칠팔", null, new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-15"));
//		System.out.println(leaveMemberDao.addLeaveMember(leaveMember));
		
		System.out.println("==== 탈퇴회원 목록 조회 ====");
		ArrayList<LeaveMember> leaveMemberList = leaveMemberDao.getLeaveMemberList();
		for(LeaveMember leaveMember : leaveMemberList)
			System.out.println(leaveMember);

	}

}

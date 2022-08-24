package com.itwill.toy.dao.test;

import java.util.ArrayList;

import com.itwill.toy.dao.MemberDao;
import com.itwill.toy.domain.Member;

public class MemberDaoTestMain {
	public static void main(String[] args) throws Exception{
		MemberDao memberDao = new MemberDao();
		
		ArrayList<Member> MemberList = memberDao.selectAll();
		System.out.println(MemberList);
		System.out.println(memberDao.existedMember("wpig1"));
		System.out.println(memberDao.findMember("wpig1"));
		System.out.println(memberDao.update(new Member("wpig1", "12312313", "이름테스트", "test11@naver.com", null,null, "테스트동", "010-0000-0000", 0)));
		System.out.println(memberDao.remove("test12"));
		System.out.println(memberDao.create(new Member("test12", "11111111", "이차돌", "테스느@naver.com", "888888", "M", "안동", "010-1212-1212", 1000)));
		System.out.println(memberDao.updatePassword(new Member("test12", "changepasstest", null, null, null, null, null, null, 0)));
		
	}

}

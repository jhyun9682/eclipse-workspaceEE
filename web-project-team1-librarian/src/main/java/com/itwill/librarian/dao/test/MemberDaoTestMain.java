package com.itwill.librarian.dao.test;

import com.itwill.librarian.dao.MemberDao;
import com.itwill.librarian.domain.Member;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		MemberDao memberDao = new MemberDao();
		int rc = 0;
		
		Member m = memberDao.getMember(2);
		
		System.out.println("=== Member ===");
		System.out.println(m);
		
		rc = memberDao.addMember(m);
		m = memberDao.getMember(103);
		
		System.out.println("=== Member ===");
		System.out.println(m);
		
		m.setMemberId("woguq");
		rc = memberDao.modifyMember(m);
		
		System.out.println("=== Member ===");
		System.out.println(m);
		
		rc = memberDao.removeMember(103);
		if(rc == 1) {
			System.out.println("delete memberNo");
		}
		
	}

}

package com.itwill.toy.dao.test;

import com.itwill.toy.domain.Member;
import com.itwill.toy.service.MemberService;

public class MemberServiceTestMain {

	public static void main(String[] args) throws Exception{
		MemberService memberService = new MemberService();
		System.out.println("1.회원가입");
		int rowCount = memberService.create(new Member("shuttle1","1111","이도영","shuttle1@gmail.com",null,null,"테스트동","010-1111-1111",1000));
		System.out.println(">>"+rowCount);
		System.out.println("2.로그인");
	    int result = memberService.login("shuttle1", "1111");
	    System.out.println("성공:"+result);
	    result = memberService.login("yyyy", "2222");
	    System.out.println("실패:"+result);
	    result = memberService.login("shutlle1", "3333");
	    System.out.println("실패:"+result);
	    System.out.println("3.수정");
	    System.out.println(">>"+rowCount);
	    System.out.println("    "+memberService.findMember("shuttle1"));
	    rowCount = memberService.updateAll(new Member("shuttle1","1111","삼도영","shuttle2@gmail.com",null,null,"테스트동2","010-2222-2222",2000));
	    System.out.println("4.수정(적립금)");
	    rowCount = memberService.updatePoint(new Member("shuttle1",null, null, null, null, null, null, null, 0));
	    System.out.println(">>"+rowCount);
	    System.out.println("    "+memberService.findMember("shuttle1"));
	    System.out.println("5.삭제");
	    rowCount = memberService.remove("shuttle1");
	    System.out.println(">>"+rowCount);
	  

	}

}

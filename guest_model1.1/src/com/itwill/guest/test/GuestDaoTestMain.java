package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		GuestDao guestDao=new GuestDao();
		System.out.println("------insertGuest-------");
		//System.out.println(guestDao.insertGuest(new Guest(0, "이름", null, "guard@naver.com", "http://www.naver.com", "타이틀", "컨텐트")));
		System.out.println("------updateGuest-------");
		System.out.println(guestDao.updateGuest(new Guest(12, "변경이름", null, 
												"change@naver.com", "http://www.change.co.kr",
												"변경타이틀", "변경컨텐트")));
		System.out.println("------deleteGuest-------");
		System.out.println(guestDao.deleteGuest(11));
		System.out.println("------selectByNo-------");
		System.out.println(guestDao.selectByNo(12));
		System.out.println("------selectAll-------");
		System.out.println(guestDao.selectAll());
	}

}

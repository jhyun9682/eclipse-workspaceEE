package com.itwill.shop.dao.test;

import com.itwill.shop.dto.Notice;
import com.itwill.shop.service.NoticeService;

public class NoticeServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		NoticeService noticeService = new NoticeService();
		Notice newNotice = new Notice(0,"테스트","테스트트",null,"테스트파일");
		Notice updateNotice = new Notice(1,"업데이트","업데이트테스트",null,"업데이트테스트파일");
				
		System.out.println(noticeService.create(newNotice));
		System.out.println(noticeService.selectAll());
		System.out.println(noticeService.selectByNo(1));
		
		System.out.println(noticeService.update(updateNotice));
		System.out.println(noticeService.delete(2));
		
	}

}

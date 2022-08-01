package com.itwill.shop.dto;


import java.util.List;

import com.itwill.shop.util.PageMaker;

// 리스트 페이지에서 출력에 필요한 테이블 데이터 및 페이징 처리에 필요한 정보빈
public class NoticeListPageMakerDto {
	public List<Notice> itemList; 		// 리스트 데이터 콜렉션
	public PageMaker pageMaker;
	public int totRecordCount;
}

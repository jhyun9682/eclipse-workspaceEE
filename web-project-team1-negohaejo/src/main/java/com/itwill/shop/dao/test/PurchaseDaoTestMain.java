package com.itwill.shop.dao.test;


import java.util.ArrayList;

import com.itwill.shop.dao.ProductDao;
import com.itwill.shop.dao.PurchaseDao;
import com.itwill.shop.dto.Product;
import com.itwill.shop.dto.Purchase;
import java.util.List;

import com.itwill.shop.dao.PurchaseDao;

import com.itwill.shop.dto.Purchase_Item;

public class PurchaseDaoTestMain {

	public static void main(String[] args) throws Exception {
		PurchaseDao purchaseDao = new PurchaseDao();
		/*
		System.out.println("test1아이디 결제 전체 삭제");
		purchaseDao.purchaseDeleteById("test1");
		
		
		System.out.println("주문번호 3 삭제");
		purchaseDao.purchaseDeleteByNo(3);
	*/
		System.out.println("아아디로 결제정보 출력");
		System.out.println(purchaseDao.list("test4"));
        /*
		System.out.println("주문번호 결제 조회");
		System.out.println(purchaseDao.detail(5));
		System.out.println(purchaseDao.detail(4));
	    */
	
		
		System.out.println("주문생성");
		
		ProductDao productDao = new ProductDao();
		ArrayList<Purchase_Item> purchase_Itemlist= new ArrayList<Purchase_Item>();
		purchase_Itemlist.add(new Purchase_Item(0,1,0,productDao.selectByNo(1)));
		
		int i=purchaseDao.purchaseCreate(new Purchase(0,1,"card",purchase_Itemlist.get(0).getProduct().getP_price(),
				"test1",purchase_Itemlist));
		System.out.println(i);

		
	}

}

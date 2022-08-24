package com.itwill.toy.dao.test;

import com.itwill.toy.dao.ProductDao;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDao productDao=new ProductDao();
		System.out.println(productDao.getProduct(1));
		System.out.println(productDao.getProductList());

	}

}

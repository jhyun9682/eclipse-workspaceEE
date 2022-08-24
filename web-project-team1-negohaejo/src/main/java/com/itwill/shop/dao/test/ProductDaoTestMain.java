package com.itwill.shop.dao.test;

import java.util.ArrayList;

import com.itwill.shop.dao.ProductDao;
import com.itwill.shop.dto.Product;
import com.itwill.shop.dto.Review;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {

		ProductDao productDao = new ProductDao();
		
		Product product = productDao.selectByNo(1);
		System.out.println(product);
		System.out.println(product.getReviewScoreAvg());
		for(Review review : product.getReviewList()) {
			System.out.println(review);
		}
		System.out.println(product.getReviewList());
	
		// 전체출력
		ArrayList<Product> productList = productDao.selectAll();
		for (Product product1 : productList) {
			System.out.println(product1);
			System.out.println(product1.getReviewScoreAvg());
		}
		productList = productDao.selectbyCat("chair");
		for (Product product1 : productList) {
			System.out.println(product1);
			product1.getReviewScoreAvg();
			System.out.println(product1.getReviewScoreAvg());
			}
		productList=productDao.select("조은", "chair", "p_date", "desc");
		for (Product product1 : productList) {
			System.out.println(product1);
			System.out.println(product1.getReviewScoreAvg());
		}
		}

	}

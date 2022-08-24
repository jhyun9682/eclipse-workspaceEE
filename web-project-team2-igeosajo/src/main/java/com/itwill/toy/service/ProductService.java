package com.itwill.toy.service;

import java.util.ArrayList;

import com.itwill.toy.dao.ProductDao;
import com.itwill.toy.domain.Product;

public class ProductService {
	private ProductDao productDao;
	
	public ProductService() throws Exception{
		productDao = new ProductDao();
	}
	
	public ArrayList<Product> getProductList() throws Exception{
		ArrayList<Product> productList = productDao.getProductList();
		return productList;
	}
	
	public Product getProduct(int p_no) throws Exception{
		 return productDao.getProduct(p_no);
	}
	
	
}

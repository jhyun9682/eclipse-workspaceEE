package com.itwill.shop.service;

import java.util.ArrayList;

import com.itwill.shop.dao.ProductDao;
import com.itwill.shop.dto.Product;

public class ProductService {
	private ProductDao productDao;
	
	public ProductService() throws Exception{
		productDao=new ProductDao();
	}
	
	//Product 리스트 반환
	public ArrayList<Product> getProductList() throws Exception{
		return productDao.selectAll();
		
	}
	//Product 리스트 반환(카테고리별)
	public ArrayList<Product> getProductByCat(String p_cat) throws Exception{
		return productDao.selectbyCat(p_cat);
	}
	
	//Product 1개 반환 by no
	public Product getProductByNo(int p_no) throws Exception{
		return productDao.selectByNo(p_no);
	}
	public ArrayList<Product> select(String keyword,String p_cat, String ord, String sc) throws Exception{
		return productDao.select(keyword, p_cat, ord, sc);
	}
	
}

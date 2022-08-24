package com.itwill.shop.service;

import java.util.ArrayList;

import com.itwill.shop.dao.CartDao;
import com.itwill.shop.dto.Cart;

public class CartService {
	private CartDao cartDao;
	public CartService() throws Exception{
		cartDao = new CartDao();
	}
	
	//카트추가 or 수정
	public int addCart(String u_id, int p_no, int c_qty) throws Exception{
		if(cartDao.isProductExist(u_id, p_no)) {
			return cartDao.update(u_id, p_no, c_qty);
		}else {
			return cartDao.add(u_id, p_no, c_qty);
		}
	}
	
	//카트수량변경
	public int updateCart(int c_no, int c_qty) throws Exception {
		return cartDao.update(c_qty, c_no);
	}

	//유저 아이디로 카트리스트 보기
	public ArrayList<Cart> getCartList(String u_id) throws Exception{
		return cartDao.getCartList(u_id);
	}
	
	//카트 아이템 1개 보기
	public Cart getCartByCartNo(int c_no) throws Exception{
		return cartDao.getCartByCartNo(c_no);
	}
	
	//유저아이디로 카트 삭제
	public int deleteCart(String u_id)throws Exception{
		return cartDao.deleteCart(u_id);
	}
	
	//카트번호로 카트 삭제
	public int deleteCart(int c_no) throws Exception{
		return cartDao.deleteCart(c_no);
	}


}//end class

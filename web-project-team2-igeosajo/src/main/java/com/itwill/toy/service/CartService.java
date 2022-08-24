package com.itwill.toy.service;

import java.util.ArrayList;
import com.itwill.toy.dao.CartDao;
import com.itwill.toy.domain.Cart;

public class CartService {
	private CartDao cartDao;
	public CartService() throws Exception {
		cartDao=new CartDao();
	}
	
	/*
	 * 카트추가 or 수정
	 */
	public int addCart(int c_qty,int p_no,String sUserId)throws Exception {
		if(cartDao.isProductExist(sUserId, p_no)) {
			return cartDao.update(c_qty, p_no, sUserId);
		}else {
			return cartDao.add(c_qty, p_no, sUserId);
		}
	}
	/*
	 * 카트수량변경수정
	 */
	public int updateCart(int c_no,int c_qty)throws Exception {
		return cartDao.update(c_no, c_qty);
	}
	/*
	 * 카트보기
	 */
	public ArrayList<Cart> getCartList(String sUserId) throws Exception{
		return cartDao.getCartList(sUserId);
	}
	/*
	 * 카트아이템1개보기
	 */
	public Cart getCartItemByCartNo(int c_no) throws Exception{
		return cartDao.getCartItemByCartNo(c_no);
	}
	
	/*
	 * 카트아이템1개삭제
	 */
	public int deleteCartItem(int c_no) throws Exception{
		return cartDao.deleteCartByNo(c_no);
	}
	/*
	 * 카트삭제
	 */
	public int deleteCart(String sUserId)throws Exception {
		return cartDao.deleteCart(sUserId);
	}
}

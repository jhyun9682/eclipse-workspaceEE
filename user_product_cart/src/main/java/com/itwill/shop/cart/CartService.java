package com.itwill.shop.cart;


import java.util.List;

public class CartService {
	private CartDao cartDao;
	public CartService() throws Exception {
		cartDao=new CartDao();
	}
	/*
	 * 카트추가 or 수정
	 */
	public int addCart(CartItem cartItem)throws Exception {
		int product_count=cartDao.cartProductCount(cartItem);
		if(product_count==0) {
			//insert
			cartDao.add(cartItem);
		}else if(product_count==1) {
			//update
			cartDao.updateByProductNoAndUserId(cartItem);
		}
		return 0;
	}
	
	/*
	 * 카트추가 or 수정
	 */
	public int addCart(String sUserId,int p_no,int cart_qty)throws Exception {
		if(cartDao.isProductExist(sUserId, p_no)) {
			return cartDao.update(sUserId, p_no, cart_qty);
		}else {
			return cartDao.add(sUserId, p_no, cart_qty);
		}
	}
	/*
	 * 카트수량변경수정
	 */
	public int updateCart(int cart_no,int cart_qty)throws Exception {
		return cartDao.update(cart_no, cart_qty);
	}
	/*
	 * 카트리스트보기
	 */
	public List<CartItem> getCartList(String sUserId) throws Exception{
		return cartDao.getCartList(sUserId);
	}
	
	
	/*
	 * 카트아이템1개삭제
	 */
	public int deleteCartItem(int cart_no) throws Exception{
		return cartDao.deleteCartByNo(cart_no);
	}
	/*
	 * 카트삭제
	 */
	public int deleteCart(String sUserId)throws Exception {
		return cartDao.deleteCart(sUserId);
	}
}

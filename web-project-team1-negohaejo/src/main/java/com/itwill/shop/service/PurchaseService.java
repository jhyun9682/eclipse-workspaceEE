package com.itwill.shop.service;


import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.dao.CartDao;
import com.itwill.shop.dao.ProductDao;
import com.itwill.shop.dao.PurchaseDao;
import com.itwill.shop.dto.Cart;
import com.itwill.shop.dto.Product;
import com.itwill.shop.dto.Purchase;
import com.itwill.shop.dto.Purchase_Item;

public class PurchaseService {
	
	private PurchaseDao purchaseDao;
	private ProductDao productDao;
	private Purchase purchase;
	private CartDao cartDao;
	public PurchaseService() throws Exception{
		purchaseDao = new PurchaseDao();
		productDao=new ProductDao();
		cartDao=new CartDao();
		
	}
	
	//주문생성
	public int p_Create(String u_id, String o_payselect) throws Exception{
		
		    List<Cart> cartList=cartDao.getCartList(u_id);
		    List<Purchase_Item> purchaseItemList=new ArrayList<Purchase_Item>();
		    int p_tot_price=0;
		    for(Cart cartItem:cartList){
		    	// oi_No, int oi_Qty, int o_No, Product product
		    	Product p=new Product();
		    	p.setP_no(cartItem.getProduct().getP_no());
		    	purchaseItemList.add(new Purchase_Item(0,cartItem.getC_qty(),0,p));
		    	
		    	p_tot_price+=cartItem.getProduct().getP_price()*cartItem.getC_qty();
		    }
		    
		    Purchase newPurchase=new Purchase(0,purchaseItemList.size(),o_payselect,p_tot_price,u_id,purchaseItemList);
		    purchaseDao.purchaseCreate(newPurchase);
		    cartDao.deleteCart(u_id);
		   return 0;
	}
	
	//아이디로 결제 삭제
	public int p_deleteById(String u_id) throws Exception{
		return purchaseDao.purchaseDeleteById(u_id);
	}
	
	//주문번호로 결제 삭제
	public int p_deleteByNo(int o_no) throws Exception{
		return purchaseDao.purchaseDeleteByNo(o_no);
	}
	
	//아이디로 결제정보 전체 출력
	public ArrayList<Purchase> p_list(String u_id) throws Exception{
		return purchaseDao.list(u_id);
	}
	
	//주문번호로 결제 조회
	public Purchase p_Detail(int o_no)throws Exception{
		return purchaseDao.detail(o_no);
	}
	//카트전체주문
	public int p_Create() throws Exception{
		
		return 0;
	}
	//카트 선택 주문
public int create(String[] cart_item_noStr_array) throws Exception{
		
		
		return 0;
	}
	//상품직접주문
public int create(int p_no,int oi_qty,String o_PaySelect,String u_id) throws Exception{
	
	Product product=productDao.selectByNo(p_no);
	Purchase_Item purchase_Item = new Purchase_Item(0,oi_qty,0,product);
	ArrayList<Purchase_Item> purchaseItemlist= new ArrayList<Purchase_Item>();
	purchaseItemlist.add(purchase_Item);
	Purchase newpurchase =  new Purchase(0,1,o_PaySelect,product.getP_price()*oi_qty,u_id,purchaseItemlist);
	return purchaseDao.purchaseCreate(newpurchase);
}
	
	

}


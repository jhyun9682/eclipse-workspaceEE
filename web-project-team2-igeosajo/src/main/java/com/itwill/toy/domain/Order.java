package com.itwill.toy.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private int o_no;
	private String o_desc;
	private Date o_date;
	private int o_price;
	private String o_rv_name;
	private String o_rv_phone;
	private String o_rv_address;
	private String o_message;
	/********Member***********/
	private String m_Id;
	/*********List<OrderItem>************/
	private List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(int o_no, String o_desc, Date o_date, int o_price, String o_rv_name, String o_rv_phone,
			String o_rv_address, String o_message, String m_Id, List<OrderItem> orderItemList) {
		super();
		this.o_no = o_no;
		this.o_desc = o_desc;
		this.o_date = o_date;
		this.o_price = o_price;
		this.o_rv_name = o_rv_name;
		this.o_rv_phone = o_rv_phone;
		this.o_rv_address = o_rv_address;
		this.o_message = o_message;
		this.m_Id = m_Id;
		this.orderItemList = orderItemList;
	}
	public int getO_no() {
		return o_no;
	}
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	public String getO_desc() {
		return o_desc;
	}
	public void setO_desc(String o_desc) {
		this.o_desc = o_desc;
	}
	public Date getO_date() {
		return o_date;
	}
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	public int getO_price() {
		return o_price;
	}
	public void setO_price(int o_price) {
		this.o_price = o_price;
	}
	public String getO_rv_name() {
		return o_rv_name;
	}
	public void setO_rv_name(String o_rv_name) {
		this.o_rv_name = o_rv_name;
	}
	public String getO_rv_phone() {
		return o_rv_phone;
	}
	public void setO_rv_phone(String o_rv_phone) {
		this.o_rv_phone = o_rv_phone;
	}
	public String getO_rv_address() {
		return o_rv_address;
	}
	public void setO_rv_address(String o_rv_address) {
		this.o_rv_address = o_rv_address;
	}
	public String getO_message() {
		return o_message;
	}
	public void setO_message(String o_message) {
		this.o_message = o_message;
	}
	public String getM_Id() {
		return m_Id;
	}
	public void setM_Id(String m_Id) {
		this.m_Id = m_Id;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	@Override
	public String toString() {
		return "Order [o_no=" + o_no + ", o_desc=" + o_desc + ", o_date=" + o_date + ", o_price=" + o_price
				+ ", o_rv_name=" + o_rv_name + ", o_rv_phone=" + o_rv_phone + ", o_rv_address=" + o_rv_address
				+ ", o_message=" + o_message + ", m_Id=" + m_Id + ", orderItemList=" + orderItemList + "]";
	}
}

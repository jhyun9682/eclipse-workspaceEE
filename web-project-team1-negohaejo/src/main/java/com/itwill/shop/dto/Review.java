package com.itwill.shop.dto;

public class Review {
/*
 * select avg(r_score) from review where p_no=1;
 * REVIEW_NO  NOT NULL NUMBER(10)    
REVIEWDESC          VARCHAR2(100) 
U_ID                VARCHAR2(50)  
P_NO                NUMBER(10)    
R_SCORE             NUMBER(10)    
OI_NO               NUMBER(10)  
 */
	private int review_no;
	private String reviewdesc;
	private String u_id;
	private int p_no;
	private int r_score;
	private int oi_no;
	public Review(int review_no, String reviewdesc, String u_id, int p_no, int r_score, int oi_no) {
		super();
		this.review_no = review_no;
		this.reviewdesc = reviewdesc;
		this.u_id = u_id;
		this.p_no = p_no;
		this.r_score = r_score;
		this.oi_no = oi_no;
	}
	@Override
	public String toString() {
		return "Review [review_no=" + review_no + ", reviewdesc=" + reviewdesc + ", u_id=" + u_id + ", p_no=" + p_no
				+ ", r_score=" + r_score + ", oi_no=" + oi_no + "]";
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getReviewdesc() {
		return reviewdesc;
	}
	public void setReviewdesc(String reviewdesc) {
		this.reviewdesc = reviewdesc;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getR_score() {
		return r_score;
	}
	public void setR_score(int r_score) {
		this.r_score = r_score;
	}
	public int getOi_no() {
		return oi_no;
	}
	public void setOi_no(int oi_no) {
		this.oi_no = oi_no;
	}
	
}

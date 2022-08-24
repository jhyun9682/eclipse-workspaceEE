package com.itwill.toy.domain;

import java.util.Date;

/*
이름        널?       유형             
--------- -------- -------------- 
N_NO      NOT NULL NUMBER(10)     
N_TITLE   NOT NULL VARCHAR2(50)   
N_WRITER  NOT NULL VARCHAR2(20)   
N_CONTENT NOT NULL VARCHAR2(1000) 
N_DATE             DATE           
N_COUNT            NUMBER(10)      
 */
public class Notice {
	private int n_no;
	private String n_title;
	private String n_writer;
	private String n_content;
	private Date n_date;
	private int n_count;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int n_no, String n_title, String n_writer, String n_content, Date n_date, int n_count) {
		super();
		this.n_no = n_no;
		this.n_title = n_title;
		this.n_writer = n_writer;
		this.n_content = n_content;
		this.n_date = n_date;
		this.n_count = n_count;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_writer() {
		return n_writer;
	}

	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}

	public int getN_count() {
		return n_count;
	}

	public void setN_count(int n_count) {
		this.n_count = n_count;
	}

	@Override
	public String toString() {
		return "Notice [n_no=" + n_no + ", " + (n_title != null ? "n_title=" + n_title + ", " : "")
				+ (n_writer != null ? "n_writer=" + n_writer + ", " : "")
				+ (n_content != null ? "n_content=" + n_content + ", " : "")
				+ (n_date != null ? "n_date=" + n_date + ", " : "") + "n_count=" + n_count + "]";
	}
	
}

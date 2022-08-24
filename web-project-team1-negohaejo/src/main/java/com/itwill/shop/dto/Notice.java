package com.itwill.shop.dto;

import java.util.Date;

public class Notice {
private int noti_no;
private String noti_title;
private String noti_content;
private Date noti_date;
private String noti_file;

public Notice() {

}

public Notice(int noti_no, String noti_title, String noti_content, Date noti_date, String noti_file) {
	super();
	this.noti_no = noti_no;
	this.noti_title = noti_title;
	this.noti_content = noti_content;
	this.noti_date = noti_date;
	this.noti_file = noti_file;
}


public int getNoti_no() {
	return noti_no;
}
public void setNoti_no(int noti_no) {
	this.noti_no = noti_no;
}
public String getNoti_title() {
	return noti_title;
}
public void setNoti_title(String noti_title) {
	this.noti_title = noti_title;
}
public String getNoti_content() {
	return noti_content;
}
public void setNoti_content(String noti_content) {
	this.noti_content = noti_content;
}
public Date getNoti_date() {
	return noti_date;
}
public void setNoti_date(Date noti_date) {
	this.noti_date = noti_date;
}
public String getNoti_file() {
	return noti_file;
}
public void setNoti_file(String noti_file) {
	this.noti_file = noti_file;
}

@Override
public String toString() {
	return "Notice [noti_no=" + noti_no + ", noti_title=" + noti_title + ", noti_content=" + noti_content
			+ ", noti_date=" + noti_date + ", noti_file=" + noti_file + "]";
}

}

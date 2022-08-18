package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDao {
	private DataSource dataSource;
	
	public GuestDao() {
		dataSource=new DataSource();
	}
	public List<Guest> selectAll() throws Exception{
		List<Guest> guestList=new ArrayList<Guest>();
		return guestList;
	}

	public Guest selectByNo(int no) throws Exception{
		Guest guest=null;
		return guest;
	}

	public int insertGuest(Guest guest)throws Exception {
		return 0;
	}
	public int updateGuest(Guest guest) throws Exception{
		return 0;
	}
	public int deleteGuest(int no)throws Exception {
		return 0;
	}
}

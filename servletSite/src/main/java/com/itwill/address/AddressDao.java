package com.itwill.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/*
 * Dao(Data[DataBase] Access Object)객체(클래스)
 *   - address테이블에 CRUD(Create,Read,Update,Delet)작업을 하는 
 *     단위메쏘드를 가지고있는 객체(클래스)
 */
public class AddressDao {
	/*
	 Dao 객체는 멤버변수로 Connection을 생성하는 DataSource객체를가짐
	 */
	private DataSource dataSource;
	public AddressDao() {
		/*
		 * DataSource멤버필드초기화(객체생성)
		 */
		dataSource=new DataSource();
	}
	public int insert(Address address) throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval,'" + 
										address.getId() + "','"+ 
										address.getName() + "','" + 
										address.getPhone() + "','" + 
										address.getAddress() + "')";
		
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		
		stmt.close();
		con.close();
		return rowCount;
	}

	public int deleteByNo(int no) throws Exception {
		String deleteSql = "delete address where no=" + no;
		
		Connection con =  dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		
		stmt.close();
		con.close();
		return rowCount;
	}

	public int updateByNo(Address address) throws Exception {

		String updateSql = "update address set name='" + 
									address.getName() + "',phone='" + 
									address.getPhone()+ "',address='" + 
									address.getAddress() + "' where no = " + address.getNo();
		
		Connection con =  dataSource.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		
		stmt.close();
		con.close();
		
		return rowCount;
	}

	public Address selectByNo(int no) throws Exception {

		String selectSql = "select no,id,name,phone,address from address where no =" + no;
		Address findAddress = null;

		Connection con =  dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			findAddress = new Address(rs.getInt("no"), 
									rs.getString("id"), 
									rs.getString("name"), 
									rs.getString("phone"),
									rs.getString("address"));
		}
		rs.close();
		stmt.close();
		con.close();
		return findAddress;
	}

	public Address selectById(String id) throws Exception {

		String selectSql = "select no,id,name,phone,address from address where id ='" +id+"'";
		Address findAddress = null;

		Connection con =  dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			findAddress = new Address(rs.getInt("no"), 
									rs.getString("id"), 
									rs.getString("name"), 
									rs.getString("phone"),
									rs.getString("address"));
		}
		rs.close();
		stmt.close();
		con.close();
		return findAddress;
	}
	public List<Address> selectAll() throws Exception {

		String selectSql = "select no,id,name,phone,address from address";
		List<Address> addressList = new ArrayList<Address>();

		Connection con =  dataSource.getConnection();;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		while (rs.next()) {
			addressList.add(new Address(rs.getInt("no"), 
										rs.getString("id"), 
										rs.getString("name"),
										rs.getString("phone"), 
										rs.getString("address")));
		}
		
		rs.close();
		stmt.close();
		con.close();
		return addressList;
	}
}

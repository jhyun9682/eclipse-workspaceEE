package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


public class BookDao {
	private DataSource dataSource;
	
	public BookDao() throws Exception{
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("com/itwill/book/jdbc.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("user"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}

	//책이름 검색
	public Book selectByName(String b_name) throws Exception{
		Book book=null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BookSQL.BOOK_SELECT_BY_NAME);
		pstmt.setString(1, b_name);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			book = new Book(rs.getInt("b_no"),rs.getString("b_name"),
					rs.getString("b_class"),rs.getString("b_author"),
					rs.getString("b_publisher"),rs.getString("b_summary"),
					rs.getString("b_image"),rs.getInt("b_price"));
		}
		return book;
	}
	
	//저자 검색
	public Book selectByAuthor(String b_author) throws Exception{
		Book book=null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BookSQL.BOOK_SELECT_BY_AUTHOR);
		pstmt.setString(1, b_author);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			book = new Book(rs.getInt("b_no"),rs.getString("b_name"),
					rs.getString("b_class"),rs.getString("b_author"),
					rs.getString("b_publisher"),rs.getString("b_summary"),
					rs.getString("b_image"),rs.getInt("b_price"));
		}
		return book;
	}
	
	//카테고리 검색
	public List<Book> selectByClass(String b_class) throws Exception{
	List<Book> bookList=new ArrayList<Book>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BookSQL.BOOK_SELECT_BY_B_CLASS);
		pstmt.setString(1, b_class);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Book book= new Book(rs.getInt("b_no"),rs.getString("b_name"),
					rs.getString("b_class"),rs.getString("b_author"),
					rs.getString("b_publisher"),rs.getString("b_summary"),
					rs.getString("b_image"),rs.getInt("b_price"));
		
		}
		return bookList;
	}
	
	
	
	
	//전체 검색
	public List<Book> selectAll() throws Exception{
		List<Book> bookList=new ArrayList<Book>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BookSQL.BOOK_LIST);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
		Book book=new Book(rs.getInt("b_no"),rs.getString("b_name"),
				rs.getString("b_class"),rs.getString("b_author"),
				rs.getString("b_publisher"),rs.getString("b_summary"),
				rs.getString("b_image"),rs.getInt("b_price"));
				bookList.add(book);
		}
		return bookList;
	}
	
	
}

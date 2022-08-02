package book;

import book.BookDao;

public class BookDaoTestMain {

	public static void main(String[] args)throws Exception {
		BookDao bookDao=new BookDao();
		System.out.println(bookDao.selectAll());
		

	}

}

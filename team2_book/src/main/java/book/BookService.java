package book;

import java.util.List;

public class BookService {
private BookDao bookDao;

public BookService() throws Exception{
	bookDao=new BookDao();
}
//리스트
public List<Book> selectAll() throws Exception{
	List<Book> bookList= bookDao.selectAll();
	return bookList;
}

//이름 검색
public Book selectByName(String b_name)throws Exception{
	Book book= bookDao.selectByName(b_name);
	return book;
}

//저자 검색
public Book selectByAuthor(String b_author)throws Exception{
	Book book= bookDao.selectByName(b_author);
	return book;
}


//카테고리 검색
public List<Book> selectByClass(String b_class) throws Exception{
	List<Book> bookList= bookDao.selectByClass(b_class);
	return bookList;
}
}

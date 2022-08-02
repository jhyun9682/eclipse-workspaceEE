package book;

public class BookSQL {
	
	//제목 검색
	public static final String BOOK_SELECT_BY_TITLE
	="select * from book where b_title=?";
	
	//저자 검색
	public static final String BOOK_SELECT_BY_AUTHOR
	="select * from book where b_author=?";

	//카테고리 검색?
	public static final String BOOK_SELECT_BY_B_CLASS
	="select * from book where b_class=?";

	//도서 리스트
	public static final String BOOK_LIST
	= "select * from book";
	
}

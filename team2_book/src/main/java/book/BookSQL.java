package book;

public class BookSQL {
	public static final String BOOK_SELECT_BY_TITLE
	="select * from book where b_title=?";

	public static final String BOOK_SELECT_BY_AUTHOR
	="select * from book where b_author=?";

	public static final String BOOK_SELECT_BY_CATEGORY_NO
	="select * from book where category_no=?";

	public static final String BOOK_LIST
	= "select * from book";
	
}

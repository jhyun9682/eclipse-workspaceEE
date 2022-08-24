package com.itwill.librarian.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.librarian.dao.BookDao;
import com.itwill.librarian.dao.FavoriteDao;
import com.itwill.librarian.dao.MemberDao;
import com.itwill.librarian.domain.Book;
import com.itwill.librarian.domain.Favorite;


public class FavoriteService {

	private FavoriteDao favoriteDao;
	private MemberDao memberDao;
	private BookDao bookDao;
	
	public FavoriteService() throws Exception{
		favoriteDao = new FavoriteDao();
		memberDao = new MemberDao();
		bookDao = new BookDao();
	
		
	}
	
	/*
	 * 관심 도서 추가
	 */
	public int addFavorite(Favorite favorite) throws Exception{
		return favoriteDao.addFavorite(favorite);
		
	}
	
	
	/*
	 * 관심 도서 목록 리스트
	 */

	public ArrayList<Book> getFavoriteBookList(int memberNo) throws Exception{
		ArrayList<Book> bookList = new ArrayList<Book>();
		List<Favorite> favoriteList = favoriteDao.getFavoriteList(memberNo);
		
		for (Favorite favorite : favoriteList) {
			bookList.add(bookDao.getBookByNo(favorite.getBookNo()));
		}
		
		return bookList;
	}
	
	/*
	 * 관심 도서 삭제
	 */
	public int removeFavorite(Favorite favorite) throws Exception{
		return favoriteDao.removeFavorite(favorite);
	}
	
	/*
	 * 관심 도서 전체 삭제
	 */
	public int removeAllFavorite(int memberNo) throws Exception{
		return favoriteDao.removeAllFavorite(memberNo);
	}
	
	//1명의 관심 도서 개수
	
		public int getFavoriteCount(int MemberNo) throws Exception{
			return favoriteDao.getFavoriteCount(MemberNo);
		}	
	
	
}






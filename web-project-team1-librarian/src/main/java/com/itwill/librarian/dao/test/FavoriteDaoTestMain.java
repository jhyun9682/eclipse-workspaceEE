package com.itwill.librarian.dao.test;

import com.itwill.librarian.dao.FavoriteDao;
import com.itwill.librarian.domain.Favorite;

public class FavoriteDaoTestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FavoriteDao favoriteDao = new FavoriteDao();
		/*
		System.out.println("--------favor add------");
		System.out.println(favoriteDao.addFavorite(new Favorite(7, "39")));
		System.out.println(favoriteDao.addFavorite(new Favorite(7, "38")));
		System.out.println(favoriteDao.addFavorite(new Favorite(7, "37")));
		
		System.out.println("--------favor delete------");
		System.out.println(favoriteDao.removeFavorite(new Favorite(7, "3")));
		
		System.out.println("--------favor list------");
		System.out.println(favoriteDao.getFavoriteList(7));
		*/
		System.out.println("--------reservation count------");
		System.out.println(favoriteDao.getFavoriteCount(2));
		
	}

}

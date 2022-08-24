package com.itwill.shop.service;

import java.util.List;

import com.itwill.shop.dao.UserDao;
import com.itwill.shop.dto.User;

public class UserService {
	private UserDao userDao;
	
	public UserService() throws Exception {
		userDao = new UserDao();
	}
	//회원 가입 
	public int create(User user)throws Exception{
		/*
		 * -1:아이디 중복
		 *  1:회원가입 성공
		 */
		
		//아이디 중복체크
		if(userDao.existedUser(user.getU_id())) {
			//아이디 중복
			return -1;
		}else {
			//아이디 중복x
			//회원가입
			int insertRowCount = userDao.create(user);
			return insertRowCount;
		}
	}
	
	//회원 삭제
	public int remove(String u_id)throws Exception{
		return userDao.remove(u_id);
	}
	
	//회원 비밀번호 변경
	public int updatePassword(User user)throws Exception {
		return userDao.updatePassword(user);
	}
	
	//아이디로 검색된 회원 정보 수정
	public int updateAll(User user)throws Exception{
		return userDao.updateAll(user);
	}
	
	//회원의 정보 보기
	public User findUser(String u_id)throws Exception{
		return userDao.findUser(u_id);
	}
	public List<User> findAll() throws Exception {
		List<User> userList = userDao.findUserList();
		return userList;
	}
	//회원 아이디 중복 확인
	
	public boolean existedUser(String u_id)throws Exception{
		return userDao.existedUser(u_id);
	}
	
	//회원 로그인(22.02.22. pm11:46 권하나추가)
	/*
	 * 0:아이디 존재 안함
	 * 1:로그인성공
	 * 2:패스워드 불일치
	 */
	public int login(String u_id, String u_password) throws Exception{
		int result=-1;
		//아이디 존재 여부 확인
		User user = userDao.findUser(u_id);
		//0:아이디 존재 안함
		if(user==null) {
			result=0;
		//1. 아이디 존재
		}else {
			//1:로그인성공
			if(user.isMatchPassword(u_password)) {
			result=1;
			//2:패스워드 불일치
			}else {
				result=2;
			}
		}
		return result;
	
	}
	//회원 로그아웃(22.02.23. pm5:46 권하나추가)
	public void logout() {
		
	}
	
	//아이디 중복체크
	public boolean isDuplicateId(String u_id) throws Exception{
		boolean isExist = userDao.existedUser(u_id);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}

}

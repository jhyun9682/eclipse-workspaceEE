package com.itwill.shop.dao.test;

import com.itwill.shop.dao.UserDao;
import com.itwill.shop.dto.User;

public class UserDaoTestMain {

	public static void main(String[] args)throws Exception {

		UserDao userDao = new UserDao();
		//System.out.println(userDao.create(new User("테스트유저11","12324","김유2저","2022/10/20","F","777-8888","서울시 특별구")));
		//유저 생성 확인됐음 -> 또 실행하면 중복된 PK로 인해 에러 납니다.
	
		//System.out.println("findUser:"+userDao.findUser("test1"));
		//유저 셀렉도 확인됨

		
		//System.out.println("비밀번호수정 결과 : "+userDao.updatePassword(new User("테스트유저11","22222",null,null,null,null,null)));
		//비밀번호 수정 확인	
		
		//System.out.println("remove 결과 :"+userDao.remove("테스트유저11"));
		
		//System.out.println("updateAll 결과 : "+userDao.updateAll(new User("테스트유저11", null, "유우저", "1999/12/11", "M", "1111-2222", "경기도 수원시")));
		
		
		//System.out.println("중복확인 "+userDao.existedUser("test1"));
		
		//전부다 확인 완료
	}

}
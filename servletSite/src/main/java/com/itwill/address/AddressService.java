package com.itwill.address;
/*
 * - 주소록(address) 관리 비즈니스로직(업무)를 수행하는 클래스
 * - GUI객체(스윙,서블릿,JSP)에서 직접접근(메쏘드호출)하는클래스
 * - AddressDao객체를 이용해서 데이타베이스에 접근하는클래스
 */

import java.util.List;

public class AddressService {
	/*
	 AddressDao객체를 멤버필드로가진다
	 */
	private AddressDao addressDao;
	public AddressService() {
		addressDao=new AddressDao();
		
	}
	/*
	 * 주소록쓰기
	 * 	
	 */
	public int insert(Address newAddress) throws Exception{
		int result=0;//중복:0, 성공:1
		/*
		 * 1  .아이디중복체크
		 * 2-1.중복아니면 insert (O)
		 * 2-1.중복이  면 insert (X)
		 */
		Address findAddress=
				addressDao.selectById(newAddress.getId());
		if(findAddress==null) {
			//아이디 중복안됨
			addressDao.insert(newAddress);
			result=1;
		}else {
			//아이디 중복됨
			result=0;
		}
		
		return result;
	}
	
	/*
	 * 주소록삭제(한개)
	 */
	public int deleteByNo(int no)throws Exception {
		return addressDao.deleteByNo(no);
	}
	/*
	 * 주소록수정(한개)
	 */
	public int updateByNo(Address updateAddress) throws Exception{
		return addressDao.updateByNo(updateAddress);
	}
	/*
	 * 주소록검색(번호)
	 */
	public Address selectByNo(int no) throws Exception {
		return addressDao.selectByNo(no);
	}
	/*
	 * 모든주소록검색
	 */
	 public List<Address> selectAll() throws Exception{
		 return addressDao.selectAll();
	 }
	
	
	
	
	
	
	
	
}

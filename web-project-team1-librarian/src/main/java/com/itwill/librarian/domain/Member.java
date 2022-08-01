package com.itwill.librarian.domain;

public class Member {
	
	//대출과 예약 제한 횟 수
	public final static int MAX_LOAN_CNT = 5;
	public final static int MAX_RESERVE_CNT = 5;
	
    private int memberNo;
    private String memberName;
    private String memberId;
    private String memberPass;
    private String memberPhone;
    private String memberEmail;
    private int memberLoan;
    private int memberReservation;
    
    
    public Member() {
		
	}
    
    public Member(String memberId, String memberPass, String memberName, String memberPhone, String memberEmail) {
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
	}

	public Member(int memberNo, String memberName, String memberPass, String memberPhone, String memberEmail) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberPass = memberPass;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
	}

	public Member(int memberNo, String memberName, String memberId, String memberPass, String memberPhone,
			String memberEmail, int memberLoan, int memberReservation) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberLoan = memberLoan;
		this.memberReservation = memberReservation;
	}


	public int getMemberNo() {
		return memberNo;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public int getMemberLoan() {
		return memberLoan;
	}

	public int getMemberReservation() {
		return memberReservation;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public void setMemberLoan(int memberLoan) {
		this.memberLoan = memberLoan;
	}

	public void setMemberReservation(int memberReservation) {
		this.memberReservation = memberReservation;
	}

	
	// Member 모델 복사
    public void CopyData(Member param)
    {
        this.memberNo = param.getMemberNo();
        this.memberName = param.getMemberName();
        this.memberId = param.getMemberId();
        this.memberPass = param.getMemberPass();
        this.memberPhone = param.getMemberPhone();
        this.memberEmail = param.getMemberEmail();
        this.memberLoan = param.getMemberLoan();
        this.memberReservation = param.getMemberReservation();
    }

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + ", memberId=" + memberId + "]";
	}
	
    
    
    
}

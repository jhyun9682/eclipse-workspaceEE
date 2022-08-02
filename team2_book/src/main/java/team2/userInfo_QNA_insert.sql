insert into userinfo values('seongmin', '1234', '정성민', '01012345678', '970902', '남', 'seongmin@gmail.com', '경기도');
insert into userinfo values('bongkune', '1234', '김봉균', '01023456789', '940603', '남', 'bongkune@gmail.com', '서울');
insert into userinfo values('jihun', '1234', '유지훈', '01034567891', '961010', '남', 'jihun@gmail.com', '부산');
insert into userinfo values('enbi', '1234', '임은비', '01045678912', '980105', '여', 'enbi@gmail.com', '광주');
insert into userinfo values('jeonghun', '1234', '이정현', '01056789123', '960504', '여', 'jeonghun@gmail.com', '대구');
insert into userinfo values('hunjeong', '1234', '임현정', '01067891234', '940701', '여', 'hunjeong@gmail.com', '천안');

insert into qna values(QNA_q_no_SEQ.nextval, '1:1문의', '책 배송이 언제오나요?', sysdate, '제가 주문한 책 배송이 언제오나요?', 'seongmin');
insert into qna values(QNA_q_no_SEQ.nextval, '1:1문의', '책이 잘못왔어요', sysdate, '책이 잘못왔어요', 'enbi');
insert into qna values(QNA_q_no_SEQ.nextval, '1:1문의', '상품 언제 들어올까요?', sysdate, '상품 언제 들어올까요?', 'jeonghun');
insert into qna values(QNA_q_no_SEQ.nextval, '1:1문의', '주문이 누락됐습니다', sysdate, '주문이 누락됐습니다 주문이 누락됐습니다', 'hunjeong');
insert into qna values(QNA_q_no_SEQ.nextval, '1:1문의', '주문 취소하고싶어요', sysdate, '주문 취소하고싶어요', 'jihun');
insert into qna values(QNA_q_no_SEQ.nextval, '1:1문의', '배고파요', sysdate, '배고파요', 'bongkune');

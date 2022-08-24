--insert notice
desc notice;
insert into notice(NOTI_NO,NOTI_TITLE,NOTI_CONTENT,NOTI_DATE,NOTI_FILE) values (not_not_no_SEQ.nextval,'1공지','1공지입니다.',to_date('1981/01/01','YYYY/MM/DD'),'공지파일1');
insert into notice(NOTI_NO,NOTI_TITLE,NOTI_CONTENT,NOTI_DATE,NOTI_FILE) values (not_not_no_SEQ.nextval,'2공지','2공지입니다.',to_date('1981/02/01','YYYY/MM/DD'),'공지파일2');
insert into notice(NOTI_NO,NOTI_TITLE,NOTI_CONTENT,NOTI_DATE,NOTI_FILE) values (not_not_no_SEQ.nextval,'3공지','3공지입니다.',to_date('1981/01/01','YYYY/MM/DD'),'공지파일3');
insert into notice(NOTI_NO,NOTI_TITLE,NOTI_CONTENT,NOTI_DATE,NOTI_FILE) values (not_not_no_SEQ.nextval,'6공지','6공지입니다.',to_date('1981/03/25','YYYY/MM/DD'),'공지파일4');
insert into notice(NOTI_NO,NOTI_TITLE,NOTI_CONTENT,NOTI_DATE,NOTI_FILE) values (not_not_no_SEQ.nextval,'6공지','6공지입니다.',sysdate,'공지파일5');
insert into notice(NOTI_NO,NOTI_TITLE,NOTI_CONTENT,NOTI_DATE,NOTI_FILE) values (not_not_no_SEQ.nextval,'6공지','6공지입니다.',sysdate,'공지파일6');


--insert userinfo
desc userinfo;
insert into userinfo(U_ID,U_PASSWORD,U_NAME,U_BIRTH,U_GENDER,U_PHONE,U_ADDRESS) values ('test1','test1','test1','1994/03/25','M','111','서울');
insert into userinfo(U_ID,U_PASSWORD,U_NAME,U_BIRTH,U_GENDER,U_PHONE,U_ADDRESS) values ('test2','test2','test2','1994/03/26','M','222','부산');
insert into userinfo(U_ID,U_PASSWORD,U_NAME,U_BIRTH,U_GENDER,U_PHONE,U_ADDRESS) values ('test3','test3','test3','1994/03/27','M','333','광주');
insert into userinfo(U_ID,U_PASSWORD,U_NAME,U_BIRTH,U_GENDER,U_PHONE,U_ADDRESS) values ('test4','test4','test4','1995/02/26','M','444','대전');
insert into userinfo(U_ID,U_PASSWORD,U_NAME,U_BIRTH,U_GENDER,U_PHONE,U_ADDRESS) values ('test5','test5','test5','2000/06/07','M','444','서울');


--insert product
desc product2;
insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (1,'조은의자chair1','조은의자입니다.',to_date('1981/01/01','YYYY/MM/DD'),1000,'images/chair1.jpg','chair');
insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (2,'더조은의자chair2','더조은의자입니다.',to_date('1981/01/02','YYYY/MM/DD'),2000,'images/chair2.jpg','chair');
insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (3,'게임의자chair3','게임의자입니다.',to_date('1981/01/3','YYYY/MM/DD'),3000,'images/chair3.jpg','chair');
insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (4,'의자chair4','의자입니다.',to_date('1981/01/04','YYYY/MM/DD'),4000,'images/chair4.jpg','chair');
insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (5,'조은침대bed1','조은침대입니다.',sysdate,5000,'images/bed1.jpg','bed');
insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (6,'더조은침대bed2','더조은침대입니다.',sysdate,6000,'images/bed2.jpg','bed');
insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (7,'게임침대bed3','게임침대입니다.',sysdate,7000,'images/bed3.jpg','bed');

insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (9,'책상desk1','책상입니다.',to_date('1981/01/02','YYYY/MM/DD'),1000,'images/desk1.jpg','desk');
insert into product2(P_NO,P_NAME,P_DESC,P_DATE,P_PRICE,P_IMG,P_CAT) values (10,'조은책상desk1','조은책상입니다',to_date('1981/01/02','YYYY/MM/DD'),2000,'images/desk2.jpg','desk');

desc cart;

insert into cart(C_NO,C_QTY,U_ID,P_NO) values (cart_cart_no_SEQ.nextval,1,'test1',1);
insert into cart(C_NO,C_QTY,U_ID,P_NO) values (cart_cart_no_SEQ.nextval,2,'test1',3);
insert into cart(C_NO,C_QTY,U_ID,P_NO) values (cart_cart_no_SEQ.nextval,1,'test2',2);

desc purchase;

insert into purchase(o_NO,o_itemLISTNUM,O_PAYSELECT,O_ITEMTOTPRICE,U_ID) values (o_o_no_SEQ.nextval,4,'CARD',11000,'test1');
insert into purchase(o_NO,o_itemLISTNUM,O_PAYSELECT,O_ITEMTOTPRICE,U_ID) values (o_o_no_SEQ.nextval,2,'CASH',3000,'test2');
insert into purchase(o_NO,o_itemLISTNUM,O_PAYSELECT,O_ITEMTOTPRICE,U_ID) values (o_o_no_SEQ.nextval,2,'CARD',3000,'test3');
insert into purchase(o_NO,o_itemLISTNUM,O_PAYSELECT,O_ITEMTOTPRICE,U_ID) values (o_o_no_SEQ.nextval,3,'smartpay',14000,'test1');
insert into purchase(o_NO,o_itemLISTNUM,O_PAYSELECT,O_ITEMTOTPRICE,U_ID) values (o_o_no_SEQ.nextval,1,'CARD',5000,'test4');

desc purchase_item;

insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,2,1,1);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,1,2);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,1,3);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,1,4);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,2,1);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,2,2);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,3,9);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,3,10);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,4,9);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,4,5);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,4,6);
insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,1,5,5);

desc review;
insert into review(REVIEW_NO,REVIEWDESC,U_ID,P_NO,R_SCORE,OI_NO) values (rv_rv_no_SEQ.nextval,'조은의자 조아요 test1','test1',1,3.5,1);
insert into review(REVIEW_NO,REVIEWDESC,U_ID,P_NO,R_SCORE,OI_NO) values (rv_rv_no_SEQ.nextval,'조은의자 조아요 test2','test2',1,5,5);
insert into review(REVIEW_NO,REVIEWDESC,U_ID,P_NO,R_SCORE,OI_NO) values (rv_rv_no_SEQ.nextval,'더조은의자 조아요 test2','test2',2,2,6);
insert into review(REVIEW_NO,REVIEWDESC,U_ID,P_NO,R_SCORE,OI_NO) values (rv_rv_no_SEQ.nextval,'조은침대 조아요 test1','test1',5,3,10);
insert into review(REVIEW_NO,REVIEWDESC,U_ID,P_NO,R_SCORE,OI_NO) values (rv_rv_no_SEQ.nextval,'조은침대 조아요 test4','test4',5,3,12);
commit;
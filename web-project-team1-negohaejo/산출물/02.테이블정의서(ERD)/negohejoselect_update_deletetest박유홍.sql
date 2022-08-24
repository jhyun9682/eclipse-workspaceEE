

--review
select * from review where p_no=1;--제품 리뷰
select avg(r_score) avg from review where p_no=1;--제품별 리뷰 평균점수
select p_no, avg(r_score) from review group by p_no;--리뷰 평균점수 나열
select  i.p_no, count(*) from purchase_item i  join product2 p on p.p_no=i.p_no where p.p_cat='chair' group by i.p_no ;--카테고리 판매량 나열
--product
select * from product2;
select * from product2 p join (select p_no, avg(r_score) from review group by p_no) r on r.p_no=p.p_no; 
select * from product2 p left outer join (select p_no, avg(r_score) a from review group by p_no) r on r.p_no=p.p_no order by r.a desc; 
select * from product2 p left outer join (select p_no, count(*) pop from purchase_item group by p_no) pur on p.p_no=pur.p_no where p.p_cat='chair' order by pur.pop desc;
--리뷰 평균점수 on where p_cat='chair'
select * from product2 p where(p_name like '%조은%' or p_name like '%침대%') and p_cat='desk';
--검색?
select * from product2 order by p_date;
--notice
select * from notice order by noti_date desc;
select * from notice where noti_no=1;
select * from notice order by noti_date desc;
select * from notice order by noti_title desc;
--user
select * from userinfo where u_id='test1';
delete from userinfo where u_id='test1';
update userinfo set u_password='testnew' where u_id='test1' ;
--purchase
select * from purchase pur join purchase_item puri on pur.o_no=puri.o_no where pur.u_id='test2';
delete from purchase where o_No=1;
--purchase item
select count(*) from purchase_item where p_no=1;
--cart
select * from cart where u_id='test1';
select * from cart where p_no=1 and u_id='test1';
delete from cart where c_no=1;
update cart set c_qty=3 where c_no=1;
update cart set c_qty=4 where c_no=(select c_no from cart where p_no=1 and u_id='test1');
commit;
insert into userinfo(U_ID,U_PASSWORD,U_NAME,U_BIRTH,U_GENDER,U_PHONE,U_ADDRESS) values ('김유저','1234','박유홍','1994/03/25','F','010545','wefa');
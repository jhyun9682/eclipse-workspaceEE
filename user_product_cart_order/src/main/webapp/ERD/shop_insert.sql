/**********************member insert************************/
insert into userinfo(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');

/**********************product insert************************/

insert into product values(product_p_no_SEQ.nextval, '비글', 550000, 'bigle.png','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '달마시안', 500000, 'dalma.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '퍼그', 400000, 'pug.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '페키니즈', 450000, 'pekiniz.png','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '포메라니안', 800000, 'pomeranian.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '샤페이', 700000, 'shaipei.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '닥스훈트', 800000, 'dachshund.jpg','기타 상세 정보 등...', 0);
insert into product values(product_p_no_SEQ.nextval, '사모예드', 800000, 'samoyed.jpg','기타 상세 정보 등...', 0);
/**********************cart insert************************/
-- 로그인한 guard1님이 카트에 존재하지않는 제품을 카트에 담기
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_seq.nextval,2,1,'guard1');
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_seq.nextval,1,3,'guard1');
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_seq.nextval,1,7,'guard1');
-- 로그인한 guard2님이 카트에 존재하지않는 제품을 카트에 담기
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_seq.nextval,1,7,'guard2');
insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_seq.nextval,2,8,'guard2');
/*********************************************************/

/******************order insert***************************/
--로그인한 guard1님이 주문(1번 1마리,2번 2마리)
insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_seq.nextval,'비글외1종',sysdate,1550000,'guard1');
insert into order_item(oi_no,oi_qty,o_no,p_no)  values(order_item_oi_no_seq.nextval,1,orders_o_no_seq.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no)  values(order_item_oi_no_seq.nextval,2,orders_o_no_seq.currval,2);
--로그인한 guard1님이 주문(7번 1마리,8번 2마리)
insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_seq.nextval,'다스훈트외1종',sysdate,2400000,'guard1');
insert into order_item(oi_no,oi_qty,o_no,p_no)  values(order_item_oi_no_seq.nextval,1,orders_o_no_seq.currval,7);
insert into order_item(oi_no,oi_qty,o_no,p_no)  values(order_item_oi_no_seq.nextval,2,orders_o_no_seq.currval,8);

--로그인한 guard2님이 주문(1번 3마리)
insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_seq.nextval,'비글외0종',sysdate,1650000,'guard2');
insert into order_item(oi_no,oi_qty,o_no,p_no)  values(order_item_oi_no_seq.nextval,3,orders_o_no_seq.currval,1);


















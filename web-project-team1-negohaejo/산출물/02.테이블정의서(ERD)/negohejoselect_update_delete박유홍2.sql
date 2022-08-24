--product ��ü ī�װ�  Ư����ǰ ���?(�˻��� ����Ʈ�� �޾Ƽ� ���񽺴�? ������Ʈ delete����
desc product2;
select * from product2 p left outer join review r on r.p_no=p.p_no;--��ü��ǰ����Ʈ ����ǰ�� ���丮��Ʈ ����
select * from product2 p left outer join review r on r.p_no=p.p_no order by p_name;--��ü��ǰ����Ʈ ����ǰ�� ���丮��Ʈ ����-- 
select * from product2 p left outer join review r on r.p_no=p.p_no order by p_date;--��ü��ǰ����Ʈ ����ǰ�� ���丮��Ʈ ����-- 
select * from product2 p left outer join review r on r.p_no=p.p_no order by p_price;--��ü��ǰ����Ʈ ����ǰ�� ���丮��Ʈ ����-- 
select * from product2 p left outer join review r on r.p_no=p.p_no order by p_price;--��ü��ǰ����Ʈ ����ǰ�� ���丮��Ʈ ����-- 
select * from product2 p left outer join review r on r.p_no=p.p_no where p_name like '%����%' and p_cat='chair' order by p_name desc;
select * from product2 p left outer join review r on r.p_no=p.p_no where p_name like '%����%' and p_cat='chair' order by p_name desc;

select * from product2 p left outer join review r on r.p_no=p.p_no where p.p_cat='chair';--ī�װ� ���ڸ���Ʈ ����ǰ�� ���丮��Ʈ ����
select * from product2 p left outer join review r on r.p_no=p.p_no where p.p_no=1;--Ư����ǰ
select * from product2 p order by (select count(*) from purchase_item pri where p.p_no=pri.p_no group by p.p_no) desc;
select p_no, count(*) from purchase_item group by p_no;
select * from product2 p  left outer join review r on r.p_no=p.p_no order by (select avg(r_score) from review r where p.p_no=r.p_no group by p.p_no), (select count(*) from review r where p.p_no=r.p_no group by p.p_no);
select * from product2 p  left outer join review r on r.p_no=p.p_no order by (select avg(r_score) from review r where p.p_no=r.p_no group by p.p_no) desc;
select * from product2 p left outer join review r on r.p_no=p.p_no where p_name like '%����%' and p_cat='chair' order by p_name desc;
--purchase ������Ʈ ���ٰ� ����
delete from purchase where u_id='test1';--������ ���? �������?
delete from purchase where o_no=2;--�α����� ������ Ư���ֹ����?
select * from purchase pur join purchase_item puri on pur.o_no=puri.o_no join product2 p on puri.p_no=p.p_no  where u_id='test1';--Ư�������� ���Ÿ���Ʈ �����׸� ��ǰ�̸� ���? ����
select * from purchase pur join purchase_item puri on pur.o_no=puri.o_no join product2 p on puri.p_no=p.p_no  where pur.o_no=1;-- ������ ���� ǰ���? ����

--purchase item ���Ⱦ������� 
--cart
delete from cart where c_no=1;--�α����� ������ Ư�� īƮ ����
delete form cart where u_id='test1';--Ư�������� īƮ ����
select * from cart c join product2 p on p.p_no=c.p_no where c_no=1; 
select * from cart c join userinfo u on c.u_id=u.u_id join product2 p on p.p_no=c.p_no where c.u_id='test1';--Ư�������� īƮ����Ʈ ��ǰ,���������� ����
select * from cart c join userinfo u on c.u_id=u.u_id join product2 p on p.p_no=c.p_no where c.u_id='test1' and c.p_no=1;--Ư������ Ư����ǰ�����? īƮ ��ǰ,���������� ����
select count(*) from cart where u_id='test1' and p_no=1;--Ư������ Ư����ǰ �����? 1��ȯ �ϴ� ü��
update cart set c_qty=c_qty+3 where c_no=1;--Ư��īƮ�׸� ��������
update cart set c_qty=c_qty+3 where u_id='test1' and p_no=1;--Ư������ Ư����ǰ �߰� �ֹ��� �߰�

insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,3,o_o_no_SEQ.currval,1);

select * from purchase where u_id='test1';
commit;


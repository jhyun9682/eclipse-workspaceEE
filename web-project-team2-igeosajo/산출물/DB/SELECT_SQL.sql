--------------------------member----------------------------------------
--멤버 정보 전체 출력
select * FROM MEMBER WHERE m_id = ?;
--

-------------------------- order --------------------------------------

--로그인한멤버의 주문 전체 목록
select * from orders where userid=?;

--로그인한멤버의 주문 한개 목록
select * from orders o
join order_item oi
on o.o_no = oi.o_no
join product p
on oi.p_no = p.p_no
where o.m_id=? and o.o_no = ?; 

------------------------ notice ----------------------------------

-- 게시글 1개 정보 
SELECT n_no, n_title, n_writer, n_content, n_date, n_count FROM notice where n_no = ?;

-- 전체 게시글 수 조회
select count(*) from notice;

-- 게시글 리스트 조회
SELECT * 
FROM 
( SELECT rownum idx, s.* 
FROM 
( SELECT n_no, n_title, n_writer, n_content, n_date, n_count  FROM notice ORDER BY n_no DESC ) s ) 
WHERE idx >= 1 AND idx <= 10 ;

------------------------ qna----------------------------------

-- 게시글 1개 정보 
select q_no, q_title, q_content, q_date, q_count, q_group_no, q_step, q_depth, m_id from qna where q_no = ?

-- 전체 게시글 수 조회
select count(*) cnt from qna;

-- 게시글 리스트 조회
SELECT * 
FROM 
( SELECT rownum idx, s.* 	
FROM ( SELECT q_no, q_title, m_id, q_date, q_count, q_group_no, q_step, q_depth 
FROM qna 
ORDER BY q_group_no DESC, q_step ASC ) s )
WHERE idx >= ? AND idx <= ? ;



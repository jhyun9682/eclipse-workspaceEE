------------------------ NOTICE ----------------------------------

-- 조회수 증가 
update notice set n_count = n_count + 1 where n_no = 1;

-------------------------- QNA----------------------------------

-- 답글입력 전 게시글 순서 변경 
update qna SET step = step + 1 where step >= 2 and groupno = 1;

-- 조회수 증가 
update notice set n_count = n_count + 1 where n_no = ?;

-- 게시글 수정 
update qna set q_title=?, q_content=? where q_no = ?;



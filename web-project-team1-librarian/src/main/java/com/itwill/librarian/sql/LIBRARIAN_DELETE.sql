--회원 탈퇴
DELETE FROM MEMBER WHERE MEMBER_NO = ?
;
--책 정보  삭제
DELETE FROM BOOK WHERE BOOK_NO = ?
;
--관심 도서 삭제
DELETE FROM FAVORITE WHERE MEMBER_NO = ? AND BOOK_NO = ?
;
--희망 도서 삭세
DELETE FROM HOPE_BOOK WHERE MEMBER_NO = ? AND HOPE_NO = ?
;
--공지 사항 삭제
DELETE FROM NOTICE WHERE NOTICE_NO = ?
;
--QNA 삭제
DELETE FROM QNA WHERE QNA_NO = ?
;
--QNA 답변 삭제
DELETE FROM REPLY WHERE REPLY_NO=?
;
--FAQ 삭제
DELETE FROM FAQ WHERE FAQ_NO = ?
;
--대출 기록 삭제
DELETE FROM LOAN WHERE MEMBER_NO = ? AND BOOK_NO = ?
;

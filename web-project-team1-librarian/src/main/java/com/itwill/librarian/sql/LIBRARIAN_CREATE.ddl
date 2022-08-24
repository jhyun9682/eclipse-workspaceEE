-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- MEMBER Table Create SQL
CREATE TABLE MEMBER
(
    member_no             NUMBER(3)       NOT NULL,
    member_name           VARCHAR2(50)    NOT NULL,
    member_id             VARCHAR2(20)    NOT NULL,
    member_pass           VARCHAR2(30)    NOT NULL,
    member_phone          VARCHAR2(11)    NOT NULL,
    member_email          VARCHAR2(50)    NOT NULL,
    member_loan           NUMBER(1)       DEFAULT 0 NOT NULL,
    member_reservation    NUMBER(1)       DEFAULT 0 NOT NULL,
    CONSTRAINT PK_MEMBER PRIMARY KEY (member_no)
)
/

CREATE SEQUENCE MEMBER_SEQ
START WITH 1
INCREMENT BY 1;
/

COMMENT ON TABLE MEMBER IS '회원'
/

COMMENT ON COLUMN MEMBER.member_no IS '회원 번호'
/

COMMENT ON COLUMN MEMBER.member_name IS '회원 이름'
/

COMMENT ON COLUMN MEMBER.member_id IS '회원 아이디'
/

COMMENT ON COLUMN MEMBER.member_pass IS '회원 비밀번호'
/

COMMENT ON COLUMN MEMBER.member_phone IS '회원 전화번호'
/

COMMENT ON COLUMN MEMBER.member_email IS '회원 이메일'
/

COMMENT ON COLUMN MEMBER.member_loan IS '회원 대출'
/

COMMENT ON COLUMN MEMBER.member_reservation IS '회원 예약'
/

CREATE UNIQUE INDEX UQ_MEMBER_1
    ON MEMBER(member_id)
/

-- BOOK Table Create SQL
CREATE TABLE BOOK
(
    book_no             VARCHAR2(10)      NOT NULL,
    book_title          VARCHAR2(150)     NOT NULL,
    book_category       VARCHAR2(30)      NOT NULL,
    book_author         VARCHAR2(50)      NOT NULL,
    book_publisher      VARCHAR2(50)      NOT NULL,
    book_yop            DATE              DEFAULT SYSDATE NOT NULL,
    book_info           VARCHAR2(4000)    NOT NULL,
    book_index          VARCHAR2(4000)    NOT NULL,
    book_image_url      VARCHAR2(256)     NULL,
    book_holdings       NUMBER(1)         DEFAULT 5 NOT NULL,
    book_loan           NUMBER(1)         DEFAULT 5 NOT NULL,
    book_reservation    NUMBER(1)         DEFAULT 5 NOT NULL,
    CONSTRAINT PK_BOOK PRIMARY KEY (book_no)
)
/

COMMENT ON TABLE BOOK IS '도서'
/

COMMENT ON COLUMN BOOK.book_no IS '4자리 ex) A001'
/

COMMENT ON COLUMN BOOK.book_title IS '도서 제목'
/

COMMENT ON COLUMN BOOK.book_category IS '도서 카테고리'
/

COMMENT ON COLUMN BOOK.book_author IS '도서 작가'
/

COMMENT ON COLUMN BOOK.book_publisher IS '도서 출판사'
/

COMMENT ON COLUMN BOOK.book_yop IS '편의상 default 넣음'
/

COMMENT ON COLUMN BOOK.book_info IS '도서 정보'
/

COMMENT ON COLUMN BOOK.book_index IS '도서 목차'
/

COMMENT ON COLUMN BOOK.book_image_url IS '도서 이미지 url'
/

COMMENT ON COLUMN BOOK.book_holdings IS '도서 보유수'
/

COMMENT ON COLUMN BOOK.book_loan IS '도서 대출'
/

COMMENT ON COLUMN BOOK.book_reservation IS '도서 예약'
/


-- QNA Table Create SQL
CREATE TABLE QNA
(
    qna_no          NUMBER(3)         NOT NULL,
    member_no       NUMBER(3)         NOT NULL,
    qna_title       VARCHAR2(150)     NOT NULL,
    qna_content     VARCHAR2(4000)    NOT NULL,
    qna_reg_date    DATE              DEFAULT SYSDATE NOT NULL,
    qna_visible     NUMBER(1)         DEFAULT 1 NOT NULL,
    qna_file        VARCHAR2(256)     NULL,
    qna_views       NUMBER(4)         DEFAULT 0 NOT NULL,
    CONSTRAINT PK_QNA PRIMARY KEY (qna_no)
)
/

CREATE SEQUENCE QNA_SEQ
START WITH 1
INCREMENT BY 1;
/

COMMENT ON TABLE QNA IS 'member_no on delete cascade'
/

COMMENT ON COLUMN QNA.qna_no IS 'QNA 번호'
/

COMMENT ON COLUMN QNA.member_no IS '회원 번호'
/

COMMENT ON COLUMN QNA.qna_title IS '제목'
/

COMMENT ON COLUMN QNA.qna_content IS '내용'
/

COMMENT ON COLUMN QNA.qna_reg_date IS '등록일'
/

COMMENT ON COLUMN QNA.qna_visible IS '공개 여부'
/

COMMENT ON COLUMN QNA.qna_file IS '첨부 파일'
/

COMMENT ON COLUMN QNA.qna_views IS '조회수'
/

ALTER TABLE QNA
    ADD CONSTRAINT FK_QNA_member_no_MEMBER_member FOREIGN KEY (member_no)
        REFERENCES MEMBER (member_no)
        ON DELETE CASCADE
/


-- NOTICE Table Create SQL
CREATE TABLE NOTICE
(
    notice_no          NUMBER(3)         NOT NULL,
    notice_title       VARCHAR2(200)     NOT NULL,
    notice_content     VARCHAR2(4000)    NOT NULL,
    notice_reg_date    DATE              DEFAULT SYSDATE NOT NULL,
    notice_file        VARCHAR2(256)     NULL,
    notice_views       NUMBER(4)         DEFAULT 0 NOT NULL,
    CONSTRAINT PK_NOTICE PRIMARY KEY (notice_no)
)
/

CREATE SEQUENCE NOTICE_SEQ
START WITH 1
INCREMENT BY 1;
/

COMMENT ON TABLE NOTICE IS '공지사항'
/

COMMENT ON COLUMN NOTICE.notice_no IS '번호'
/

COMMENT ON COLUMN NOTICE.notice_title IS '제목'
/

COMMENT ON COLUMN NOTICE.notice_content IS '내용'
/

COMMENT ON COLUMN NOTICE.notice_reg_date IS '등록일'
/

COMMENT ON COLUMN NOTICE.notice_file IS '첨부파일'
/

COMMENT ON COLUMN NOTICE.notice_views IS '조회수'
/


-- LOAN Table Create SQL
CREATE TABLE LOAN
(
    loan_no             NUMBER(3)       NOT NULL,
    member_no           NUMBER(3)       NOT NULL,
    book_no             VARCHAR2(10)    NOT NULL,
    loan_reg_date       DATE            DEFAULT SYSDATE NOT NULL,
    loan_return_date    DATE            NULL,
    loan_access         NUMBER(1)       DEFAULT 1 NOT NULL,
    CONSTRAINT PK_LOAN PRIMARY KEY (loan_no)
)
/

CREATE SEQUENCE LOAN_SEQ
START WITH 1
INCREMENT BY 1;
/

COMMENT ON TABLE LOAN IS 'member_no on delete cascade'
/

COMMENT ON COLUMN LOAN.loan_no IS '대출 번호'
/

COMMENT ON COLUMN LOAN.member_no IS '회원 번호'
/

COMMENT ON COLUMN LOAN.book_no IS '도서 번호'
/

COMMENT ON COLUMN LOAN.loan_reg_date IS '대출 등록 날짜'
/

COMMENT ON COLUMN LOAN.loan_return_date IS '대출 반납 날짜'
/

COMMENT ON COLUMN LOAN.loan_access IS '대출 접근권한'
/

ALTER TABLE LOAN
    ADD CONSTRAINT FK_LOAN_member_no_MEMBER_membe FOREIGN KEY (member_no)
        REFERENCES MEMBER (member_no)
        ON DELETE CASCADE
/

ALTER TABLE LOAN
    ADD CONSTRAINT FK_LOAN_book_no_BOOK_book_no FOREIGN KEY (book_no)
        REFERENCES BOOK (book_no)
        ON DELETE CASCADE
/


-- FAQ Table Create SQL
CREATE TABLE FAQ
(
    faq_no          NUMBER(3)         NOT NULL,
    faq_question    VARCHAR2(4000)    NOT NULL,
    faq_answer      VARCHAR2(4000)    NOT NULL,
    faq_category    VARCHAR2(30)      NOT NULL,
    CONSTRAINT PK_FAQ PRIMARY KEY (faq_no)
)
/

CREATE SEQUENCE FAQ_SEQ
START WITH 1
INCREMENT BY 1;
/

COMMENT ON TABLE FAQ IS '자주 물어보는 질문'
/

COMMENT ON COLUMN FAQ.faq_no IS '번호'
/

COMMENT ON COLUMN FAQ.faq_question IS '질문'
/

COMMENT ON COLUMN FAQ.faq_answer IS '답변'
/

COMMENT ON COLUMN FAQ.faq_category IS '카테고리'
/


-- FAVORITE Table Create SQL
CREATE TABLE FAVORITE
(
    member_no    NUMBER(3)       NOT NULL,
    book_no      VARCHAR2(10)    NOT NULL,
    CONSTRAINT PK_FAVORITE PRIMARY KEY (member_no, book_no)
)
/

COMMENT ON TABLE FAVORITE IS 'member_no on delete cascade'
/

COMMENT ON COLUMN FAVORITE.member_no IS '회원 번호'
/

COMMENT ON COLUMN FAVORITE.book_no IS '도서 번호'
/

ALTER TABLE FAVORITE
    ADD CONSTRAINT FK_FAVORITE_member_no_MEMBER_m FOREIGN KEY (member_no)
        REFERENCES MEMBER (member_no)
        ON DELETE CASCADE
/

ALTER TABLE FAVORITE
    ADD CONSTRAINT FK_FAVORITE_book_no_BOOK_book_ FOREIGN KEY (book_no)
        REFERENCES BOOK (book_no)
        ON DELETE CASCADE
/


-- HOPE_BOOK Table Create SQL
CREATE TABLE HOPE_BOOK
(
    hope_no           NUMBER(3)        NOT NULL,
    member_no         NUMBER(3)        NULL,
    book_title        VARCHAR2(150)    NOT NULL,
    book_publisher    VARCHAR2(50)     NOT NULL,
    book_author       VARCHAR2(50)     NOT NULL,
    ib_status         NUMBER(1)        DEFAULT 0 NOT NULL,
    hope_reg_date     DATE             DEFAULT SYSDATE NOT NULL,
    CONSTRAINT PK_HOPE_BOOK PRIMARY KEY (hope_no)
)
/

CREATE SEQUENCE HOPE_BOOK_SEQ
START WITH 1
INCREMENT BY 1;
/

COMMENT ON TABLE HOPE_BOOK IS 'member_no on delete set null'
/

COMMENT ON COLUMN HOPE_BOOK.hope_no IS '도서신청 번호'
/

COMMENT ON COLUMN HOPE_BOOK.member_no IS '회원 번호'
/

COMMENT ON COLUMN HOPE_BOOK.book_title IS '도서 제목'
/

COMMENT ON COLUMN HOPE_BOOK.book_publisher IS '도서 출판사'
/

COMMENT ON COLUMN HOPE_BOOK.book_author IS '도서 작가'
/

COMMENT ON COLUMN HOPE_BOOK.ib_status IS '입고 상태'
/

COMMENT ON COLUMN HOPE_BOOK.hope_reg_date IS '신청 날짜'
/

ALTER TABLE HOPE_BOOK
    ADD CONSTRAINT FK_HOPE_BOOK_member_no_MEMBER_ FOREIGN KEY (member_no)
        REFERENCES MEMBER (member_no)
        ON DELETE SET NULL
/


-- RESERVATION Table Create SQL
CREATE TABLE RESERVATION
(
    member_no               NUMBER(3)       NOT NULL,
    book_no                 VARCHAR2(10)    NOT NULL,
    reservation_reg_date    DATE            DEFAULT SYSDATE NOT NULL,
    CONSTRAINT PK_RESERVATION PRIMARY KEY (member_no, book_no)
)
/

COMMENT ON TABLE RESERVATION IS 'member_no on delete cascade'
/

COMMENT ON COLUMN RESERVATION.member_no IS '회원 번호'
/

COMMENT ON COLUMN RESERVATION.book_no IS '도서 번호'
/

COMMENT ON COLUMN RESERVATION.reservation_reg_date IS '예약 등록 날짜'
/

ALTER TABLE RESERVATION
    ADD CONSTRAINT FK_RESERVATION_member_no_MEMBE FOREIGN KEY (member_no)
        REFERENCES MEMBER (member_no)
        ON DELETE CASCADE
/

ALTER TABLE RESERVATION
    ADD CONSTRAINT FK_RESERVATION_book_no_BOOK_bo FOREIGN KEY (book_no)
        REFERENCES BOOK (book_no)
        ON DELETE CASCADE
/


-- REPLY Table Create SQL
CREATE TABLE REPLY
(
    reply_no         NUMBER(3)         NOT NULL,
    reply_content    VARCHAR2(4000)    NOT NULL,
    qna_no           NUMBER(3)         NOT NULL,
    member_no        NUMBER(3)         NOT NULL,
    CONSTRAINT PK_REPLY PRIMARY KEY (reply_no)
)
/

CREATE SEQUENCE REPLY_SEQ
START WITH 1
INCREMENT BY 1;
/

COMMENT ON TABLE REPLY IS 'qna_no on delete cascade, member_no on delete  cascade'
/

COMMENT ON COLUMN REPLY.reply_no IS '번호'
/

COMMENT ON COLUMN REPLY.reply_content IS '내용'
/

COMMENT ON COLUMN REPLY.qna_no IS 'QNA 번호'
/

COMMENT ON COLUMN REPLY.member_no IS '회원 번호'
/

ALTER TABLE REPLY
    ADD CONSTRAINT FK_REPLY_qna_no_QNA_qna_no FOREIGN KEY (qna_no)
        REFERENCES QNA (qna_no)
        ON DELETE CASCADE
/

ALTER TABLE REPLY
    ADD CONSTRAINT FK_REPLY_member_no_MEMBER_memb FOREIGN KEY (member_no)
        REFERENCES MEMBER (member_no)
        ON DELETE CASCADE
/


-- LEAVE_MEMBER Table Create SQL
CREATE TABLE LEAVE_MEMBER
(
    leave_no          NUMBER(3)         NOT NULL,
    member_id         VARCHAR2(20)      NOT NULL,
    member_opinion    VARCHAR2(4000)    NULL,
    leave_date        DATE              DEFAULT SYSDATE NOT NULL,
     PRIMARY KEY (leave_no)
)
/

CREATE SEQUENCE LEAVE_MEMBER_SEQ
START WITH 1
INCREMENT BY 1;
/

COMMENT ON TABLE LEAVE_MEMBER IS '회원 탈퇴 후 id만 복사하고 의견을 남겨둠'
/

COMMENT ON COLUMN LEAVE_MEMBER.leave_no IS '탈퇴 번호'
/

COMMENT ON COLUMN LEAVE_MEMBER.member_id IS '회원 아이디'
/

COMMENT ON COLUMN LEAVE_MEMBER.member_opinion IS '회원 의견'
/

COMMENT ON COLUMN LEAVE_MEMBER.leave_date IS '탈퇴 날짜'
/



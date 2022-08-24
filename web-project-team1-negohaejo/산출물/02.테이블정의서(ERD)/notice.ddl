DROP TABLE CART CASCADE CONSTRAINTS;
DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE PURCHASE_ITEM CASCADE CONSTRAINTS;
DROP TABLE purchase CASCADE CONSTRAINTS;
DROP TABLE USERINFO CASCADE CONSTRAINTS;
DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP TABLE PRODUCT2 CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: PRODUCT2 */
/**********************************/
CREATE TABLE PRODUCT2(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(300)		 NULL ,
		p_desc                        		VARCHAR2(3000)		 NULL ,
		p_date                        		DATE		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_img                         		VARCHAR2(300)		 NULL ,
		p_cat                         		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE PRODUCT2_p_no_SEQ;

CREATE SEQUENCE PRODUCT2_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER PRODUCT2_p_no_TRG
BEFORE INSERT ON PRODUCT2
FOR EACH ROW
BEGIN
IF :NEW.p_no IS NOT NULL THEN
  SELECT PRODUCT2_p_no_SEQ.NEXTVAL INTO :NEW.p_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE PRODUCT2 is 'PRODUCT2';
COMMENT ON COLUMN PRODUCT2.p_no is 'p_no';
COMMENT ON COLUMN PRODUCT2.p_name is 'p_name';
COMMENT ON COLUMN PRODUCT2.p_desc is 'p_desc';
COMMENT ON COLUMN PRODUCT2.p_date is 'p_date';
COMMENT ON COLUMN PRODUCT2.p_price is 'p_price';
COMMENT ON COLUMN PRODUCT2.p_img is 'p_img';
COMMENT ON COLUMN PRODUCT2.p_cat is 'p_cat';


/**********************************/
/* Table Name: NOTICE */
/**********************************/
CREATE TABLE NOTICE(
		noti_no                       		NUMBER(10)		 NULL ,
		noti_title                    		VARCHAR2(100)		 NULL ,
		noti_content                  		VARCHAR2(3000)		 NULL ,
		noti_date                     		DATE		 DEFAULT sysdate		 NULL ,
		noti_file                     		VARCHAR2(1000)		 NULL 
);

DROP SEQUENCE NOTICE_noti_no_SEQ;

CREATE SEQUENCE NOTICE_noti_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER NOTICE_noti_no_TRG
BEFORE INSERT ON NOTICE
FOR EACH ROW
BEGIN
IF :NEW.noti_no IS NOT NULL THEN
  SELECT NOTICE_noti_no_SEQ.NEXTVAL INTO :NEW.noti_no FROM DUAL;
END IF;
END;

COMMENT ON TABLE NOTICE is 'NOTICE';
COMMENT ON COLUMN NOTICE.noti_no is 'noti_no';
COMMENT ON COLUMN NOTICE.noti_title is 'noti_title';
COMMENT ON COLUMN NOTICE.noti_content is 'noti_content';
COMMENT ON COLUMN NOTICE.noti_date is 'noti_date';
COMMENT ON COLUMN NOTICE.noti_file is 'noti_file';


/**********************************/
/* Table Name: USERINFO */
/**********************************/
CREATE TABLE USERINFO(
		U_ID                          		VARCHAR2(20)		 NULL ,
		U_PASSWORD                    		VARCHAR2(20)		 NULL ,
		U_NAME                        		VARCHAR2(20)		 NULL ,
		U_BIRTH                       		VARCHAR2(10)		 NULL ,
		U_GENDER                      		CHAR(10)		 NULL ,
		U_PHONE                       		VARCHAR2(20)		 NULL ,
		U_ADDRESS                     		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE USERINFO is 'USERINFO';
COMMENT ON COLUMN USERINFO.U_ID is 'U_ID';
COMMENT ON COLUMN USERINFO.U_PASSWORD is 'U_PASSWORD';
COMMENT ON COLUMN USERINFO.U_NAME is 'U_NAME';
COMMENT ON COLUMN USERINFO.U_BIRTH is 'U_BIRTH';
COMMENT ON COLUMN USERINFO.U_GENDER is 'U_GENDER';
COMMENT ON COLUMN USERINFO.U_PHONE is 'U_PHONE';
COMMENT ON COLUMN USERINFO.U_ADDRESS is 'U_ADDRESS';


/**********************************/
/* Table Name: purchase */
/**********************************/
CREATE TABLE purchase(
		o_No                          		NUMBER(1000)		 DEFAULT 0		 NULL ,
		o_ItemListNum                 		NUMBER(10)		 DEFAULT 0		 NULL ,
		o_PaySelect                   		VARCHAR2(10)		 DEFAULT null		 NULL ,
		o_ItemTotPrice                		INTEGER(100000000)		 DEFAULT 0		 NULL ,
		U_ID                          		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE purchase is 'purchase';
COMMENT ON COLUMN purchase.o_No is 'o_No';
COMMENT ON COLUMN purchase.o_ItemListNum is 'o_ItemListNum';
COMMENT ON COLUMN purchase.o_PaySelect is 'o_PaySelect';
COMMENT ON COLUMN purchase.o_ItemTotPrice is 'o_ItemTotPrice';
COMMENT ON COLUMN purchase.U_ID is 'U_ID';


/**********************************/
/* Table Name: PURCHASE_ITEM */
/**********************************/
CREATE TABLE PURCHASE_ITEM(
		OI_NO                         		NUMBER(10)		 NULL ,
		OI_QTY                        		INTEGER(10)		 NULL ,
		o_No                          		INTEGER(1000)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

COMMENT ON TABLE PURCHASE_ITEM is 'PURCHASE_ITEM';
COMMENT ON COLUMN PURCHASE_ITEM.OI_NO is 'OI_NO';
COMMENT ON COLUMN PURCHASE_ITEM.OI_QTY is 'OI_QTY';
COMMENT ON COLUMN PURCHASE_ITEM.o_No is 'o_No';
COMMENT ON COLUMN PURCHASE_ITEM.p_no is 'p_no';


/**********************************/
/* Table Name: review */
/**********************************/
CREATE TABLE review(
		review_no                     		NUMBER(10)		 NULL ,
		reviewDESC                    		VARCHAR2(10)		 NULL ,
		U_ID                          		VARCHAR2(20)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		r_score                       		NUMBER(10)		 NULL ,
		O_ITEM                        		INTEGER(10)		 NULL ,
		OI_NO                         		NUMBER(10)		 NULL 
);

COMMENT ON TABLE review is 'review';
COMMENT ON COLUMN review.review_no is 'review_no';
COMMENT ON COLUMN review.reviewDESC is 'reviewDESC';
COMMENT ON COLUMN review.U_ID is 'U_ID';
COMMENT ON COLUMN review.p_no is 'p_no';
COMMENT ON COLUMN review.r_score is 'r_score';
COMMENT ON COLUMN review.O_ITEM is 'O_ITEM';
COMMENT ON COLUMN review.OI_NO is 'OI_NO';


/**********************************/
/* Table Name: CART */
/**********************************/
CREATE TABLE CART(
		c_no                          		NUMBER(10)		 NOT NULL,
		c_qty                         		NUMBER(10)		 NULL ,
		U_ID                          		VARCHAR2(20)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

COMMENT ON TABLE CART is 'CART';
COMMENT ON COLUMN CART.c_no is 'c_no';
COMMENT ON COLUMN CART.c_qty is 'c_qty';
COMMENT ON COLUMN CART.U_ID is 'U_ID';
COMMENT ON COLUMN CART.p_no is 'p_no';



ALTER TABLE PRODUCT2 ADD CONSTRAINT IDX_PRODUCT2_PK PRIMARY KEY (p_no);

ALTER TABLE NOTICE ADD CONSTRAINT IDX_NOTICE_PK PRIMARY KEY (noti_no);

ALTER TABLE USERINFO ADD CONSTRAINT IDX_USERINFO_PK PRIMARY KEY (U_ID);

ALTER TABLE purchase ADD CONSTRAINT IDX_purchase_PK PRIMARY KEY (o_No);
ALTER TABLE purchase ADD CONSTRAINT IDX_purchase_FK0 FOREIGN KEY (U_ID) REFERENCES USERINFO (U_ID);

ALTER TABLE PURCHASE_ITEM ADD CONSTRAINT IDX_PURCHASE_ITEM_PK PRIMARY KEY (OI_NO);
ALTER TABLE PURCHASE_ITEM ADD CONSTRAINT IDX_PURCHASE_ITEM_FK0 FOREIGN KEY (o_No) REFERENCES purchase (o_No);
ALTER TABLE PURCHASE_ITEM ADD CONSTRAINT IDX_PURCHASE_ITEM_FK1 FOREIGN KEY (p_no) REFERENCES PRODUCT2 (p_no);

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (review_no);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (U_ID) REFERENCES USERINFO (U_ID);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK1 FOREIGN KEY (p_no) REFERENCES PRODUCT2 (p_no);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK2 FOREIGN KEY (OI_NO) REFERENCES PURCHASE_ITEM (OI_NO);

ALTER TABLE CART ADD CONSTRAINT IDX_CART_PK PRIMARY KEY (c_no);
ALTER TABLE CART ADD CONSTRAINT IDX_CART_FK0 FOREIGN KEY (U_ID) REFERENCES USERINFO (U_ID);
ALTER TABLE CART ADD CONSTRAINT IDX_CART_FK1 FOREIGN KEY (p_no) REFERENCES PRODUCT2 (p_no);


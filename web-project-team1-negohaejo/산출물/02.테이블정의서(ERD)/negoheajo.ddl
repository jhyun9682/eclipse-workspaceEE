DROP TABLE CART CASCADE CONSTRAINTS;
DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE PURCHASE_ITEM CASCADE CONSTRAINTS;
DROP TABLE purchase CASCADE CONSTRAINTS;
DROP TABLE USERINFO CASCADE CONSTRAINTS;
DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP TABLE PRODUCT2 CASCADE CONSTRAINTS;

CREATE TABLE PRODUCT2(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(100)		 NULL ,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_date                        		DATE		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_img                         		VARCHAR2(100)		 NULL ,
		p_cat                         		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE PRODUCT2_p_no_SEQ;

CREATE SEQUENCE PRODUCT2_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE NOTICE(
		noti_no                       		NUMBER(10)		 NULL ,
		noti_title                    		VARCHAR2(100)		 NULL ,
		noti_content                  		VARCHAR2(200)		 NULL ,
		noti_date                     		DATE		 NULL ,
		noti_file                     		VARCHAR2(200)		 NULL 
);

DROP SEQUENCE NOTICE_noti_no_SEQ;

CREATE SEQUENCE NOTICE_noti_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE USERINFO(
		U_ID                          		VARCHAR2(100)		 NULL ,
		U_PASSWORD                    		VARCHAR2(100)		 NULL ,
		U_NAME                        		VARCHAR2(100)		 NULL ,
		U_BIRTH                       		VARCHAR2(100)		 NULL ,
		U_GENDER                      		CHAR(10)		 NULL ,
		U_PHONE                       		VARCHAR2(100)		 NULL ,
		U_ADDRESS                     		VARCHAR2(200)		 NULL 
);


CREATE TABLE purchase(
		o_No                          		NUMBER(10)		 DEFAULT 0		 NULL ,
		o_ItemListNum                 		NUMBER(10)		 DEFAULT 0		 NULL ,
		o_PaySelect                   		VARCHAR2(100)		 DEFAULT null		 NULL ,
		o_ItemTotPrice                		NUMBER(10)		 DEFAULT 0		 NULL ,
		U_ID                          		VARCHAR2(50)		 NULL 
);


CREATE TABLE PURCHASE_ITEM(
		OI_NO                         		NUMBER(10)		 NULL ,
		OI_QTY                        		NUMBER(10)		 NULL ,
		o_No                          		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);


CREATE TABLE review(
		review_no                     		NUMBER(10)		 NULL ,
		reviewDESC                    		VARCHAR2(100)		 NULL ,
		U_ID                          		VARCHAR2(50)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		r_score                       		NUMBER(10)		 NULL ,
		O_ITEM                        		NUMBER(10)		 NULL ,
		OI_NO                         		NUMBER(10)		 NULL 
);


CREATE TABLE CART(
		c_no                          		NUMBER(10)		 NOT NULL,
		c_qty                         		NUMBER(10)		 NULL ,
		U_ID                          		VARCHAR2(100)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);



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


--BOOK(책) insert
--b_no, b_name, b_class, b_author, b_publisher, b_summary, b_image, b_price
/*
--1번 자기계발서
insert into book values(book_b_no_seq.nextval, '마시멜로이야기', '자기계발','호아킴 데 포사다', '한국경제신문사','달콤한 유혹에서 이겨낼 때, 비로소 얻게 된다', '1_marshmallow', 12000);
insert into book values(book_b_no_seq.nextval, '누가 내 치즈를 옮겼을까?', '자기계발','스펜서 존슨','진명출판사','인생에서 부딪힐 변화를 대처할 수 있는 지혜','1_who',13500);
insert into book values(book_b_no_seq.nextval, '미움받을 용기', '자기계발','기시미 이치로','진명출판사','자유롭고 행복한 삶을 위한 가르침','1_courage',14900);
insert into book values(book_b_no_seq.nextval, '최강의 멘탈관리','자기계발', '킴벌리 페이스', '포르체','세계 리더들의 지도자 멘탈 코칭', '1_reader', 17000 );
insert into book values(book_b_no_seq.nextval, '나를 찾는 시간','자기계발', '유창선', '새빛','나이 든다는 것은 생각만큼 슬프지 않다', '1_time', 16000);
--2번 건강
insert into book values(book_b_no_seq.nextval, '식사만 바꿔도 젊어집니다','건강', '마키타 젠지', '북드림','항노화 전문의가 알려주는 늙지 않는 식사법', '2_food', 16500);
insert into book values(book_b_no_seq.nextval, '당질 중독', '건강', '마키타 젠지', '문예춘추사','올바른 탄수화물 조절로 내 몸 리셋', '2_party',14000);
insert into book values(book_b_no_seq.nextval, '피곤해지지 않는 올바른 자세 도감 100', '건강', '나츠시마 다카시', '즐거운상상','올바른 자세를 위한 방법', '2_posture', 15000);
insert into book values(book_b_no_seq.nextval, '절대 지치지 않는 몸', '건강','나카노 제임스 슈이치','비타북스','과학적 원리를 통해 배우는 최강의 피로 해소법','2_body', 15000);
insert into book values(book_b_no_seq.nextval, '글루코스 혁명', '건강', '제시 인차우스페', '아침사과','좋아하는 음식을 즐기면서 과학적으로 체중을 줄이는 10가지 방법', '2_superfood',18000);
--3번 요리
insert into book values(book_b_no_seq.nextval, '삐뽀삐뽀 119 이유식','요리', '소아청소년과 전문의 하정훈이 전하는 건강한 아가 밥상', '3_babyfood', '하정훈','유니책방',18900);
insert into book values(book_b_no_seq.nextval, '우리술 익스프레스','요리', '탁재형', 'EBS BOOKS','와인, 위스키, 사케 못지않은 K-술의 매력','3_drink',16500);
insert into book values(book_b_no_seq.nextval, '구움과자 클래스','요리', '이지혜', '시대인', '슬픈하품의 따뜻한 홈베이킹', '3_brade', 17000);
insert into book values(book_b_no_seq.nextval, '맛있다 죽', '요리', '한복선', '리스컴', '건강을 담은 한 그릇','3_porridge',16000);
insert into book values(book_b_no_seq.nextval, '오늘도 달걀', '요리', '손성희', '리스컴', '만약에 달걀이 없었더라면 무엇으로 식탁을 차릴까', '3_egg',14000);
--4번 컴퓨터IT
insert into book values(book_b_no_seq.nextval, 'clean code', '컴퓨터IT','로버트 C. 마틴', '인사이트','애자일 소프트웨어 장인 정신','4_code',33000);
insert into book values(book_b_no_seq.nextval, '클린 아키텍처','컴퓨터IT', '로버트 C. 마틴', '인사이트', '모든 프로그래머가 읽어야 하는 필독서!', '4_cleancode', 29000);
insert into book values(book_b_no_seq.nextval, '리팩터링', '컴퓨터IT','마틴 파울러', '한빛미디어','코드 구조를 체계적으로 개선하여 효율적인 리팩터링 구현하기', '4_repack', 35000);
insert into book values(book_b_no_seq.nextval, '객체지향의 사실과 오해','컴퓨터IT', '조영호', '위키북스', '역할, 책임, 협력 관점에서 본 객체지향', '4_fact', 20000);
insert into book values(book_b_no_seq.nextval, '인스파이어드', '컴퓨터IT', '마티 케이건', '제이펍', '감동을 전하는 IT 제품은 어떻게 만들어지는가?', '4_inspired', 24000);
--5번 공포
insert into book values(book_b_no_seq.nextval, '그리고 아무도 없었다', '공포','애거서 크리스티', '해문출판사','다들 어디간거야?', '5_nomore', 12000);
insert into book values(book_b_no_seq.nextval, 'R의 공포가 온다', '공포','김효신', '트러스트북스','기회를 동반한 또 다른 경제위기의 시작','5_R', 20000);
insert into book values(book_b_no_seq.nextval, '신비아파트 오싹오싹 무서운 이야기','공포', '앨리스,윤희정', '서울문화사','무서운 신비아파트에서 탈출하자', '5_apart', 15000);
insert into book values(book_b_no_seq.nextval, '오싹오싹 OK 공포 만화', '공포', '백철,계건일', '효리원', '심장이 쫄깃! 머리카락이 쭈뼛!', '5_ok', 5500);
insert into book values(book_b_no_seq.nextval, '악몽', '공포', '조이스 캐럴 오츠','포레','너무 무서워서 줄거리가 없습니다.','5_dream', 15000);
*/

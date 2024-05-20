--시퀀스 생성
--기본 1부터 1씩 증가하는 시퀀스는 생략하고 기본명령어만 주면 됨
create sequence seq1;
--전체 시퀀스 조회
select * from seq;
--시퀀스는 고유값의 기능이라 다시 발생할 수는 없다
--다음 시퀀스값 발생: nextval
select seq1.nextval from DUAL; --1씩 증가된 값이 발생한다

--10부터 5씩 증가하는 시퀀스를 생성해보자, 캐쉬가 기본 20인데 없애보자
create sequence seq2 start with 10 increment by 5 nocache;

--seq2값을 발생시켜보자
select seq2.nextval from DUAL;

--1부터 3씩 증가, 캐쉬0,맥스100
create sequence seq3 start with 1 increment by 3 nocache maxvalue 100;

--seq3값 발생
select seq3.nextval from DUAL;

--시퀀스도 제거
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

--최종 테이블에서 사용할 시퀀스 생성(1부터 1씩 증가(생략),cache 0)
create sequence seq_test nocache;
/////////////////////////////////
create table hello (
    idx number(3) primary key,
    irum varchar2(20),
    age number(3)
);

--테이블 구조 수정: alter table
-- irum 의 길이를 20에서 30으로 수정해보자
alter table hello modify  irum varchar2(30);

--addr이라는 컬럼을 추가해보자(문자열 길이는 100)
alter table hello add addr varchar2(100);

--age 라는 컬럼을 제거해보자
alter table hello drop column age; --alter 테이블에서 drop(삭제)과 rename(컬럼명 변경)쓸 때만 column 이 들어간다

--컬럼명 변경(addr -> address)
alter table hello rename column addr to address;

--컬럼 하나 추가해보자
alter table hello add blood varchar2(3);
alter table hello add age number(3);

--데이터를 추가해보자
insert into hello (irum) values ('lee'); --에러발생, idx는 pk이므로 반드시 값을 넣어야 한다
--Primary Key 는 NOT NULL이어야 함
insert into hello (idx,irum) values (seq_test.nextval,'lee');

insert into hello(idx,blood,address) values (seq_test.nextval,'ab','서울 역삼');
--컬럼명 생략시 테이블의 컬럼 순서대로 모든 값을 줘야한다
insert into hello values (seq_test.nextval,'이진','제주도 애월읍','o',23);

--수정
--이름이 '이진'인 사람의 혈액형을 b형으로 변경
update hello set blood='b'where irum='이진';
--idx가 2인 사람의 irum과 age를 수정해보자
update hello set irum='강호동',age=35 where idx=2; --where 조건을 주지 않으면 전체 데이터가 다 바뀐다
--idx가 1인 사람의 address,blood,age의 값을 수정하세요
update hello set address='부산 해운대구',blood='a',age='23' where idx=1;

--삭제(DELETE) , where 조건 안주면 전체 데이터 모두 지워짐
--idx가 1인 사람 삭제
delete from hello where idx=1;
--age가 30 이상인 데이터는 모두 삭제
delete from hello where age>=30;

--테이블 제거
drop table hello;

select * from hello;
------------------------------------------------------------------------
--새로운 테이블 생성, 이번에는 각종 제약조건을 추가해서 생성해보자
create table student (
    num number(3) CONSTRAINT pk_num primary key ,
    stuname varchar2(20) CONSTRAINT nn_name not null ,
    score number(3) CONSTRAINT ck_score check ( score>=1 and score<=100),
    birthday date
);

--insert로 데이터 추가를 하는데 각종 에러를 발생시켜보자
insert into student (num,stuname) values (1,'김미리');
--ORA-01400: NULL을 ("ANGEL"."STUDENT"."NUM") 안에 삽입할 수 없습니다
insert into student (stuname, score) values ('이미자',45); --오류

--ORA-00001: 무결성 제약 조건(ANGEL.PK_NUm)에 위배됩니다
--num 은 pk(pk는 not null+unique)
insert into student (num, stuname) values (1,'홍진주'); --오류

--ORA-02290: 체크 제약조건(ANGEL.CK_SCORE)이 위배되었습니다
--score의 범위는 1~100이야 한다
insert into student (num, stuname, score) values (2,'강동호',110) ; --오류

insert into student values (3,'이미자',89,sysdate); --날짜는 현재날짜로
insert into student values (4,'김민종',100,'2010-12-20');
commit;
insert into student values (5,'곤미나',56,'2019-05-10');
insert into student values (6,'강수지',98,sysdate);
insert into student values (7,'김진우',97,'2015-09-12');
insert into student values (8,'강호동',97,'2019-05-03');
commit;
rollback;--마지막 commit한 이후의 DML 작업에 대한 롤백

--num이 5번인 데이터의 이름을 '손미라', score를 80으로 수정
update student set stuname='손미라', score=80 where num=5;
--birthday의 월이 5인 사람의 점수를 일괄적으로 85로 수정
update student set score=85 where TO_CHAR(birthday,'mm')=5;

commit;

--num이 7인 데이터 삭제
delete from student where num=7; --여기서 from 없어도 실행 됨.
--롤백 후 데이터 확인하기
rollback ;
--다시 삭제문 실행
delete from student where num=7;
--커밋하기
commit;
--다시 롤백 후 데이터 확인하기
rollback; --이미 커밋된 데이터는 취소되지 않는다

--불필요한 제약조건 제거
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

--새로운 제약조건 추가
alter table student add constraint uq_name unique(stuname); --unigue를 주었기 때문에 같은 이름은 들어갈 수 없음(고유성)

--같은 이름의 데이터를 추가해보자
--오류: ORA-00001: 무결성 제약 조건(ANGEL.UQ_NAME)에 위배됩니다
insert into student (num,stuname) values (10,'강호동');

--연습이 끝난후 시퀀스랑 테이블 삭제
drop sequence seq_test;
drop table student;
-----------------------------------------------------------------------------------------------
/*
 join 연습용 테이블 2개 생성하기
 테이블 #1 :
        (부모 테이블)
        food - foodnum 숫자(3)
               foodname 문자열(20)
               foodprice 숫자(7)
        (자식 테이블)
        booking - bnum pk 숫자(3)
                  bname 문자열(20) nn
                  bhp 문자열(20) uq
                  foodnum 숫자(3) - fk(food의 foodnum)
                  bookingday date
    외부키로 연결된 경우 booking에 데이터가 추가된 이후 추가된 foodnum은 삭제할 수 없다
    (예를 들어 게시판의 댓글같은 경우 외부키로 연결되어 있는데
      이때도 댓글이 달린 경우 해당글을 삭제할 수 없는 게시판들이 있다)
     - 그런데 만약 food의 데이터를 삭제하면 그 메뉴를 추가한 고객의 데이터도 자동으로 삭제시키고자 할 경우
       booking에 외부키를 설정할 때 on delete cascade를 주면 된다

 */
create  table food (
    foodnum number(3) constraint  pk_foodnum primary key ,
    foodname varchar2(20),
    foodprice number(7),
    foodsize varchar2(20)
);

insert into food values (100,'짜장면',9000,'보통');
insert into food values (101,'짜장면',11000,'곱배기');
insert into food values (200,'탕수육',15000,'보통');
insert into food values (201,'탕수육',20000,'곱배기');
insert into food values (300,'칠리새우',15000,'소');
insert into food values (301,'칠리새우',30000,'대');
insert into food values (400,'해물짬뽕',11000,'보통');

commit;

select * from food;

--시퀀스 추가
create sequence seq_food nocache ;

--booking 테이블 생성
create table booking(
    bnum number(3) constraint pk_bnum primary key,
    bname varchar2(22) constraint nn_bname not null,
    bhp varchar2(20) constraint uq_bhp unique,
    foodnum number(3) ,
    bookingday date,
    constraint fk_foodnum foreign key (foodnum) references food(foodnum)
);

--예약 테이블에 데이터를 추가
select * from booking;

insert into booking values (seq_food.nextval,'홍범자','010-2222-3333',101,sysdate);

--ORA-00001: 무결성 제약 조건(ANGEL.UQ_BHP)에 위배됩니다, 핸드폰이 같으면 안됨
insert into booking values (seq_food.nextval,'강호동','010-2222-3333',101,sysdate);--오류발생

--오늘로부터 7일 후 예약
insert into booking values (seq_food.nextval,'이영자','010-3434-8899',301,sysdate+7);

--없는 메뉴 주문시 오류발생
--ORA-00001: 무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다 - 부모 키가 없습니다
insert into booking values (seq_food.nextval,'박지민','010-3434-45459',500,sysdate+3);--오류발생

insert into booking values (seq_food.nextval,'박지민','010-3434-4545',201,sysdate+3);

insert into booking values (seq_food.nextval,'손미나','010-3434-1234',100,sysdate+10);

insert into booking values (seq_food.nextval,'이효리','010-3434-4321',400,sysdate+1);

commit;

--join으로 두 테이블을 조인해서 출력하시오
--bnum,bname,bhp,foodnum,foodname,foodprice,foodsize,bookingday(yyyy-mm-dd)
select bnum,bname,bhp,b.foodnum,foodname,foodprice,foodsize,to_char(bookingday,'yyyy-mm-dd') bookingday
from food f,booking b
where f.foodnum=b.foodnum;

rollback ;

select * from food;
select * from booking;

--아무도 예약하지 않은 food 음식은?
select
    bnum,f.foodnum,foodname,foodprice,foodsize
from food f,booking b
where f.foodnum=b.foodnum(+) and bnum is null; --(+)은 LEFT OUTER JOIN food가 기준으로, food테이블에 속한 foodnum이 booking 테이블에 없는 것을 의미

--food의 200번 메뉴는 삭제가 될까?
delete from food where foodnum=200; --아무도 주문한 사람이 없으므로 삭제 가능
--food의 100번 메뉴는 삭제가 될까?

--ORA-02292: 무결성 제약조건(ANGEL.FK_FOODNUM) 이 위배되었습니다- 자식 레코드가 발견되었습니다
delete from food where foodnum=100; --100번 메뉴를 주문한 고객이 있으므로 삭제할 수 없음

--부모 테이블인 food를 삭제
drop table food; --오류발생, 자식테이블을 먼저 삭제 후 부모테이블을 삭제해야만 한다

--연습 끝 두 테이블 제거
drop table booking; --자식테이블 먼저 제거
drop  table food; --자식테이블 제거 후 부모테이블 제거
--시퀀스도 제거
drop SEQUENCE seq_food;

/*
SELECT * FROM a, b WHERE b.id(+)= a.id -- Oracle OUTER JOIN
SELECT * FROM a LEFT OUTER JOIN b ON b.id = a.id -- 동일한 표현

a.id = b.id (+) -- LEFT OUTER
A.id(+) = b.id -- RIGHT OUTER

 */
------------------------------------------------------------------------------
--on delete cascade 예제
-- 이번에는 부모테이블의 데이터 삭제시 서브테이블의 데이터도 자동으로 삭제되도록
-- 외부키를 설정해보자
-- 시퀀스 생성
create SEQUENCE seq_shop;
--shop,cart
create table shop (
    sang_no number(3) constraint shop_pk_no primary key,
    sang_name varchar2(30),
    sang_price number(10)
);
--외부키 설정시 on delete cascade를 붙이면 부모테이블 삭제시 자식테이블에 추가된
--데이터도 같이 삭제됨
create table cart(
    cart_no number(3) constraint cart_pk_no PRIMARY KEY,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);
--delete cascade: 상품을 지우면 상품을 담은 10명의 데이터도 지워짐

/* CASCADE
- 참조 관계(기본키와 외래키 관계)가 있을 경우 참조되는 데이터도 자동으로 삭제 가능
- 자신이 참조하고 있는 테이블의 데이터가 삭제되면 자동으로 자신의 데이터도 삭제
- CASCADE 사용시 참조 무결성을 준수할 수 있음
   + 참조무결성: 마스터 테이블(DEPT)에는 해당 부서번호(DEPTNO)가 없는데, 슬레이브 테이블(EMP)에는 해당 부서번호가 있는 경우 참조무결성 위배
 */

--5개의 상품을 등록해보자
insert into shop values (seq_shop.nextval,'블라우스',12000);
insert into shop values (seq_shop.nextval,'조끼',19000);
insert into shop values (seq_shop.nextval,'청바지',25000);
insert into shop values (seq_shop.nextval,'체크코트',99000);
insert into shop values (seq_shop.nextval,'티셔츠',11000);
commit;
select * from shop;

--cart 에 원하는 상품을 담아보자
insert into cart values (seq_shop.nextval,2,3,sysdate);
insert into cart values (seq_shop.nextval,1,2,sysdate);
insert into cart values (seq_shop.nextval,5,1,sysdate);
commit;

--join으로 조회하기
--cart_no,sang_no,sang_name,sang_price,cnt,cartday(yyyy-mm-dd) 출력
select
    cart_no,s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from cart c, shop s
where c.sang_no=s.sang_no;

--아무도 카트에 담지 않은 상품은?
select cart_no,s.sang_no,sang_name,sang_price
from cart c, shop s
where s.sang_no=c.sang_no(+) and cart_no IS NULL;

--on delete cascade를 한 경우 cart에 추가된 상품도 삭제가 가능하다
--2번 조끼 상품을 삭제해보자
delete from shop where sang_no=2;

--cart를 확인해보면 cart에 있던 2번 상품도 사라진 걸 확인할 수 있다
select
    cart_no,s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from shop s,cart c
where s.sang_no=c.sang_no;

--테이블 제거는 서브테이블부터 삭제
drop table cart;
drop table shop;
drop sequence seq_shop;


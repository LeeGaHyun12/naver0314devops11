-- mysql 파일의 함수부분 복사해서 실행시켜 결과를 보세요
select concat('happy','day') from dual; /*문자열더함*/
select concat('apple','kiwi','mango') from dual;
select replace('have a nice day','a','*') from dual;
select instr('happy','a') from dual;
select instr('happy','x') from dual;
select left('have a nice day',4) from dual;
select right('have a nice day',5) from dual;
select mid('have a nice day',8,4) from dual;
select substring('have a nice day',8,4) from dual;
select left('가나다라마바사',3) from dual; /*한글도3글자 나옴*/
select substring('가나다라마바사',4,2) from dual;
select concat(ltrim('   abc    '),'*') from dual;
select concat(rtrim('   abc    '),'*') from dual;
select concat(trim('   abc    '),'*') from dual;
select lcase('Happy'),lower('Happy') from dual;
select ucase('Happy'),upper('Happy') from dual;
select reverse('Happy') from dual;
select abs(-10) from dual;/*무조건 양수값 반환*/
select ceiling(2.1) from dual; /*무조건올림  3 */
select floor(2.9) from dual; /*무조건내림  2 */
select truncate(2.345,2) from dual; /*소숫점2자리까지 출력되고 3자리에서 내림*/
select mod(5,3) from dual;/*5를 3으로 나눈나머지=2*/
select greatest(12,23,34,11,4) from dual;/*가장 큰숫자*/
select least(12,23,34,11,4) from dual;/*가장 작은숫자*/

-- join 연습
create table bitclass (
                          idx smallint primary key,
                          class varchar(30),
                          price int,
                          gigan smallint);

create table stu (
                     num smallint auto_increment primary key,
                     name varchar(20),
                     idx smallint,
                     sugangday date,
                     constraint stu_fk_idx foreign key(idx) references bitclass(idx));

-- bitclass 에 데이타 추가
insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);
insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);

select * from bitclass;

-- stu 에 데이타 추가
insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());

select * from stu;

-- join 1
select * from bitclass bc,stu where bc.idx=stu.idx;
-- join 2
select name,class,price,gigan,sugangday from bitclass bc,stu
where bc.idx=stu.idx;
-- join 3
select name,class,price,gigan,sugangday from bitclass bc
                                                 inner join stu on bc.idx=stu.idx;

-- join 연습용 테이블 삭제
drop table stu;
drop table bitclass;

show tables;

-- join 연습용 테이블 2개 생성 : on delete cacade
create table shop(
                     shopnum smallint auto_increment primary key,
                     sangpum varchar(30),
                     price int,
                     color varchar(20) default 'black'
);

create table cart(
                     cartnum smallint auto_increment primary key,
                     username varchar(20),
                     shopnum smallint,
                     guipday datetime,
                     constraint fk_shopnum foreign key(shopnum)
                         references shop(shopnum) on delete cascade
);

-- shop 에 5개의 상품을 등록해보자
insert into shop (sangpum,price) values ('블라우스',12000);
insert into shop values (null,'청바지',29000,'blue');
insert into shop values (null,'레이스조끼',31000,'yellow');
insert into shop values (null,'주름스커트',43000,'green');
insert into shop values (null,'체크남방',32000,'pink');

select * from shop;

-- cart 에도 데이타 추가하기
select * from cart;
insert into cart values (null,'이진',3,now());
insert into cart values (null,'강철수',1,now());
insert into cart values (null,'유재석',4,now());
insert into cart values (null,'한예슬',5,now());
insert into cart values (null,'강호동',1,now());

-- join 1
select * from shop,cart where shop.shopnum=cart.shopnum;

-- join 2
select
    username,sangpum,price,color,guipday
from shop s,cart c where s.shopnum=c.shopnum;

-- join 3
select
    username,sangpum,price,color,guipday
from shop
         inner join cart
                    on shop.shopnum=cart.shopnum;

-- shop 에서 1번 블라우스를 삭제해보자
delete from shop where shopnum=1;

-- 다시 조인
select
    username,sangpum,price,color,guipday
from shop
         inner join cart
                    on shop.shopnum=cart.shopnum;

-- 문제 : 아래의 결과를 자바파일로 실행해서 출력되도록 하세요
select buseo,count(*) inwon, max(score) maxscore, ceiling(avg(score)) avgscore
from sawon
group by buseo;
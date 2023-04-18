-- 전화번호 저장 테이블

-- 전화번호부 테이블을 기준으로 DML 을 작성해봅시다.

-- 1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

-- 2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

-- 3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

create table phoneInfo_basic (
 
    
    idx number(6) primary key,
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate
            
);
create table phoneInfo_univ (
    idx number(6) primary key,
    fr_u_major varchar2(20)  default 'N' not null,
    fr_u_year number(1)  default 1 check (5>=fr_u_year AND fr_u_year>=1) not null , 
    fr_ref number(7) not null references phoneInfo_basic(idx)
);
drop table phoneInfo_univ;

create table phoneInfo_com (
    idx number(6) primary key,
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref  number(6) not null references phoneInfo_basic(idx)
    

);
select * from phoneinfo_basic;
--insert
insert into phoneInfo_basic values (111111,'손흥민','010-0000-0000','123@123.com','서울','2023.01.01');
insert into phoneInfo_basic values (222222,'박지성','010-1111-0000','222@123.com','경기','2022.01.01');
insert into phoneInfo_basic values (333333,'이강인','010-2222-0000','333@123.com','인천','2021.01.01');
insert into phoneInfo_basic values (444444,'김민재','010-3333-0000','444@123.com','부산','2020.01.01');
insert into phoneinfo_basic (fr_name,idx,fr_phonenumber,fr_email,fr_address,fr_regdate) values ('황희찬', 555555, '010-4444-0000','555@123.com','서울','2019.01.01');
insert into phoneinfo_basic (fr_name,idx,fr_phonenumber,fr_address,fr_regdate) values ('차범근', 666666, '010-4444-0000','서울','2019.01.01');
--update
update phoneinfo_basic
set  idx=333333
where idx = 222222
;
--delete,select
delete from phoneinfo_basic where idx=(select idx from phoneinfo_basic where idx=111111);
--select
select idx from phoneinfo_basic where idx=111111;

desc phoneinfo_univ;

insert into phoneinfo_univ values (201501,'경영학과',1,333333);
insert into phoneinfo_univ values (201502,'전자공학과',2,111111);
insert into phoneinfo_univ values (201503,'경제학과',4,222222);
insert into phoneinfo_univ values (201504,'기계공학과',3,444444);

select * from phoneinfo_univ;
delete from phoneinfo_univ where idx=111111;

insert into phoneinfo_com values (1001,'A',111111);
insert into phoneinfo_com values (1002,'B',222222);
insert into phoneinfo_com values (1003,'C',333333);
insert into phoneinfo_com values (1004,'D',444444);
select * from phoneinfo_com;


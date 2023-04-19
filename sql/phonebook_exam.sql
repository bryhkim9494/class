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

-- sequence 생성
create sequence seq_pbasic_idx;

create table phoneInfo_univ (
    idx number(6) primary key,
    fr_u_major varchar2(20)  default 'N' not null,
    fr_u_year number(1)  default 1 check (5>=fr_u_year AND fr_u_year>=1) not null , 
    fr_ref number(7) not null references phoneInfo_basic(idx)
);
-- sequence 생성
create sequence seq_puiv_idx;

drop table phoneInfo_univ;
drop table phoneInfo_basic;
drop table phoneInfo_com;
create table phoneInfo_com (
    idx number(6) primary key,
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref  number(6) not null references phoneInfo_basic(idx)
    

);
-- sequence 생성
create sequence seq_pcom_idx;

select * from phoneinfo_basic;
--insert
insert into phoneInfo_basic values (seq_pbasic_idx.nextval,'손흥민','010-0000-0000','123@123.com','서울','2023.01.01');
insert into phoneInfo_basic values (seq_pbasic_idx.nextval,'박지성','010-1111-0000','222@123.com','경기','2022.01.01');
insert into phoneInfo_basic values (seq_pbasic_idx.nextval,'이강인','010-2222-0000','333@123.com','인천','2021.01.01');
insert into phoneInfo_basic values (seq_pbasic_idx.nextval,'김민재','010-3333-0000','444@123.com','부산','2020.01.01');
insert into phoneinfo_basic (fr_name,idx,fr_phonenumber,fr_email,fr_address,fr_regdate) values ('황희찬', seq_pbasic_idx.nextval, '010-4444-0000','555@123.com','서울',default);
insert into phoneinfo_basic (fr_name,idx,fr_phonenumber,fr_address,fr_regdate) values ('차범근', seq_pbasic_idx.nextval, '010-4444-0000','서울','2019.01.01');
--update
update phoneinfo_basic
set  idx=333333
where idx = 222222
;
--delete,select
delete from phoneinfo_basic where idx=(select idx from phoneinfo_basic where idx=111111);
delete from phoneinfo_basic where idx=555555;
--select
select idx from phoneinfo_basic where idx=111111;

desc phoneinfo_univ;

insert into phoneinfo_univ values (seq_puiv_idx.nextval,'경영학과',1,seq_pbasic_idx.currval);
insert into phoneinfo_univ values (seq_puiv_idx.nextval,'전자공학과',2,seq_pbasic_idx.currval);
insert into phoneinfo_univ values (seq_puiv_idx.nextval,'경제학과',4,seq_pbasic_idx.currval);
insert into phoneinfo_univ values (seq_puiv_idx.nextval,'기계공학과',3,seq_pbasic_idx.currval);

select * from phoneinfo_univ;
delete from phoneinfo_univ where idx=111111;

insert into phoneinfo_com values (seq_puiv_idx.nextval,'A',seq_pbasic_idx.currval);
insert into phoneinfo_com values (seq_puiv_idx.nextval,'B',seq_pbasic_idx.currval);
insert into phoneinfo_com values (seq_puiv_idx.nextval,'C',seq_pbasic_idx.currval);
insert into phoneinfo_com values (seq_puiv_idx.nextval,'D',seq_pbasic_idx.currval);
select * from phoneinfo_com;

select *
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref;


-- 2023.04.17
-- ddl


-- 형태) create table 테이블이름 ( -- 스키마: 컬럼들의 집합 /// 아래에 컬럼이름  타입 [제약조건],컬럼이름  타입 [제약조건],컬럼이름  타입 [제약조건]........ 이런것들의 집합이 스키마이다.
    --  컬럼이름  타입 [제약조건],
    --  컬럼이름  타입 [제약조건],
    --  컬럼이름  타입 [제약조건],
    --  컬럼이름  타입 [제약조건],
    --  컬럼이름  타입 [제약조건]........

-- );

create table ddl_test ( -- create는 DDL에서 사용하는 명령어
-- 컬럼들을 정의
    no number(3),
    name varchar(10),
    birth date default sysdate
);
desc ddl_test; -- < DESC> : 특정 테이블에 어떤 칼럼이 있는지 구조가 무엇인지 조회하는 명령어

-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 EMP01 테이블을 생성해 봅시다.
create table emp01 (
    empno number(4),
    ename varchar2(10),
    sal number(7,2)
);
desc emp01;
insert into emp01 (empno, ename, sal) values (1111,'SON',1000);
select * from emp01;

-- 서브 쿼리를 이용해서 기존 테이블의 구조로 테이블을 생성, 데이터도 저장 , 제약조건은 복사되지 않는다!!
create table emp02
as
select * from emp;
desc emp02;
desc emp;

select * from emp02;

-- 원하는 컬럼만 또는 원하는 로우만 선택해서 테이블을 생성
create table emp03
as
select empno,ename,job,hiredate from emp;
desc emp03;
select * from emp03;

-- 30번 부서의 정보만 가지는 새로운 테이블 생성
select empno ,ename , job from emp where deptno=30 ; -- 서브쿼리문
 -- where: 원하는 행 선택
create table emp04
as
select empno ,ename , job from emp where deptno=30;

select * from emp04;

-- 데이터 필요없이 스키마만 복사
select * from emp where 1=0;
create table emp05
as
select * from emp where 1=0
;
select * from emp05;
desc emp05;
-- 테이블의 변경 : 테이블은 저장구조(=스키마의 구조 = 컬럼들의 집합)가 변경
-- 컬럼 변경( = 테이블에 컬럼을 추가하는것 or 이미 테이블에 있는 컬럼을 삭제 하는것도 변경 or 안에있는 컬럼의 내용이나 이름을 수정하는것 ) 

-- 테이블의 변경
-- alter table [add, modify, drop column] ()
-- emp01 테이블에 job컬럼을 추가해보자.
desc emp01;
alter table emp01 add(job varchar2(9));


-- 직급(JOB) 칼럼을 최대 30글자까지 저장할 수 있게 변경해 보도록 하자.
desc emp01;
alter table emp01
modify(job varchar2(20) not null); -- not null = null값을 허용하지 않겠다 라는뜻

alter table emp01
modify(job varchar2(50)); 

select * from emp01;
delete from emp01 where empno=1111;
commit;

-- emp01 테이블에서 job 컬럼을 삭제해보자!!
alter table emp01
drop column job;
desc emp01;

-- 테이블 객체의 삭제
-- drop table 테이블이름=>스키마삭제뿐만아니라 저장데이터도 삭제함 (= 모든데이터 삭제)
-- DDL: 자동 commit ,DML작업중 DDL작업은 신중하게!!!
-- emp01 테이블을 삭제해보자
drop table emp01;
desc emp01;
select * from emp01;

-- 테이블의 모든 행을 삭제 : truncate table 테이블이름
select *from emp02;
truncate table emp02;

select * from emp03;
delete from emp03; -- delete(DML) : 행단위삭제, 물리적인 반영이 바로 안됨 -> commit 을 해야 완전히 적용됨 -> 실수했으면 rollback으로 돌아갈수있음 but drop, truncate는 자동commit되서 돌이킬수없음
rollback;
-- 테이블이름 변경
-- rename 이전이름 to 새이름
desc ddl_test;
-- ddl_test => test
rename ddl_test to test;
desc test;
----------------------------------------------------------------------------
-- 제약 조건의 필요성 
insert into dept values(10,'test','test');

-- not null 제약조건: 설정한 컬럼의 null값 입력을 금지하는 제약조건
-- 컬럼 수준에서만 정의가 가능
drop table emp02;
-- 사원테이블 생성: 사원번호, 사원이름, 직급 ,부서명
-- 사원번호와 사원이름에 not null 제약조건을 설정하자!!
create table emp02(
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);
desc emp02;
select * from emp02;
insert into emp02 values (1111,null,'MANAGER',30);
insert into emp02 (job,deptno) values ('MANAGER',10);
-- emp03 생성 : 사원번호, 사원이름, 직급, 부서번호
-- empno : unique
-- ename; not null
drop table emp03;
create table emp03(
    empno number(4) unique,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);
desc emp03;
-- unique: 컬럼내부에 중복되는 데이터가 있으면 입력 실패, 수정 실패
insert into emp03 values(1111,'KING','MANAGER',10); --(괄호순서대로 empno,ename,job,depton순이다)
insert into emp03 values(1112,'SON','MANAGER',20);

select * from emp03;


-- not null과 unique 함께 사용
drop table emp01;
create table emp01(
    empno number(4) not null unique, -- not null과 unique 함께 사용
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);
insert into emp01 values(1112,null,'MANAGER',40);
insert into emp01 values(1111,'KING','MANAGER',40);
-- 기본키 제약조건
-- 컬럼 옆에 primary key 키워드를 적으면됨.
drop table emp01;
create table emp01(
    empno number(4) primary key , -- not null과 unique 함께 사용
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);

desc emp01;

insert into emp01 values(1111,'KING','MANAGER',40);




drop table emp01;
create table emp01(
    empno number(4) constraint PK_EMP01_EMPNO primary key , -- not null과 unique 함께 사용
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9) constraint UK_EMP01_JOB unique , 
    deptno number(2)
);

desc emp01;
insert into emp01 values(1112,'KING',null,40);

-- 외래키 제약조건


drop table emp01;
create table emp01(
    empno number(4) constraint PK_EMP01_EMPNO primary key, -- not null과 unique 함께 사용
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9) constraint UK_EMP01_JOB unique,
    deptno number(2) constraint FK_EMP01_DEPTNO references dept(deptno) -- 외래키
);


insert into emp01 values(1112,'KING',null,90);

-- check : 범위, 값을 확인후 
drop table emp01;
create table emp01(
    empno number(4) constraint PK_EMP01_EMPNO primary key, -- not null과 unique 함께 사용
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9) constraint UK_EMP01_JOB unique,
    sal number(7,2) constraint CK_EMP01_SAL check (sal between 800 and 5000),
    gender char(1) constraint CK_EMP01_GENDER check (gender in ('M','F')),
    deptno number(2) constraint FK_EMP01_DEPTNO references dept(deptno) -- 외래키
    
);


desc emp01;
insert into emp01 values(1112,'KING','MANAGER',1500,'F',40);

-- default : 컬럼에 입력값이 없을 때 기본값을 설정해서 데이터 입력
select sysdate from dual;

drop table emp01;
create table emp01(
    empno number(4) constraint PK_EMP01_EMPNO primary key, -- not null과 unique 함께 사용
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9) constraint UK_EMP01_JOB unique,
    sal number(7,2) constraint CK_EMP01_SAL check (sal between 800 and 5000),
    gender char(1) constraint CK_EMP01_GENDER check (gender in ('M','F')),
    deptno number(2) constraint FK_EMP01_DEPTNO references dept(deptno), -- 외래키
    hiredate date default sysdate
);

desc emp01;
insert into emp01 values(1112,'KING','MANAGER',1500,'F',40,sysdate);
insert into emp01 (empno, ename,job,sal,gender,deptno)
            values(1115,'SON','FREE3',3000,'M',40)
;

select * from emp01;


-- 테이블레벨에서의 제약조건 
drop table emp01;
create table emp01(
    empno number(4), -- not null과 unique 함께 사용
    ename varchar2(10) constraint NN_EMP01_ENAME not null,
    job varchar2(9) ,
    sal number(7,2) constraint CK_EMP01_SAL check (sal between 800 and 5000),
    gender char(1) constraint CK_EMP01_GENDER check (gender in ('M','F')),
    deptno number(2), -- 외래키
    hiredate date default sysdate,
    -- 테이블레벨제약
    constraint PK_EMP01_EMPNO  PRIMARY KEY(EMPNO),
    constraint UK_EMP01_JOB unique (job),
    constraint FK_EMP01_DEPTNO FOREIGN KEY (deptno) references dept(deptno)
);

desc emp01;
insert into emp01 values(1112,'KING','MANAGER',1500,'F',40,sysdate);
insert into emp01 (empno, ename,job,sal,gender,deptno)
            values(1115,'SON','FREE3',3000,'M',40)
;

select * from emp01;




















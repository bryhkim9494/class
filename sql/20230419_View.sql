-- 2023.04.19
-- VIEW : 가상 테이블
-- VIEW 객체는 SQL을 가진다! -> VIEW는 SQL실행결과를 가상의 테이블로 사용하는것
SELECT empno,ename,deptno
from emp
where deptno=30
;
-- view 객체 생성방법
-- 형태) create or replace view 뷰이름 as 서브쿼리
create or replace view emp_view30
as SELECT empno,ename,deptno -- as뒤에 서브쿼리처럼 위에거 대입
from emp
where deptno=30
;

select *from emp_view30;
-- 주문정보 : orders,book,customer

select  o.orderid, c.name, b.bookname,b.price,o.saleprice, o.orderdate,c.phone from orders o , book b, customer c
where o.bookid = b.bookid and o.custid=c.custid;
-- view 생성
create or replace view order_info
as select  o.orderid, c.name, b.bookname,b.price,o.saleprice, o.orderdate,c.phone from orders o , book b, customer c
where o.bookid = b.bookid and o.custid=c.custid
;
select name,bookname from order_info where name= '박지성';
select view_name, text from user_views;

--view 삭제
drop view emp_view30;




select rownum ,ename,hiredate from emp order by hiredate; --rownum은 입력된(insert) 순서대로 나옴
create or replace view emp_hiredate_view
as
select ename,hiredate from emp order by hiredate
;
select rownum , ename,hiredate from emp_hiredate_view where rownum <= 3 ;--  뷰

-- 인라인뷰, 뷰 둘다 rownum이 재정렬됨

select rownum,ename,hiredate from (select rownum ,ename,hiredate from emp order by hiredate)-- 인라인뷰
where rownum <=3
order by hiredate; -- 위에랑 다르게 rownum을 재정렬 하게됨














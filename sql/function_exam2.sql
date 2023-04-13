-- function_exam2

select * from orders;
select * from customer;
select * from book;

select sum(saleprice)
from orders
where custid=1
;

--(4)
select count(*)
from orders
where custid=1;

--2.
-- (1)
select count(*) from book;
-- (2)
select count(distinct publisher) from book order by publisher;














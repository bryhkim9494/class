--DEPT MANAGER

-- 1.LIST
select * from dept;

-- 2.search
select * from dept where deptno=10;
-- select * from dept where deptno=?;

select * from dept where dname='ACCOUNTING';
-- select * from dept where dname=?;

-- 3. insert
insert into dept values (50,'TEST','Seoul');--DML을 하면 rollback이나 commit을 반드시해줘야 다른 응용프로그램에서 사용가능
-- insert into dept values (?,?,?) preparedstatement이용할때 ?파라미터사용
rollback;

-- 4.수정: update
update dept set dname = 'AAA',loc = 'BBB' where deptno = 60;
-- update dept set dname = ?,loc = ? where deptno = ?;

-- 5.삭제: delete
delete from dept where deptno = 60;
-- delete from dept where deptno = ?;
rollback;
























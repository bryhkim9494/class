-- 2023.04.13
-- join

-- CROSS JOIN
-- 스키마를 붙이고 결과 행은 모든 경우의 수 -> n* m
-- emp, dept => 14 * 4 -> 56

select *
from emp, dept -- emp, dept => 14 * 4 -> 56
;

select *
from emp , dept
where emp.deptno=dept.deptno
;

select e.deptno ,empno ,dname-- 중복되는 컬럼이없으면 앞에 별칭없이 써도됨
from emp e,dept d
where e.deptno=d.deptno
;

--이름이 SCOTT인 사람의 부서명을 출력해봅시다.
--join을 모른다면
select deptno from emp where ename='SCOTT';
--20
select dname from dept where deptno=20;
--join으로 해결
select ename,dname from emp e, dept d
where e.deptno = d.deptno --여기까지 14개행출력
and  e.ename = 'SCOTT'  --scott찾기
;

-- 사원별 급여등급 표현
select * from salgrade;

select e.ename,s.grade, s.losal,e.sal,s.hisal
from emp e , salgrade s -- 총 70개가나옴 emp 14개 salgrade 5개
where e.sal between s.losal and s.hisal
;

-- self join : 자기 자신의 테이블을 조인하는 경우
-- 각사원의 이름과 각 사원의 매니저 이름을 출력

select e.ename, m.ename
from emp e , emp m -- self join 개체만 가지고 구분 불가능하므로 별칭을 꼭 줘야함
where e.mgr = m.empno
;
-- outer join : 조건에 만족하지 않는 행도 출력을 하는 join
select e.ename,nvl(m.ename,'없음')
from emp e , emp m -- self join 개체만 가지고 구분 불가능하므로 별칭을 꼭 줘야함
where e.mgr = m.empno(+) -- (+)는 데이터가없어도 출력하겠다란뜻임.
;

select *
from emp, dept
;

select *
from emp cross join dept --cross join
;

select *
from emp ,dept -- equi join
where emp.deptno = dept.deptno
;

select *
from emp inner join dept --inner 생략가능
on emp.deptno = dept.deptno
;
select *
from emp join dept
on emp.deptno = dept.deptno
;
select * 
from emp natural join dept; -- 같은 컬럼의 이름이 이

select *
from emp join dept
using(deptno) -- using을 쓰는 join과 natural join은 같음
;

select deptno
from emp natural join dept
;

-- outer join : 조건에 만족하지 않는 행도 출력을 하는 join
select e.ename,nvl(m.ename,'없음')
from emp e , emp m -- self join 개체만 가지고 구분 불가능하므로 별칭을 꼭 줘야함
where e.mgr = m.empno(+) -- (+)는 데이터가없어도 출력하겠다란뜻임.
;

select *
from emp e join emp m
on e.mgr = m.empno
;
select *
from emp e left outer join emp m
on e.mgr = m. empno
;


-- 도서 판매 정보 출력
select * from orders;
select o.orderid, c.name, b.bookname,o.saleprice,o.orderdate
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
;















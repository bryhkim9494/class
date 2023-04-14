-- 32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
--scott -> emp 사용, 부서이름 -> dept사용 => 두개를 join함

select e.deptno,d.dname
from emp e,dept d
where  e.deptno=d.deptno and ename='SCOTT'
;

-- 풀이
select e.ename,e.deptno,d.dname -- e.deptno와 d.deptno 같은값이므로 아무거나 써도  상관 X , ename은 겹치는 컬럼이없어서 별칭안써도되지만 가독성을위해 별칭을 쓰는게좋음
from emp e, dept d
where e.deptno = d.deptno -- join조건
and e.ename='SCOTT'
;
-- 33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.

select e.ename,d.dname,d.loc
from emp e inner join dept d
on e.deptno = d.deptno
;

-- 풀이
select e.ename,d.dname,d.loc
from emp e inner join dept d
on e.deptno = d.deptno
;
select e.ename,d.dname,d.loc
from emp e inner join dept d
using(deptno)
;
select e.ename,d.dname,d.loc
from emp e natural join dept d
;

-- 36. 조인과 
-- WildCARD를 사용하여 이름에 ‘A’가 포함된 
-- 모든 사원의 
-- 이름과 부서명을 출력하시오.

select e.ename, d.dname
from emp e , dept d
where e.deptno=d.deptno
and e.ename like '%A%'
;

-- 풀이
select e.ename, d.dname
from emp e , dept d
where e.deptno=d.deptno -- 조인을 하는조건
and e.ename like '%A%' -- 조인을 한 다음 필요한 조건
;


-- 37. JOIN을 이용하여 
-- NEW YORK에 근무하는 => row를 선택하는 추가적인 조건
-- 모든 사원의 이름, 업무 => emp
-- 부서번호 및 부서명 => dept
-- 을 출력하시오.
select e.ename,e.job,d.deptno,d.dname
from emp e,dept d
where e.deptno=d.deptno -- join조건
and d.loc = 'NEW YORK'
;

-- 38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select e.ename, e.empno,m.ename -- 뒤에 테이블에 관리자이름이 나와서 m.ename을 써야 관리자가출력됨
from emp e , emp m
where e.mgr = m.empno
;

-- 풀이
select *
from emp e , emp m 
where e.mgr=m.empno
;

--39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.

select e.ename, e.empno,m.ename 
from emp e , emp m
where e.mgr = m.empno(+)
order by e.empno desc
;

-- 풀이
select e.ename, m.ename ,nvl(m.ename,'관리자 없음')
from emp e , emp m 
where e.mgr=m.empno(+)
;

-- outer조인
select e.ename,e.empno,m.ename
from emp e left outer join emp m
on e.mgr =m.empno
;

-- 40. SELF JOIN을 사용하여 
-- 지정한 사원의 이름, 부서번호, 
-- 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
-- 서브쿼리쓰면 간단하게 가능
select e.ename,m.deptno

from emp e , emp m

;

-- 풀이
select e2.ename,e2.deptno
from emp e1, emp e2
where e1.deptno = e2.deptno
and e1.ename='SCOTT' and e2.ename!='SCOTT'
--order by e1.ename
;



-- 41. SELF JOIN을 사용하여 
-- WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select e.hiredate, m.ename,m.hiredate
from emp e, emp m
where e.ename='WARD' 
and m.hiredate > e.hiredate -- where 조건절에서  e.ename='WARD' 를 치면 왼쪽 테이블이 다 WARD에 대한 내용으로 출력됨 -> 그리고 and를 걸어서 e.hiredate는 전부다 81/02/22니까 m.hiredate가 더 크다고 조건을 걸면된다.
;

-- 풀이
select *
from emp e, emp w
where w.ename='WARD'
--and e.hiredate>w.hiredate
and e.sal > w.sal
;






-- self조인할때 오른쪽이 기준이 되는 정보를 정한다 
-- 42번 문제에서는 관리자가 기준이므로 오른쪽에 둔다 /// 좀전에 41번문제는 'WARD'가 기준이므로 'WARD'를 오른쪽에 두고 생각함

-- ​42. SELF JOIN 을 사용하여 
-- 관리자보다 먼저 입사한 모든 
-- 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.

select e.ename,e.hiredate,m.ename,m.hiredate

from emp e, emp m
where e.mgr = m.empno and e.hiredate < m.hiredate

;
-- select * from emp;


select *--e.ename,e.hiredate,m.ename,m.hiredate
from emp e , emp m
where e.mgr = m.empno
and e.hiredate < m.hiredate
;

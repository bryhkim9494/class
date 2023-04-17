-- subquery exam

-- 43. 사원 번호가 7788인 사원과 담당 업무가 같은 (where절 조건)=> 7788인 사원의 담당업무
-- 사원을 표시(사원 이름과 담당업무)하시오.
SELECT
    job
FROM
    emp
WHERE
    empno = 7788; --서브쿼리문
-- 서브쿼리
SELECT
    ename,
    job
FROM
    emp
WHERE
    job = (
        SELECT
            job
        FROM
            emp
        WHERE
            empno = 7788
    );

--조인
SELECT
    e1.ename,
    e1.job
FROM
    emp e1,
    emp e2
WHERE
        e2.empno = 7788
    AND e1.job = e2.job;

-- 44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 
-- 사원이름과 감당 업무
SELECT
    sal
FROM
    emp
WHERE
    empno = 7499; -- 서브쿼리문
-- 서브쿼리
SELECT
    ename,
    job
FROM
    emp
WHERE
    sal > (
        SELECT
            sal
        FROM
            emp
        WHERE
            empno = 7499
    );

-- 45.최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오.(그룹함수 사용)
SELECT
    MIN(sal)
FROM
    emp; -- 서브쿼리문
-- 서브쿼리
SELECT
    ename,
    job,
    sal
FROM
    emp
WHERE
    sal = (
        SELECT
            MIN(sal)
        FROM
            emp
    );

-- 46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
-- 1. 직급별 평균 먼저구하기
SELECT
    job,
    AVG(sal)
FROM
    emp
GROUP BY
    job;
-- 2. 직급별 최저 평균급여
SELECT
    MIN(AVG(sal))
FROM
    emp
GROUP BY
    job;
-- 3.직급의 평균구하기
SELECT
    job,
    AVG(sal)
FROM
    emp
GROUP BY
    job
HAVING
    AVG(sal) = (
        SELECT
            MIN(AVG(sal))
        FROM
            emp
        GROUP BY
            job
    );

-- 47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
SELECT
    deptno,
    MIN(sal)
FROM
    emp
GROUP BY
    deptno;--여기서 나온테이블은 인라인뷰
    
SELECT
    e.ename, e.sal,m.deptno
FROM
    emp e,
    ( -- 인라인뷰 서브쿼리
        SELECT
            deptno,
            MIN(sal) AS minsal
        FROM
            emp
        GROUP BY
            deptno
    )   m
WHERE
        e.deptno = m.deptno
    AND e.sal = m.minsal;

-- 48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 => ANALYST 직급의 최소 급여보다 작아야한다!
-- 업무가 ANALYST가 아닌 사원들을
-- 표시(사원번호, 이름, 담당 업무, 급여)하시오.
select *
from emp
where job !='ANALYST'
and sal <all (select distinct sal from emp where job = 'ANALYST')
;

select distinct sal
from emp
where job = 'ANALYST'
;

-- 49. 부하직원이 없는 사원의 이름을 표시하시오.
-- 나의 사원번호가 다른 사원의 mgr에 있다면 => 나는 관리자이고 부하직원이 있다.
-- 나의 사원번호가 다른 사원의 mgr에 없다면 => 부하직원이 없다!

select distinct mgr from emp where mgr is not null; --서브쿼리문

select ename
from emp
where empno not in (select distinct mgr from emp where mgr is not null)--서브쿼리
;

-- 50. 부하직원이 있는 사원의 이름을 표시하시오.
select ename
from emp
where empno in (select distinct mgr from emp where mgr is not null)--서브쿼리
;

-- 51. BLAKE와 동일한 부서에 속한 
-- 사원의 이름과 입사일을 표시하는 질의를 작성하시오.(단 BLAKE는 제외)
select deptno from emp where ename= 'BLAKE'; -- 서브쿼리문
select ename,hiredate 
from emp 
where deptno = (select deptno from emp where ename= 'BLAKE')
and ename != 'BLAKE'
;

-- 52. 급여가 평균 급여보다 많은
-- 사원들의 사원 번호와 이름을 표시하되 
-- 결과를 급여에 대해서 오름차순으로 정렬하시오.
select avg(sal) from emp; -- 서브쿼리문
select empno,ename ,sal
from emp
where sal > (select avg(sal) from emp)
order by sal
;
-- 53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 
-- 사원의 사원 번호와 이름을 표시하시오.
select distinct deptno from emp where ename like '%K%'; -- 서브쿼리문
select empno,ename
from emp
where deptno in (select distinct deptno from emp where ename like '%K%')
;

-- 54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
-- 부서위치가 DALLAS인 부서번호와 같은 사원
-- 부서의 위치가 DALLAS인 부서번호
select deptno from dept where loc = 'DALLAS';-- 서브쿼리문
select ename,deptno,job
from emp
where deptno = (select deptno from dept where loc = 'DALLAS')
;

-- 55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
-- emp => mgr(상사) => 사원의 mgr컬럼에 KING사원의 사원번호를 가지고 있으면 => KING이 상사이다!
-- 결국 문제는 mgr에 KING 사원번호를 가지고 있는 사원을 찾는것
-- KING 사원의 사원번호
select empno from emp where ename='KING';-- 서브쿼리문
select ename,sal
from emp
where mgr = (select empno from emp where ename='KING')
;
-- 56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
--  RESEARCH 부서의 부서번호
select deptno from dept where dname = 'RESEARCH';-- 서브쿼리문
select deptno,ename,job
from emp
where deptno = (select deptno from dept where dname = 'RESEARCH')
;
-- <다른테이블에 있으면 조인먼저 생각해보고 서브쿼리생각해봄>

-- 57. 평균 월급보다 많은 급여를 받고 

-- 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 

-- 사원 번호, 이름, 급여를 표시하시오.

-- 평균월급:
select avg(sal) from emp ;-- 서브쿼리문
-- 이름이 M이 포함된 사원의 부서번호:
select distinct deptno from emp where ename like '%M%';-- 서브쿼리문

select empno, ename, sal
from emp
where sal>(select avg(sal) from emp)
and deptno in (select distinct deptno from emp where ename like '%M%')
;
-- 58. 업무별 평균급여가 가장 적은 업무를 찾으시오.
select avg(sal) as avgsal from emp;

select job
from emp
--where sal
group by job;

-- 59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
select deptno from emp where job= 'MANAGER';-- 서브쿼리문
select *
from emp 
where deptno in (select distinct deptno from emp where job= 'MANAGER')
;








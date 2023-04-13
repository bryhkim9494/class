--16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
select hiredate,
substr(hiredate,1,5),substr(hiredate,1,2),substr(hiredate,4,2)
from emp
where substr(hiredate,1,2)=81
;

--17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
select *from emp
where substr(hiredate,4,2) ='04' --04라고 적어도 문자열로 자동형변환됨?
;

-- 18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
select *
from emp
where mod(empno,2)=0
;

-- 19. 입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 요일은 약어 (DY)로 지정하여 출력하시오.
SELECT TO_CHAR (SYSDATE, 'YY-MM-DY')


FROM emp;

select ename,
to_char(hiredate, 'YY') as "입사 년도",
to_char(hiredate, 'MM') as "입사 월",
to_char(hiredate, 'DY') as "입사 요일",
to_char(hiredate, 'YY.MM.DY') as "입사 년/월/요일"
from emp
;

-- 20. 올해 몇 칠이 지났는지 출력하시오. 
-- 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고 
-- TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
SELECT TRUNC(SYSDATE-TO_DATE('2023/01/01', 'YYYY/MM/DD'))
FROM DUAL;

-- 풀이
select sysdate, to_date('2023-01-01', 'YYYY-MM-DD'),
sysdate-to_date('2023-01-01', 'YYYY-MM-DD'),
trunc(sysdate-to_date('2023-01-01', 'YYYY-MM-DD'))
from dual;


--21. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
SELECT NVL(MGR,0) as "상관 사번"
FROM EMP;

-- 풀이
select mgr,nvl(mgr,0)
from emp;

-- 22. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 
-- 직급이 ‘ANALIST”인 사원은 200, ‘SALESMAN’인 사원은 180, ‘MANAGER’인 사원은 150, ‘CLERK”인 사원은 100을 인상하시오.
SELECT 

      nvl(decode(job, 'ANALYST', sal + 200, 'SALESMAN', sal+180,
           'MANAGER', sal+150, 'CLERK', sal+100),sal) as sal

FROM
    emp
ORDER BY


    sal;
-- 풀이

select ename, job, sal,
decode(job, 'ANALYST', sal+200,
'SALESMAN',sal+180,'MANAGER',sal+150,'CLERK', sal+100 )as up_sal
from emp
;

    
-- 23. 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오. 평균에 대해서는 정수로 반올림하시오.
select max(sal),min(sal),sum(sal),round(avg(sal),-1)
from emp;

--24. 각 담당 업무 유형별로 
-- 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오. 
-- 평균에 대해서는 정수로 반올림 하시오.
select job, max(sal),min(sal),round(avg(sal),-1) 
from emp 
group by job;

-- 풀이
select job, max(sal),min(sal),sum(sal),round(avg(sal))
from emp
group by job
;
--25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
select job, count(*)
from emp
group by job;


--풀이
select count(*) from emp where job= 'MANAGER';

select job,count(*) from emp group by job;


-- 26. 관리자 수를 출력하시오.
select count(*) from emp where job='MANAGER';

-- 풀이
select empno, mgr
from emp
order by mgr;

select count(distinct mgr)
from emp;



-- 27. 급여 최고액, 급여 최저액의 차액을 출력하시오.
select max(sal),min(sal), max(sal)-min(sal) from emp;

-- 28.
select job, min(sal)
from
emp
where mgr is not null
group by job
having min(sal) >= 2000
order by min(sal) desc
;
--29
select * from dept;
select deptno, count(*), round(avg(sal),2)
from emp 
group by deptno order by deptno;

-- 30
select deptno,decode(deptno,10, 'ACCOUNTING',
20, 'RESEARCH',30,'SALES',40,'OPERATIONS')as dname ,
decode(deptno, 10,'NEW YORK',
20,'DALLAS',30,'CHICAGO',40,'BOSTON')as loc,
count(*), round(avg(sal))
from emp
group by deptno
order by deptno;


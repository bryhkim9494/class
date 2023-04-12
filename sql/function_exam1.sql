--16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
select
substr(hiredate,1,5)
from emp
;

--17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
select *from emp
where substr(hiredate,4,2) =04
;
-- 18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
select *
from emp
where mod(empno,2)=0
;
-- 19. 입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 요일은 약어 (DY)로 지정하여 출력하시오.
SELECT TO_CHAR(SYSDATE, 'YY-MM-DY')
FROM emp;
-- 20. 올해 몇 칠이 지났는지 출력하시오. 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고 TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
SELECT TRUNC(SYSDATE-TO_DATE('2023/01/01', 'YYYY/MM/DD'))
FROM DUAL;
--21. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
SELECT NVL(MGR,0) as "상관 사번"
FROM EMP;

-- 22. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 직급이 ‘ANALIST”인 사원은 200, ‘SALESMAN’인 사원은 180, ‘MANAGER’인 사원은 150, ‘CLERK”인 사원은 100을 인상하시오.
SELECT 

      nvl(decode(job, 'ANALYST', sal + 200, 'SALESMAN', sal+180,
           'MANAGER', sal+150, 'CLERK', sal+100),sal) as sal

FROM
    emp
ORDER BY
    sal;
    
-- 23. 모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오. 평균에 대해서는 정수로 반올림하시오.
select max(sal),min(sal),sum(sal),round(avg(sal),-1)
from emp;

--24. 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오. 평균에 대해서는 정수로 반올림 하시오.





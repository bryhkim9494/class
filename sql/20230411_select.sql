-- 2023.04.11
-- select

-- 로그인한 사용자가 소유하고있는 테이블의 정보를 알 수 있다.
select * from tab;

-- 테이블 정보 확인

desc emp;

describe dept;

-- 데이터 추출하는 질의어 : select
-- select 컬럼이름, 컬럼이름, 컬럼이름... from 테이블이름 (view이름도 사용가능);
-- ex) select * from 테이블이름; (*는 전체컬럼을 가져옴)
--  키워드랑 객체 둘다 대소문자 안가린다.
select * from dept;
select * from DEPT;

select * 
from dept


;

select dname--, deptno ,loc
from dept;

-- select 구문의 프리젠테이션영역에 테이블이 가지는 컬럼 뿐만 아니라 연산(or 함수)의 결과를 새로운 컬럼으로 출력 할 수 있다.
select sal ,sal +100, sal -100 ,sal * 10, sal / 2 from emp; -- 여기서 select는 sal만 추출한거고 나머지 sal +100, sal -100 ,sal * 10, sal / 2은 새로 만든것이다.
select sal + 100 from emp;
select sal - 100 from emp;
select sal * 10 from emp;
select sal / 2 from emp;


-- 사원테이블에서 사원의 이름과 급여, 연봉계산 결과를 출력 
-- 연봉의 계산은 월급여*12 + 상여금500

select ename,sal, sal * 12 + 500

from emp;

-- 상여금 계산 => sal * 12 +comm

select sal,comm,nvl(comm,0), sal*12+nvl(comm,0) from emp;

-- 컬럼의 이름에 별칭을 부여
-- 컬럼 뒤에 as 키워드를 쓰고 별칭을 작성
select sal,comm,nvl(comm,0) as comm1 , sal*12+nvl(comm,0) as "year Sal" from emp;

-- 문자열의 연산 문자열을 붙여준다 => 문자열 || 문자열
select ename || ' is a ' || job
from emp;


-- select [distinct] from....
-- => 중복 값을 제거하고 값을 하나만 출력

select deptno from emp;
select distinct deptno from emp;
select job from emp;
select distinct job from emp;



-- 원하는 행 검색
-- where 절을 사용
-- select ... from ... where 조건식;
-- 급여가 3000 이상인 사원의 정보 리스트 
select * from emp where sal>=3000; 


-- = : 컬럼에 데이터를 같다 비교
-- 10번 부서에 소속된 사원들의 정보를 출력
select ename,job --*
from emp where deptno = 10;

--다음은 이름이 FORD인 사원의 사원번호(EMPNO)과 사원이름(ENAME)과 급여(SAL)을 출력
-- 문자열 비교 => 작은 따옴표 사용
select empno,ename,sal

from emp
where ename = 'FORD'

;



select*

from emp
where ename = 'FORD'

;
-- 날짜를 비교할때도 작은따옴표 사용

select *
from emp
where hiredate = '81/12/03';


select *
from emp
where hiredate < '81/12/03';

-- 논리연산자 : AND, OR , NOT
-- 10번 부서의 매니저가 누구인지 찾아보자

select * from emp where deptno = 10 and job = 'MANAGER';
select * from emp where deptno = 10 or job = 'MANAGER';
select * from emp where deptno = 10 or job <> 'MANAGER'; -- !=랑 같음
select * from emp where deptno = 20 or deptno = 30 or deptno=40;
select * from emp where not deptno = 10;
select * from emp where not (deptno = 10);
select * from emp where deptno<> 10;
select * from emp where deptno != 10;
select * from dept;
select * from emp;


-- 2000에서 3000 사이의 급여를 받는 사원
select * from emp where sal >=2000 and sal <=3000;
-- 범위 연산자의 연산은 날짜도 가능 : 날짜는 작은 따옴표로 정의
-- 1987년에 입사한 사원 -> '87/01/01' ~ '87/12/31'
select * from emp where hiredate between '81/01/01' and '81/12/31';
select * from emp where hiredate not between '81/01/01' and '81/12/31';

-- 범위연산자 between A and B => A이상 B이하
select * from emp where sal between 2000 and 3000;

-- 10번, 20번, 30번 부서에 소속된 사원의 정보를 출력
select * from emp where deptno=10 or deptno=20 or deptno=30;
-- 컬럼 in(값, 값, ....) : or의 연산을 간단하게 처리
-- 컬럼 = 값1 or 컬럼 = 값2 or 컬럼 = 값3 ....
select * from emp where deptno in(10,20,30);
select * from emp where deptno not in(10,20);


-- 패턴 검색: 문자열의 패턴
-- 컬럼 LIKE '패턴'
-- 패턴 형식 : % ->0개이상~ : ex) '%java%' => java 문자열을 포함하는 문자열
-- _ 한자리 __ 두자리 ___ 세자리 => ex) '__A' 앞 두자리는 어떤 문자가 와도 상관없고 A로 끝나는 세자리 문자열

--F로 시작하는 이름의 사원 리스트
select * from emp where ename like 'S%';

-- 이름의 A를 포함하는 사원 리스트 : '%A%' '%java%'
select * from emp where ename like '%A%';
-- 이름의 A를 포함하는 사원 리스트 : '%A%' '%java%'
select * from emp where ename not like '%A%';


-- 이름의 N으로 끝나는 사원 리스트 : '%N' '%,pdf'
select * from emp where ename like '%N';

-- 사원 이름중 두번째 문자가 A인 사원 리스트
select * from emp where ename like '_a%';
-- 사원 이름중 세번째 문자가 R인 사원 리스트
select * from emp where ename like '__R%';

-- 사원 이름중 끝에서 두번째 문자가 R인 사원 리스트
select * from emp where ename like '%R_';

-- null 여부를 판단 하는 is null / is not null
-- 커미션이 등록되지 않은 사원 리스트=> comm 이 null 인 사원
select * from emp where comm is null;
-- 커미션이 등록되어있는 사원 리스트 => comm 이 null 이 아닌 사원
select * from emp where comm is not null;
-- 커미션을 받지 않는 사원 리스트
select * from emp where comm = 0 or comm is null;
-- 커미션을 받는 사원의 리스트
select * from emp where not (comm = 0 or comm is null);

-- select의 출력 결과의 정렬: 오름차순 asc, 내림차순 desc
-- select ... from ... where ... order by 컬럼이름 {asc(생략가능), desc}
-- 급여순(오름차순)으로 사원 리스트 출력
select * from emp order by sal asc;
select * from emp order by sal;
select * from emp order by sal desc;

-- 문자정렬
-- 이름 순 : 사전 순서
select * from emp order by ename asc;
select * from emp order by ename desc;

-- 날짜
-- 입사일 빠른 순서대로 정렬 : 오름차순
select * from emp order by hiredate;
-- 최근 입사일 기준으로 정렬 : 내림차순
select * from emp order by hiredate desc;

-- 급여 순으로 정렬
select * from emp order by sal, ename desc;





















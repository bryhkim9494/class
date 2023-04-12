-- 2023.04.12
-- 함수

desc dual;

SELECT
    *
FROM
    dual;

-- 단일 행 함수 / 집합(그룹) 함수
-- 단일행 함수 : 숫자, 문자, 날짜, 변환 ,기타 함수

-- <숫자 함수 >

-- 절댓값 abs

SELECT
    10,
    - 10,
    abs(- 10),
    abs(10)
FROM
    dual;

-- floor : 소수점 아래를 절사 해준다
SELECT
    2.1,
    2.9,
    floor(2.1),
    floor(2.9)
FROM
    dual;

-- round : 지정 위치에서 반올림 처리
SELECT
    1234.567,
    round(1234.567),
    round(1234.567, 1)
FROM
    dual;

-- trunc :  특정 자릿수 아래를 절사
SELECT
    1234.567,
    trunc(1234.567),
    trunc(1234.567, - 1),
    trunc(1234.567, - 2)
FROM
    dual;

-- mod : 나머지 연산
SELECT
    mod(1, 3),
    mod(4, 5),
    mod(9, 3),
    mod(10, 9)
FROM
    dual; --mod(13,0)X

-- <문자 함수>
-- 문자열 모두를 소문자로 변경
SELECT
    'SCOTT',
    lower('SCOTT')
FROM
    dual;

SELECT
    dname,
    lower(dname)
FROM
    dept;

SELECT
    'scott',
    upper('scott')
FROM
    dual;

SELECT
    initcap('scott')
FROM
    dual;
-- 문자열을 추출 : substr(원본, 시작위치), substr(원본, 시작위치, 반환할 문자의 개수)
SELECT
    '안녕하세요. 손흥민입니다.',
    substr('안녕하세요. 손흥민입니다.', 5),
    substr('안녕하세요. 손흥민입니다.', 2, 8)
FROM
    dual;

-- 문자열의 개수 : length(원본 문자열)
SELECT
    length('안녕하세요.!!!!')
FROM
    dual;

-- 문자열에서 특정 자리수 지정하고 자리에 데이터가 없을때 패턴을 입력
--00010

SELECT
    '10',
    lpad('10', 10, '0'),
    rpad('11', 5, '*')
FROM
    dual;

SELECT
    deptno
FROM
    dept;

SELECT
    deptno,
    lpad(deptno, 5, '0')
FROM
    dept;



-- trim() : 공백 제거
SELECT
    '           ABC    ',
    TRIM('           ABC    '),
    TRIM('           ABC'),
    TRIM('ABC    ')
FROM
    dual;

SELECT
    'Steven King',
    replace('Steven King', 'Steven', 'S.'),
    replace('Steven King', 'Steven ', '')
FROM
    dual;

-- 날짜 함수
SELECT
    sysdate
FROM
    dual;

SELECT
    sysdate,
    months_between('23/11/12', sysdate)
FROM
    dual;

SELECT
    add_months(sysdate, 8)
FROM
    dual;

SELECT
    add_months(sysdate, - 1)
FROM
    dual;

SELECT
    add_months(sysdate, - 3)
FROM
    dual;

SELECT
    add_months(sysdate, - 6)
FROM
    dual;

SELECT
    next_day(sysdate, 6)
FROM
    dual;

SELECT
    last_day(sysdate)
FROM
    dual;

SELECT
    round(sysdate)
FROM
    dual;

SELECT
    trunc(sysdate)
FROM
    dual;

-- 변환함수
-- DATE -> CHAR
-- to_char(원본, '패턴')
SELECT
    sysdate,
    to_char(sysdate, 'YYYY-MM-DD'),
    to_char(sysdate, 'YYYY.MM.DD'),
    to_char(sysdate, 'YYYY-MM-DD day'),
    to_char(sysdate, 'yyyy.mm.dd. hh24 mi ss')
FROM
    dual;

-- number -> char

SELECT
    123456789,
    to_char(123456789, '000000000000'),
    to_char(123456789, '000,000,000,000'),
    to_char(123456789, '999999999999'),
    to_char(123456789, '999,999,999,999'),
    to_char(123456789, 'L999,999,999,999'),
    to_char(123456789, '999,999')
FROM
    dual;
    



-- char ->number
-- to_number('문자열', '패턴') => 숫자 타입
SELECT
    '20000' - '10000'  -- 자동 형변환
FROM
    dual;
select '20,000' - '10,000'
from dual;

SELECT
    TO_NUMBER('20,000', '999,999,999') - TO_NUMBER('10,000', '99,999')
FROM
    dual;



-- decode 함수 => = 비교 연산 후 결과를 출력 하는 함수 
-- switch~case 문과 유사.
SELECT
    ename,
    deptno,
    decode(deptno, 10, 'ACCOUNTING', 20, 'RESEARCH',
           30, 'SALE', 40, 'OPERATIONS') AS dname
FROM
    emp
ORDER BY
    deptno;





-- 8. 직급에 따라 급여를 인상하도록 하자. 
--직급이 'ANAlYST'인 사원은 5%, 'SALESMAN'인 사원은 10%, 
--'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20%인 인상한다.
-------------------------------------
SELECT
    ename,
    job,
    sal,
    decode(job, 'ANALYST', sal * 1.05, 'SALESMAN', sal * 1.1,
           'MANAGER', sal * 1.15, 'CLERK', sal * 1.2, sal) AS upsal
FROM
    emp;

SELECT
    ename,
    job,
    sal,
    decode(job, 'ANALYST', sal * 1.05, 'SALESMAN', sal * 1.1,
           'MANAGER', sal * 1.15, 'CLERK', sal * 1.2) AS up,
    nvl(decode(job, 'ANALYST', sal * 1.05, 'SALESMAN', sal * 1.1,
               'MANAGER', sal * 1.15, 'CLERK', sal * 1.2),
        sal)                                          AS upsal
FROM
    emp
ORDER BY
    sal DESC;

SELECT
    ename,
    job,
    sal,
    CASE
        WHEN job = 'ANALYST'  THEN
            sal * 1.05
        WHEN job = 'SALESMAN' THEN
            sal * 1.10
        WHEN job = 'MANEGER'  THEN
            sal * 1.15
        WHEN job = 'CLERK'    THEN
            sal * 1.20
        ELSE
            sal
    END AS "인상된 금액"
FROM
    emp;

SELECT
    ename,
    deptno,
    decode(deptno, 10, 'ACCOUNTING', 20, 'RESEARCH',
           30, 'SALE', 40, 'OPERATIONS') AS dname,
    CASE
        WHEN deptno = 10 THEN
            'ACCOUNTING'
        WHEN deptno = 20 THEN
            'RESEARCH'
        WHEN deptno = 30 THEN
            'SALES'
        ELSE
            'OPERATIONS'
    END                                  AS dname2
FROM
    emp
ORDER BY
    deptno;
-------------------------------------------------

-- 그룹함수, 집합함수, 집계함수. 다중행 함수
-- 하나의 행이 아닌 다중행을 그룹으로 묶어서 처리
-- sum,avg,count,max,min
-- 급여 총액을 구해보자
SELECT
    SUM(sal),
    to_char(SUM(sal),
            'L999,999')
FROM
    emp;
-- 커미션의 총합
SELECT
    SUM(comm),
    COUNT(comm),
    AVG(comm)
FROM
    emp;

SELECT
    comm
FROM
    emp
WHERE
    comm IS NOT NULL;

-- 평균 급여
SELECT
    AVG(sal),
    trunc(AVG(sal)),
    round(AVG(sal),
          2)
FROM
    emp;
-- 최대 급여 max , 최소 급여 min

SELECT
    MAX(sal),
    MIN(sal)
FROM
    emp;

-- count()=> row 개수
-- 전체 사원의 수
SELECT
    COUNT(*)
FROM
    emp;

-- 10번 부서의 사원 수
SELECT
    COUNT(*)
FROM
    emp
WHERE
    deptno = 10;

-- 부서의 개수
SELECT
    COUNT(*)
FROM
    dept;

SELECT DISTINCT
    job --distinct가 중복되는 데이터 제거해줌
FROM
    emp
ORDER BY
    job;

SELECT
    COUNT(DISTINCT job)
FROM
    emp;

SELECT
    COUNT(comm)
FROM
    emp;

SELECT
    *
FROM
    emp;
-- group by => 행 단위로 그룹핑

SELECT
    deptno,
    COUNT(*)        AS "사원의수",
    SUM(sal)        AS "총 급여액",
    trunc(AVG(sal)) AS "평균 급여액", --부서별
    MAX(sal)        AS "최고 급여액",
    MIN(sal)        AS "최소 급여액",
    COUNT(comm)     AS "커미션을 받는 사원수"
FROM
    emp
GROUP BY
    deptno
-- 그룹의 평균 급여가 2000 이상인
-- having avg(sal) >= 2000-- 그룹핑된 데이터의 집합함수 결과를 조건식으로 만들때
-- 총 급여액이 10000 넘어가는 그룹
HAVING
    SUM(sal) > 10000
ORDER BY
    deptno;

SELECT
    job --직급별
FROM
    emp
GROUP BY
    job
ORDER BY
    job;

SELECT
    *
FROM
    emp;

SELECT
    job,
    COUNT(*),
    trunc(AVG(sal)),
    SUM(sal),
    MAX(sal),
    MIN(sal),
    MAX(sal) - MIN(sal)
FROM
    emp
GROUP BY
    job;

SELECT
    ename,
    job,
    sal,
    CASE
        WHEN job = 'ANALYST'  THEN
            sal * 1.05
        WHEN job = 'SALESMAN' THEN
            sal * 1.10
        WHEN job = 'MANEGER'  THEN
            sal * 1.15
        WHEN job = 'CLERK'    THEN
            sal * 1.20
        ELSE
            sal
    END AS "인상된 금액"
FROM
    emp;
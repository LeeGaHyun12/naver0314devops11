select * from emp;

-- ename 이 'A'나 'S'로 시작하는 사람의 ENAME, SAL, COMM 조회
select ENAME,SAL,COMM FROM EMP WHERE ENAME LIKE 'A%' OR ENAME LIKE 'S%';
-- COMM이 NULL이 아닌 사람마다 조회
select * FROM EMP WHERE COMM IS NOT NULL;
-- MGR이 7698,7566,7782인 사람 조회(IN 사용)
select * FROM EMP WHERE MGR IN(7698,7566,7782);
-- SAL 이 2500부터 3000까지 조회 (AND 연산)
select * FROM  EMP WHERE SAL>=2500 AND SAL<=3000;
-- SAL 이 2500부터 3000까지 조회 (BETWEEN 사용)
select * FROM  EMP WHERE SAL BETWEEN 2500 AND 3000;
--job을 중복처리해서 한번씩만 출력하시오
select Distinct job from EMP;

--서브쿼리 문제
--ALLEN의 직업과 같은 직업을 가진 사람들을 조회
select * FROM EMP WHERE JOB=(Select JOB from  EMP where ENAME='ALLEN');
--SCOTT의 MGR과 같은 값을 가진 사람의 정보를 조회
select * FROM  EMP where MGR=(select MGR from EMP where ENAME='SCOTT');

--숫자함수, 문자함수 연습
select ABS(-5),ABS(5) FROM DUAL; --ABS 절대값
select CEIL(3.1),CEIL(3.9) FROM DUAL; --CEIL: 무조건 올림
select FLOOR(3.0),FLOOR(3.1),FLOOR(3.9) from DUAL; --FLOOR: 무조건 내림
select MOD(7,3),MOD(9,5) FROM DUAL; --MOD: 나머지
select POWER(2,3),POWER(3,4) FROM DUAL; --POWER: 지수승
select ROUND(23.456,2),ROUND(8927,-1),ROUND(4567890,-4) FROM DUAL; --ROUND: 반올림

--문자함수
select CONCAT('HAPPY','DAY') FROM DUAL;
select 'HAPPY'||'DAY' FROM DUAL; --위와 결과가 같다
select INITCAP('HAPPY'),INITCAP('hello') from dual; --첫글자만 대문자로
select lower('heLLOdAy'),upper('heLLOdAy') from dual;
select lower(ename),initcap(ename) from emp;
select lpad(sal,10,'*') from emp; --왼쪽으로 *채우기
select rpad(sal,10,'*') from emp; --오른쪽으로 *채우기
select substr('happy day',2,3) from dual; --2번인덱스부터 3글자 (첫글자 인덱스는 1) :app
select substr('happy day',-5,3) from dual; --뒤에서 5번째부터 3글자 (첫글자 인덱스는 1) :y d
select ename,length(ename) 글자수 from emp; --length: 길이, 글자수
select replace('Good day','o','*') from dual; --o를 *로 변경해서 출력
select instr('happy','a') from dual; --happy에 aㅇ의 위치 :2
select instr('happy','x') from DUAL; --x가 없을 경우 0
select instr('have a nice day','nice') from dual;
select trim('   hello   ') from dual;--앞뒤 공백 제거후 출력

--기타 함수
--NVL은 널일경우 대체값으로 출력
select NVL(comm,1000) from emp; --null 일 경ㅇ우 1000으로 출력
--decode: 값에 따라 다른 값을 출력할 때
select ENAME 사원명, DEPTNO 부서코드,
       decode(DEPTNO,10,'홍보부',20,'교육부',30,'인사부') 부서명 from EMP;

--join : ppt 43p
--inner join(내부조인), equi join
--방법 1
select
    emp.EMPNO,emp.ENAME,emp.JOB,dept.DNAME,dept.LOC
from emp,DEPT
where emp.DEPTNO=dept.DEPTNO; -- 사원테이블에 있는 사원들의 부서넘버와 부서 테이블있는 부서 넘버가 같은 것

--방법 2, 두테이블에 공통적으로 있는 컬럼일 경우에만 앞에 테이블명을 붙이고 나머지는 생략가능
select
    EMPNO,ENAME,JOB,DNAME,LOC
from emp,DEPT
where EMP.DEPTNO=dept.DEPTNO;

--방법 3, 테이블 명이 너무 길 경우 별칭을 사용할 수 있다
select
    e.EMPNO,ENAME,JOB,DNAME,LOC
from emp e,DEPT d
where e.DEPTNO=d.DEPTNO;


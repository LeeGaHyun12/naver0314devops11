SELECT * from emp;

문제 1: 직업별 평균 급여 조회
"EMP" 테이블에서 각 직업(JOB)별로 평균 급여(SAL)를 계산하세요.
결과는 평균 급여가 높은 순으로 정렬하고, 평균 급여 컬럼의 제목을 "평균 급여"로 표시하세요.

SELECT JOB,AVG(SAL) 평균급여 FROM EMP GROUP BY JOB;

문제 2: 특정 직업을 가진 사원 조회
"EMP" 테이블에서 직업이 'MANAGER' 또는 'CLERK'인 모든 사원의 이름(ENAME), 직업(JOB),
그리고 관리자 번호(MGR)를 조회하세요. 결과는 사원 이름으로 오름차순 정렬하세요.

SELECT ENAME,JOB,MGR FROM EMP WHERE JOB IN('MANAGER','CLERK') ORDER BY ENAME;


문제 3: 특정 기간 동안 고용된 사원 조회
"EMP" 테이블에서 1981년 1월 1일부터 1983년 12월 31일 사이에 고용된 모든 사원의 이름(ENAME),
고용 날짜(HIREDATE), 그리고 급여(SAL)를 조회하세요. 고용 날짜를 기준으로 오름차순 정렬하세요.

select  ENAME,HIREDATE,SAL FROM EMP WHERE TO_CHAR(HIREDATE,'yyyy') IN('1981','1983') ORDER BY HIREDATE;

문제 4: 최고 급여와 최저 급여 사이의 차이
"EMP" 테이블에서 최고 급여(MAX(SAL))와 최저 급여(MIN(SAL))의 차이를 계산하세요.
결과 컬럼의 제목을 "급여 차이"로 표시하세요.

SELECT ((MAX(SAL))-(MIN(SAL)) 급여 차이 FROM EMP;

문제 5: 특정 관리자 아래에서 일하는 사원 조회
"EMP" 테이블에서 관리자 번호(MGR)가 7902, 7839, 또는 7788인 사원들 중에서
급여(SAL)가 2000 이상인 사원의 이름(ENAME), 직업(JOB), 급여(SAL)를 조회하세요.
결과는 급여가 높은 순으로 내림차순 정렬하세요.

select * from emp  where mgr in (7902, 7839, 7788);

select ename, job, sal from (select * from emp  where mgr in (7902, 7839, 7788))
where sal >= 2000;

SELECT ENAME,JOB,SAL FROM EMP WHERE MGR IN(7902,7839,7788) AND SAL>2000 ORDER BY SAL DESC;

문제 1: 평균 급여보다 많이 받는 사원 찾기
"EMP" 테이블에서 전체 사원의 평균 급여보다 많이 받는 사원들의 이름(ENAME), 급여(SAL)를 조회하세요.
결과는 급여 순으로 내림차순 정렬하세요.

SELECT ENAME,SAL FROM EMP WHERE SAL<(SELECT AVG(SAL) FROM EMP) ORDER BY SAL DESC;

문제 2: 특정 사원보다 급여를 많이 받는 사원 찾기
'JAMES' 사원과 동일한 급여를 받는 사원들이 아닌,
'JAMES' 사원보다 더 많은 급여를 받는 사원들의 이름(ENAME), 급여(SAL)를 조회하세요.
결과는 급여 순으로 내림차순 정렬하세요.

SELECT ENAME,SAL FROM EMP WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='JAMES') ORDER BY SAL DESC;

문제 3: 특정 부서에서 일하는 사원 중 최고 급여 받는 사원 찾기
'30' 부서에서 일하는 사원들 중에서 최고 급여를 받는 사원의 이름(ENAME), 부서 번호(DEPTNO),
그리고 급여(SAL)를 조회하세요. 이때, 최고 급여는 서브쿼리를 사용하여 해당 부서의 최고 급여를 먼저 찾은 후,
그 급여를 받는 사원을 찾으세요.

SELECT ENAME,DEPTNO,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP WHERE DEPTNO='30');

문제 4: 관리자가 아닌 사원 찾기
관리자(MGR)로 등록되어 있지 않은 사원들의 이름(ENAME)과 직업(JOB)을 조회하세요.
여기서 관리자가 아니라는 것은, 해당 사원의 사원 번호(EMPNO)가 다른 사원의 관리자 번호(MGR)로
등록되어 있지 않음을 의미합니다.

SELECT ENAME,JOB FROM EMP WHERE EMPNO NOT IN(MGR);

문제 5: 특정 연도에 고용된 사원 중 최고 연봉을 받는 사원 찾기
1981년에 고용된 사원들 중에서 최고 급여를 받는 사원의 이름(ENAME), 고용 날짜(HIREDATE),
그리고 급여(SAL)를 조회하세요. 최고 급여는 서브쿼리를 사용하여 1981년에 고용된 사원들의 급여 중 최대값을
먼저 찾은 후, 그 급여를 받는 사원을 찾으세요.

SELECT ENAME 최고사원,SAL 급여 FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP WHERE TO_CHAR(HIREDATE,'yyyy')=1981);
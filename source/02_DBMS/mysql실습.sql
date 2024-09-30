-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL(제약조건FK, SEQUENCE 없음)
-- DML(outer join, and = &&,  or = ||(연결연산자는 concat 사용)일부단일행함수, rownum 없어 top-N 구문이 다름)

-- java에서 쓸 데이터 넣어 보고 연습해 보기
show databases;
-- ★★★ DCL (계정생성, 권한부여, 권한박탈, 계정삭제)
create user user01 identified by 'password'; -- 계정생성
grant all on *.* to user01; -- 권한부여
revoke all on *.* from user01; -- 권한박탈
drop user user01; -- 계정삭제
show databases;
use world; -- world 데이터베이스 영역으로 들어감
show tables; -- 현재 들어와 있는 데이터베이스 안의 테이블들
create database dev_user; -- 데이터베이스 생성(dev_user)
show databases;
use dev_user;
show tables;
select database(); -- 현재 들어와 있는 데이터베이스 명

-- ★★★ DDL
create table emp (
	empno    numeric(4)    primary key,
    ename    varchar(6)    not null,
    nickname varchar(6)    unique,
    sal      numeric(7, 2) check(sal > 0),
    comm     numeric(7, 2) default 0
);
desc emp;
insert into emp (empno, ename, nickname, sal) values (1111, '김수한무거북', '두루미거북이', 20);
select * from emp;
drop table if exists emp; -- if exists 예약어: 있으면 지워

-- major: mCode(학과번호, 인위적 pk), mName(학과이름), mOffice(학과사무실)
-- student: sNo(학번, pk), sName(이름), mCode(학과번호, fk)
drop table if exists student;
drop table if exists major;
create table major(
	mCode   int          primary key auto_increment, -- 자동 증가되는 pk(int형)
    mName   varchar(10), 
    mOffice varchar(30)
);
create table student(
	sNo   numeric(4)   primary key,
    sName varchar(10),
    mCode int,  
    foreign key(mCode) references major(mCode) -- fk 제약조건은 꼭 아래에 쓸 것
);
insert into major (mName, mOffice) values ('컴공', '201호'); -- 단축키: ctrl + d 복사
insert into major (mName, mOffice) values ('빅데이터', '202호'); 
insert into major (mName, mOffice) values ('웹디', '203호'); 
select * from major;
insert into student values(1001, '홍길동', 1);
insert into student values(1002, '신길동', 2);
insert into student values(1003, '박길동', 4); -- Error
select * from student;
-- 학번, 이름, 학과번호, 학과명, 학과사무실(학생이 없는 학과도 출력(outer join))
select sNo "학번", sName "이름", s.mCode "학과번호", mName "학과명", mOffice "학과사무실"
	from student s right outer join major m
    on s.mCode = m.mCode; 

-- ★ ★ ★ ★ ★ 자바(JDBC) 수업시간에 쓸 테이블 ★ ★ ★ ★ ★ 
drop table if exists personal; -- emp테이블 유사
drop table if exists division; -- dept테이블 유사
create table division (
	dNo int, -- 부서번호 (numeric도 가능, int가 큰 범주)
    dName varchar(20) not null, -- 부서명
    phone varchar(20) unique,   -- 부서전화
    position varchar(20),       -- 부서위치
    primary key(dNo)
);
insert into division values (10, 'finance', '02-888-8888', '신림');
insert into division values (20, 'research', '02-777-8888', '용산');
insert into division values (30, 'sales', '02-666-8888', '강서');
insert into division values (40, 'cs', '02-555-8888', '강남');
select * from division;
-- Edit 메뉴 -> Preference 메뉴 -> SQL Execution에서 "auto commit mode" 선택
create table personal (
	pNo 	  int,                  -- 사번
    pName     varchar(20) not null, -- 사원명
    job       varchar(20) not null, -- 직책
    manager   int,                  -- 상사 사번
    startdate date,                 -- 입사일
    pay       int,                  -- 급여
    bonus     int,                  -- 상여금
    dNo       int,                  -- 부서번호
    primary key(pno),
    foreign key(dno) references division(dno)
);
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
-- 오라클 NVL -> mysql ifnull(null일수도 있는 필드, 대체값) 
-- 매개변수 2개의 타입은 일치하지 않아도 됨
-- if(조건, 조건이T일때 반환값, 조건이F일때 반환값)
select pno "no", pname, pay, bonus, pay+ifnull(bonus, 0) "sum" from personal;
select pname, pay+if(bonus is null, 0, bonus) "sum" from personal;

-- select문 (and 연산자는 && 또는 and)
-- 1. 사번, 이름, 급여를 출력
select pNo, pName, pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * 
	from personal
	where pay between 2000 and 5000; -- between 사용
select * 
	from personal
	where pay >= 2000 and pay <= 5000; -- and 사용
select * 
	from personal
	where pay && 2000 and pay && 5000; -- && 사용
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno 
	from personal
    where dno in (10, 20); -- in 사용
select pno, pname, dno 
	from personal
    where dno = 10 or dno = 20; -- or 사용
select pno, pname, dno 
	from personal
    where dno = 10 || dno = 20; -- || 사용
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
	from personal
    order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal
    order by dno, pay desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname 
	from personal p , division d
	where p.dno = d.dno;
-- 7. 사번, 이름, 상사이름
select w.pno "사번", w.pname "이름", m.pname "상사이름"
	from personal w, personal m
    where w.manager = m.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력하되 상사가 없는 경우 ★CEO★로 출력) 
select w.pno "사번", w.pname "이름", ifnull(m.pname, '★CEO★') "상사이름(없으면 ★CEO★)"
	from personal w left outer join personal m
    on w.manager = m.pno; -- ifnull() 사용
select w.pno, w.pname, if(m.pname is null, '★CEO★', m.pname) "manager"
	from personal w left outer join personal m
    on w.manager = m.pno; -- if() 사용
-- 8-1 사번, 이름, 상사사번(상사가 없으면 ceo로 출력. ifnull함수의 매개변수의 타입이 상이해도 상관없음)
select pno "사번", pname "이름", ifnull(manager, '★CEO★') "상사이름(없으면 ★CEO★)"
	from personal;
-- 8-2. 사번, 이름, 상사이름, 부서명(상사가 없는 사람도 출력) – 같이 합시다
select w.pno "사번", w.pname "이름", ifnull(m.pname, '★CEO★') "상사이름(없으면 ★CEO★)", dname
	from division d, personal w left outer join personal m
    on w.manager = m.pno 
    where d.dno = w.dno;
    
-- 9. 이름이 s로 시작하는 사원 이름 instr함수 이용등 다양하게 사용 가능)
select pname
	from personal
    where pname like 's%'; -- like 이용
select pname
	from personal
    where substr(pname, 1, 1) = 's'; -- substr 이용
select pname
	from personal
    where instr(pname, 's') = 1; -- instr 이용
select pname
	from personal
    where lower(pname) like 's%'; -- lower 이용
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno "사번", w.pname "이름", w.pay "급여", dname "부서명", m.pname "상사이름"
	from personal w, personal m, division d
    where w.manager = m.pno and w.dno = d.dno; -- and 사용
select w.pno "사번", w.pname "이름", w.pay "급여", dname "부서명", m.pname "상사이름"
	from personal w, personal m, division d
    where w.manager = m.pno && w.dno = d.dno; -- && 사용
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay) "sumpay", max(pay) "maxpay"
	from personal
    group by dno;
-- 12. 부서명, 급여평균, 인원수
select dname, round(avg(pay)) "avgpay", count(*) "count"
	from personal p, division d
    where p.dno = d.dno
    group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno "부서코드", sum(pay) "급여합계", count(*) "인원수"
	from personal
    group by dno
    having count(*) >= 4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
    where pay = (select max(pay) from personal);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
	from personal
    where pay > (select avg(pay) from personal);
-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)
select pno, pname, pay, dname
	from personal p, division d
    where p.dno = d.dno
		and pay > (select avg(pay) from personal)
	order by dname, pay desc;
-- 17. 자신이 속한 부서의 평균보다 많이 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균 (where절의 subQuery를 이용하거나 inline view를 이용)
-- 1. where절 subQuery 이용
select pname, pay, dno, (select round(avg(pay)) avgpay from personal) "avgpay"
	from personal
    where pay > (select round(avg(pay)) avgpay from personal);
-- 2. inline view 이용
select pname, pay, p.dno, avgpay
	from personal p,
		(select dno, round(avg(pay)) "avgpay" from personal group by dno) g
    where p.dno = g.dno and pay > avgpay;

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname "이름", pay"급여", dname"부서명"
	from personal p, division d
    where p.dno = d.dno
		and startdate = (select min(startdate) from personal);
-- 19. 이름, 급여, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
-- 1. where절 subQuery 이용
select pname "이름", pay "급여",
	   (select round(avg(pay)) from personal where dno = p.dno) "부서평균급여"
	from personal p;
-- 2. inline view 이용
select pname "이름", pay "급여", round(avgpay)"부서평균급여"
	from personal p,
	     (select dno, avg(pay) avgpay from personal group by dno) g
	where p.dno = g.dno;
-- 20. 이름, 급여, 부서명, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select * from personal;
select * from division;
select pname "이름", pay "급여", dname"부서명", round(avgpay)"부서평균급여"
	from personal p, division d,
		 (select dno, avg(pay) avgpay from personal group by dno) g
	where p.dno = g.dno and p.dno = d.dno;

-- Oracle에서의 단일행 함수와 다른 부분
	-- ex. pname는 job이다.
select concat(pname, '는 ', job, '다') "message" from personal; -- concat 여러 개 가능
select round(35.78, 1); -- from 절 없이도 실행 가능

-- 시스템으로부터 현재시점, 현재날짜, 현재시간
select sysdate(), now(); -- 현재 날짜와 시간
select curdate(), curtime(); -- 현재 날짜와 현재 시간

-- date_format(날짜/시간, 포맷) => 날짜/시간형을 문자형으로 변환
-- date_format(문자, 포맷) => 문자형을 날짜/시간형으로 변환
	-- 포맷: %Y(년도 4자리), %y(년도 2자리)
    --      %m(01,02,..), %c(1,2,..) 월
    --      %d(01,02,..), %e(1,2,..) 일
    --      %W monday, %a Mon
    --      %H(24시), %h(12시), %p(오전, 오후), %i(분), %s(초)
select date_format(now(), '%Y년%m월%e일 %p %h시 %i분 %s초') "now";
select year(now()), weekday(now()) "요일";
select case weekday(now())
		when '0' then '월요일'
		when '1' then '화요일'
		when '2' then '수요일'
		when '3' then '목요일'
		when '4' then '금요일'
		when '5' then '토요일'
		when '6' then '일요일' end "dayofweek";
select case weekday(startdate)
		when '0' then '월요일'
		when '1' then '화요일'
		when '2' then '수요일'
		when '3' then '목요일'
		when '4' then '금요일'
		when '5' then '토요일'
		when '6' then '일요일' end "dayofweek" from personal;
-- format(숫자, 소숫점 자리수) -- 소숫점 자리수까지 출력하고 세자리마다 ,
select format(pay, 0) from personal; -- 세자리마다 ,
select format(pay, 2) from personal; -- 세자리마다 ,

-- ★ ★ ★ TOP-N 구문 (rownum이 없고, limit 이용)
select pname, pay from personal 
	order by pay desc limit 5; -- 0번째부터 5개(1-5등)
-- limit n = limit 0, n(1-n등까지)
-- limit n1, n2 (n1번째부터 n2개, 첫번째는 0번째)
-- pay순으로 1page(1-3등)
select pname, pay from personal
	order by pay desc limit 0, 3;
-- 2page(4-6등)
select pname, pay from personal
	order by pay desc limit 3, 3;
-- 3page(7-9등)
select pname, pay from personal
	order by pay desc limit 6, 3;

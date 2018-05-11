시퀀스(순차적으로 증가하는 값을 가지는 데이터베이스 오브젝트)
사용예)회원가입
회원을 구분하기 위해서 구분 키, 게시글 번호 : 자동적으로 증가 해야 하는 수

시퀀스 만들기
create sequence [시퀀스이름] 
   start with [시작값] 
   increment by [증가값]
   maxvalue  [최대값]
   cycle;

  create sequence student_seq start with 1 
     increment by 1
     maxvalue 9999999
     cycle;
  
   시퀀스의 다음값 가져오기
   select student_seq.nextval from dual;
   
   시퀀스의 현재값 가져오기
   select student_seq.currval from dual;
   
   사용자가 생성한 시퀀스 확인하기(user_sequences:시퀀스의 정보를 저장하는 테이블)
   select * from user_sequences
   
   ex)학생정보(번호,이름,학년)를 저장하는 테이블 student_ex
      에 자동으로 번호를 증가 시키면서 입력하기 
      
      insert 
        into student_ex
      values (student_seq.nextval,'홍길동',3);
  
시퀀스 초기화
   현재 시퀀스값 만큼 빼고 다시 1부터 시작
시퀀스 변경
   //증가값을 현재 값으로 변경
   alter sequence student_seq increment by -8;
   //초기화
   select student_seq.nextval from dual;
   //다시 증가값 1로 변경
   alter sequence student_seq increment by 1;
   //증가 시퀀스 증가 시키기
   select student_seq.nextval from dual;
   
 MySql 에는 auto_increment 를 이용해서 key값을 1씩 증가 시킬수 있음
   
   
----------------------------------------------------
제약사항 
테이블에 데이터를 입력할 때 특정한 값만 들어갈 수 있도록 설정
ex)중복되지 않는 값만 넣을 수 있게 한다. null은 넣지못하도록 한다, 
   범위지정 등등...
   primary key  기본키 지정(중복안됨,not null), 테이블당 하나 
   not null null 허용 X 
   unique 중복 허용X
   check 특정범위지정 
   foreign key 다른 테이블의 기본키(primary key)인 값만 쓸수 있게 지정   

제약사항 지정 방법

테이블에 적용된 제약사항 확인하기 
user_constraints     <<적용된 제약사항이 저장된 테이블
테이블에서 테이블 이름, 제약사항 이름, 제약사항 타입 조회하기

select table_name,constraint_name,constraint_type
  from user_constraints
 where table_name = 'STUDENT'  


1. 테이블 생성할 때
student 테이블 작성 
번호 : 기본키,
이름 : not null,
학년 : not null,
점수 :  100이하

create table student(
	num number(3) primary key,
	name varchar2(20) not null,
	grade number(2)not null,
	emain varchar2(50) unique,
	score number(5) check (score<=100)
)

constraint [제약사항이름] [제약사항]

create table student(
	num number(3) constraint student_pk primary key,
	name varchar2(20) not null,
	grade number(2) not null,
	email varchar2(50) not null,
	score number(5),
	constraint student_email_uq unique(email),
	constraint student_score_ck check(score<=100),
	constraint student_email_fk reference 테이블명(칼럼명)
)

alter table student
add constraint student_fk  
 foreign key(제약사항 대상 칼럼) 
 references 외래키가있는테이블명(key)


insert into student
  values(1,'홍',3,50);

not null 확인

insert into student (num,name,score)
      values (3,'이',100);

2. 테이블 생성하고 난 뒤(테이블 수정)

alter table student add primary key(name);
alter table student add not null(email);

create table student(
    num number(5),
    name varchar2(20),
    email varchar2(50)
)

alter table student 
add constraint email_fk foreign key(email)
references email_info(email)


create table email_info(
    email varchar2(50) primary key,
    info varchar2(100)
)
insert into email_info values('email1','info1');
insert into email_info values('email2','info2');

email_info에 들어가 있지 않은 key를 넣으려고 하면 foreign key 정책 위반
insert into student values (1,'hong','email');

------------------------------------------------
테이블 생성시 칼럼 기본값 설정하기 
create table student(
	num number(5) primary key,
	name varchar2(40) not null,
	birth_day date default sysdate
)

Member table 작성하기 
num: number(10) 기본키 , 회원번호
id: varchar2(30) null허용X, 중복허용 X , 아이디
pw: varchar2(50) null허용X   비밀번호
name: varchar2(20) null허용X 이름
email: varchar2(30) null 허용X, 중복허용 X 이메일
regDate: date    기본값 sysdate    회원가입일

테이블 작성하고, insert update,delte,select 연습해보고
dao 작성까지 
(insertMember, 모든 멤버 데이터 삽입
updateMember, 멤버 데이터 모두 수정, 기준은 번호
deleteMember, 멤버 데이터 하나 삭제, 기준은 번호
selectOne, 멤버데이터 하나 조회 기준은 번호
selectAll) 



insert into student (num,name,grade)
  values (시퀀스이름.,'홍',3);


  
  create table student(
  	num number(10) primary key
  	.
  	.
  	.
  	
  )


  inser
  
  





















      
      




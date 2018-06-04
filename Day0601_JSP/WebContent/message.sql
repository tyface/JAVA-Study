create table message(
  id number(10) primary key,
  password varchar2(50) not null,
  name varchar2(30) default '이름없음',
  message varchar2(500)
)
시퀀스 만들기
message_seq
create sequence message_seq start whith 1 increment by 1 maxvalue 9999999 cycle;


  insert into message values(message_seq.naxtval,'이름', '123', '내용' )

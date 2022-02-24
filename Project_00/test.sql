create table board(
	id int primary key,
	title varchar(50),
	writer varchar(50),
	content varchar(100),
	wdate date default sysdate
);

create table users(
	id varchar(20) primary key,
	password varchar(20),
	name varchar(30),
	role varchar(20)
);

insert into users values('admin','1234','관리자','ADMIN');
insert into users values('oh','1234','홍길동','USER');
insert into board (id,title,writer,content) values(1,'제목','홍길동','내용확인테스트');

select * from board;
select * from users;

drop table board;

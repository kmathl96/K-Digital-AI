create table accountw (
    id varchar2(10) primary key,
    name varchar2(20),
    balance number default 0,
    sect varchar2(10),
    grade varchar2(10)
);
drop table accountw;

create table memberw (
    id varchar2(10) primary key,
    password varchar2(10) not null,
    name varchar2(20),
    sex varchar2(10),
    age number,
    email varchar2(20)
);
insert into memberw values ('101','121212','hong','male',20,'hong@naver.com');
insert into memberw values ('102','121212','hong','male',20,'hong@naver.com');
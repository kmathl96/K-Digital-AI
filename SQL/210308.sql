create table board (
board_num number primary key,
board_name varchar2(20) not null,
board_pass varchar2(15) not null,
board_subject varchar2(50) not null,
board_content varchar2(2000) not null,
board_file varchar(50),
board_re_ref number not null,
board_re_lev number not null,
board_re_seq number not null,
board_readcount number default 0,
board_date date);
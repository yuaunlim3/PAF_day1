# create database vttp_2025;
# use vttp_2025;

#drop table tv_shows;
/*
create table tv_shows(

	prog_id int not null auto_increment,
    title char(64) not null,
    lang char(64) not null,
    official_site varchar(255),
    rating enum('G','PG','NC13','M18','R21') not null,
    user_rating float default '0.0',
    release_date date,
    image blob,
    constraint pk_prog_id primary key (prog_id),
    constraint chk_user_rating check(user_rating between 0.0 and 10.0)
);

#select * from information_schema.table_constraints
#where table_name = 'tv_shows'
*/

/*
create table tutorial(
	id int not null auto_increment,
    title varchar(100) not null,
    author varchar(100) not null,
    submission_date date,
    constraint pk_tutorial_id primary key(id)
);


insert into tutorial(title,author,submission_date) values('CS1001','Chuk','2025-02-01');
insert into tutorial(title,author,submission_date) values('CS1002','Bob','2025-02-05');
insert into tutorial(title,author,submission_date) values('CS1003','Tom','2025-02-04');
insert into tutorial(title,author,submission_date) values('CS1004','Tim','2025-02-11');
insert into tutorial(title,author,submission_date) values('CS1005','Fred','2025-02-21');
insert into tutorial(title,author,submission_date) values('CS1006','Chris','2025-02-24');
insert into tutorial(title,author,submission_date) values('CS2004','John','2025-02-16');
insert into tutorial(title,author,submission_date) values('CS2005','Daniel','2025-02-08');
insert into tutorial(title,author,submission_date) values('CS2006','Cheesy','2025-02-27');
*/

#select * from tutorial limit 4 offset 4;
#select * from tutorial where author like '%i%';
#select * from tutorial where submission_date between '2025-02-10' and '2025-02-25' and author like '%i%' order by author asc ;
#select * from tutorial where submission_date > '2025-02-10'
#order by submission_date asc;
#select * from tutorial where title in ('cs1001','cs1004','cs2006');

/*
insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('AI will win','Chinese','PG','5.2','2025-02-11');
           
insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('AI will lose','English','PG','6.7','2025-06-11');


insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('AI is here','English','M18','7.7','2025-06-22');
           
insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('AI is gone','Chinese','G','8.7','2025-11-24');
insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('Inside Out','English','G','7.7','2025-02-11');

insert into tv_shows(title,lang,rating,user_rating,release_date) 
           values('James Bond','English','M18','7.7','2025-05-11');
*/
#select * from tv_shows where user_rating > 5.0 and rating in ('M18','G');






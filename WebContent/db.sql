/*
#users
insert into users values('254135190','henrybit','123456','13811497685','35072119830328121M','2013-04-20 13:37:00','2013-04-20 13:37:00','',1);
insert into users values('200535180','psy','123456','13114987900','127913721872813788','2013-04-20 13:38:00','2013-04-20 13:38:00','',1);


#meeting
insert into meeting values(null,3,'2013-04-21 17:00:00', 'joinUs server is running','254135190',1,'北京大兴区',now(),now());
insert into meeting values(null,4,'2013-04-25 20:00:00','开始第五次讨论会议','254135190',1,'北京海淀区－国贸',now(),now());


#meeting_users
insert into meeting_users values(null,1,'254135190','254135190,200535180',now(),now());

#user_meeting_join
insert into user_meeting_join values(null,'200535180',1,1);
insert into user_meeting_join values(null,'200535180',2,1);
insert into user_meeting_join values(null,'254135190',1,1);

#users_relation
insert into users_relation values(null,'254135190','200535180',2,100,now(),now());

#user_contact_list
insert into user_contact_list values(null,'254135190','200535180','13114987900','','小玉',now(),now());
*/

create table user_info
(
	uid varchar(32) not null,
	name varchar(100),
	sex int(2) not null default 3,
	localPicUrl varchar(1024),
	picUlr varchar(1024),
	phoneNo varchar(20),
	deviceNo varchar(64),
	createTime int(32),
	updateTime int(32),
	primary key(uid)
);


create table activity
(
	id int(32) not null AUTO_INCREMENT,
	name varchar(100),
	tag int(2) not null default 0,
	content varchar(1024),
	createUserId varchar(32) not null,
	joinUsersId varchar(1024) not null,
	status int(2) default 1,
	lat varchar(32),
	lng varchar(32),
	address varchar(1024),
	startTime int(32),
	headPic varchar(1024),
	pubStatus int(2),
	primary key(id)
);

create table user_relation
(
	uid varchar(32) not null,
	friendId varchar(32) not null,
	has_update int(2),
	status int(2),
	relation_value int(4),
	primary key(uid,friendId)
);

create table plaza_activity
(
	id int(32) not null AUTO_INCREMENT,
	name varchar(100),
	tag int(2) not null default 0,
	content varchar(1024),
	createUserId varchar(32) not null,
	joinUsersId varchar(1024) not null,
	lat varchar(32),
	lng varchar(32),
	address varchar(1024),
	startTime int(32),
	headPic varchar(1024),
	primary key(id)
);


create table plaza_init
(
	aid int(32) not null
	bigPic varchar(1024),
	seq int(4)
);

create table friend_share_message
(
	id int(32) not null AUTO_INCREMENT,
	aid int(32) not null,
	shareUid varchar(32),
	content varchar(1024),
	pic varchar(1024),
	shareTime int(32),
	primary key(id)
);

create table plaza_share_message
(
	id int(32) not null AUTO_INCREMENT,
	aid int(32) not null,
	shareUid varchar(32),
	content varchar(1024),
	pic varchar(1024),
	shareTime int(32),
	primary key(id)
);


create table user_activity_notice_status
(
	uid varchar(32) not null,
	aid int(32),
	count int(32)
);


create table user_activity_notice
(
	uid varchar(32) not null,
	aid int(32),
	sid int(32)
);


create table user_plaza_notice_status
(
	uid varchar(32) not null,
	aid int(32),
	count int(32)
);


create table user_plaza_notice
(
	uid varchar(32) not null,
	aid int(32),
	sid int(32)
);


create table user_relation_notice
(
	uid varchar(32) not null,
	friendId varchar(32) not null,
	behavior int(2),
	message varchar(1024)
);


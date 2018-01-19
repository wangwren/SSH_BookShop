用户表：权限ulimit:1代表管理员，2代表普通用户
create table users
	(
		id int(10) NOT NULL AUTO_INCREMENT,
		username varchar(40) not null unique,	
		password varchar(40) not null,
		phone varchar(40) not null,
		email varchar(40) not null,
		ulimit int not null,
		primary key(id)
	);

用户收货信息表：
Create table reward
(
		id int(10) NOT NULL AUTO_INCREMENT,
		address varchar(100) not null,	
		user_id varchar(40) not null,
		primary key(id)
)


图书分类：
create table category
	(
		id varchar(40) primary key, 
		name varchar(40) not null unique,	
		description varchar(255) 
	);


图书信息：
create table books
	(
		id int(10) NOT NULL AUTO_INCREMENT,
		name varchar(100) not null unique,	
		author varchar(40) not null,		
		price double not null,			
		image varchar(100),			
		description varchar(255),		
		category_id int,		
		primary key(id)
	);


订单表：
create table orders
	(
		id int(10) NOT NULL AUTO_INCREMENT,
		ordertime datetime not null, 
		price double,	
		state boolean, 
		user_id int(10),
primary key(id)
	);



订单项：
create table orderitem
	(
		id int(10) NOT NULL AUTO_INCREMENT, 
		quantity int, 
		price double,	
		order_id int(10), 
		book_id int(10), 
		primary key(id)
	);

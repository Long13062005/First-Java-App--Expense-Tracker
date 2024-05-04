create database expense_app;
use expense_app;
-- Role One to Many User
create table `role` (
	id int primary key,
    `name` nvarchar(255) not null
);
-- User one to many role
Create table `user`(
	id int auto_increment primary key,
    username nvarchar(255) unique not null,
    `password` nvarchar(255) not null,
    balance double default 0 not null,
    role_id int default '2' not null,
    foreign key(role_id) references role(id)
);
create table expense(
	id int auto_increment primary key,
    `date` Date not null,
    type_expense nvarchar(255) not null,
    price double not null,
    `description` nvarchar(255) ,
    user_id int,
    foreign key(user_id) references `user`(id)
);
create table feedback(
	id int auto_increment primary key,
    `description` nvarchar(255) not null,
    user_id int not null,
    foreign key(user_id) references `user`(id)

);

INSERT INTO `role` (id, `name`) VALUES (1, 'Admin');
INSERT INTO `role` (id, `name`) VALUES (2, 'User');

INSERT INTO `user` (username, `password`,role_id) VALUES ('1', '1',1);
INSERT INTO `user` (username, `password`) VALUES ('2', '2');
 

INSERT INTO `expense` (`date`, `type_expense`, `price`, `description`, `user_id`)
VALUES ('2024-04-29', 'Food', 20.50, 'Lunch at a restaurant', 1);

SELECT *
FROM user u
JOIN expense e ON u.id = e.user_id;

SELECT * FROM USER WHERE ID = 1;
SELECT * FROM `user` WHERE `username` = 'admin' AND `password` = 1 AND role_id = 1;
truncate  expense ;
SELECT * FROM EXPENSE where id = 4 and User_id = 1;
SELECT COUNT(*) AS user_count FROM user WHERE role_id = 2;
SELECT * FROM expense WHERE `date` = '2024-05-08' AND user_id = 1;
delete from feedback where id = 5;
Update from user
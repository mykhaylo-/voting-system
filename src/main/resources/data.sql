insert into user(id,username,password) values (1,'admin','$2a$10$mnbudqYVGlTNDeB6pSkKF.DA0dHQTYYCb/CxHNJAcTfgcFo0E9FzS');
insert into user(id,username,password) values (2,'user','$2a$10$f8FOrYvTR/x7ksqwcC17v.B4idH/BeCE/topNBF/QBmkOMnmDV5XC');

insert into user_roles(user_id,roles) values (1, 'ROLE_ADMIN');
insert into user_roles(user_id,roles) values (1, 'ROLE_USER');
insert into user_roles(user_id,roles) values (2, 'ROLE_USER');





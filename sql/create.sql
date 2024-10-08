create table person(
    id serial primary key,
    username varchar(255) not null,
    year_of_birth int not null,
    password varchar not null
)

insert into person(username, year_of_birth, password)
values
('admin', 1990, 'admin'),
('user', 1991, 'user')

alter table person add column role varchar(255) not null

update person set role = 'ROLE_ADMIN' where username = 'admin'
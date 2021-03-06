
create table Depart
(
     id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY not null,
     name varchar(200)
);

create table UserCard
(
    id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY not null,
    id_depart bigint null,
    cartNumber int null,
    fullName   varchar(200),
    restSum double precision null,
    startDate date null ,
    stopDate date null,
    birthDate date null ,
    tel varchar (60) null,
    foreign key (id_depart) references Depart (id)
);

drop schema if exists PLANE_SCHEDULER cascade;

create schema PLANE_SCHEDULER;
set schema PLANE_SCHEDULER;

create table PLANE
(
    ID          identity not null primary key,
    DESCRIPTION varchar2(255),
    MAX_SPEED   integer  not null
);

create table AIRPORT
(
    ID          identity      not null primary key,
    DESCRIPTION varchar2(255),
    CAPACITY    integer default 0,
    LATITUDE    decimal(9, 6) not null,
    LONGITUDE   decimal(9, 6) not null

);

create table ROUTE
(
    ID      identity not null primary key,
    PLANE_ID integer  not null,

    foreign key (PLANE_ID) references PLANE
);

create table ROUTE_POINT
(
    ID                identity not null primary key,
    ROUTE_ID          integer  not null,
    AIRPORT_ID       integer  not null,
    ROUTE_POINT_INDEX integer  not null,
    DEPART_TIME       timestamp with time zone,
    ARRIVE_TIME       timestamp with time zone,

    foreign key (ROUTE_ID) references ROUTE,
    foreign key (AIRPORT_ID) references AIRPORT
);
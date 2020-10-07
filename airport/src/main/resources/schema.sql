drop schema if exists PLANE_SCHEDULER cascade;

create schema PLANE_SCHEDULER;
set schema 'PLANE_SCHEDULER';

create table PLANE_SCHEDULER.PLANE
(
    ID          integer not null primary key generated always as identity,
    DESCRIPTION varchar(255),
    MAX_SPEED   integer  not null
);

create table PLANE_SCHEDULER.AIRPORT
(
    ID          integer not null primary key generated always as identity,
    DESCRIPTION varchar(255),
    CAPACITY    integer default 0,
    LATITUDE    decimal(9, 6) not null,
    LONGITUDE   decimal(9, 6) not null

);

create table PLANE_SCHEDULER.ROUTE
(
    ID      integer not null primary key generated always as identity,
    PLANE_ID integer  not null,

    foreign key (PLANE_ID) references PLANE_SCHEDULER.PLANE
);

create table PLANE_SCHEDULER.ROUTE_POINT
(
    ID                integer not null primary key generated always as identity,
    ROUTE_ID          integer  not null,
    AIRPORT_ID       integer  not null,
    ROUTE_POINT_INDEX integer  not null,
    DEPART_TIME       timestamp with time zone,
    ARRIVE_TIME       timestamp with time zone,

    foreign key (ROUTE_ID) references PLANE_SCHEDULER.ROUTE,
    foreign key (AIRPORT_ID) references PLANE_SCHEDULER.AIRPORT
);

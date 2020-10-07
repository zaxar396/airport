insert into PLANE_SCHEDULER.PLANE (DESCRIPTION, MAX_SPEED)
values ('Mega fast plane', 200),
       ('Fast plane', 150),
       ('Simple plane 1', 100),
       ('Simple plane 2', 100),
       ('Slow plane', 50);

insert into PLANE_SCHEDULER.AIRPORT(description, capacity, latitude, longitude)
VALUES ('Moscow', 1, 55.75, 37.61),
       ('Lisbon', 1, 38.43, -9.12),
       ('Reykjavik', 2, 64.09, -21.53),
       ('Ottawa', 3, 42.25, -75.40),
       ('Ankara', 2, 39.52, 32.52),
       ('Beijing', 2, 39.56, 116.24),
       ('Madrid', 2, 40.24, -3.41);

insert into PLANE_SCHEDULER.ROUTE(PLANE_ID)
VALUES (1),
       (2),
       (3),
       (3),
       (4),
       (1);

insert into PLANE_SCHEDULER.ROUTE_POINT(ROUTE_ID, AIRPORT_ID, ROUTE_POINT_INDEX, ARRIVE_TIME, DEPART_TIME)
VALUES
-- Moscow -> Lisbon (route 1)
(1, 1, 0, null, '2019-01-01 09:00:00'),
(1, 2, 1, '2019-01-01 12:00:00', null),
-- Moscow -> Reykjavik (route 2)
(2, 1, 0, null, '2019-01-01 15:00:00'),
(2, 3, 1, '2019-01-02 12:00:00', null),
-- Madrid -> Moscow (route 3)
(3, 7, 0, null, '2019-01-01 01:00:00'),
(3, 1, 1, '2019-01-01 22:00:00', null),
-- Ottawa -> Moscow -> Ankara (route 4)
(4, 4, 0, null, '2019-01-01 01:00:00'),
(4, 1, 1, '2019-01-01 10:00:00', '2019-01-01 12:00:00'),
(4, 5, 2, '2019-01-01 22:00:00', null);

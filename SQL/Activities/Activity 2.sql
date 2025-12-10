CREATE TABLE salesman(
    salesman_id  INT,
    salesman_name VARCHAR2(32),
    salesman_city VARCHAR2(32),
    commission INT
);

INSERT INTO salesman 
values (5001,'James Hoog','New York',15 );

INSERT INTO salesman 
values (5002,'Nail Knite','Paris',13 );

INSERT INTO salesman 
values (5005,'Pit Alex','London',11 );

INSERT INTO salesman 
values (5006,'McLyon','Paris',14 );

INSERT INTO salesman 
values (5007,'Paul Adam','Rome',13 );

INSERT INTO salesman 
values (5003,'Lauson Hen','San Jose',12 );

Select *FROM salesman;

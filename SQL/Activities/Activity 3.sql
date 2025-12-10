CREATE TABLE salesman(
    salesman_id  INT,
    salesman_name VARCHAR2(32),
    salesman_city VARCHAR2(32),
    commission INT
);

SELECT salesman_id, salesman_city FROM salesman;

SELECT *FROM salesman WHERE salesman_city ='Paris';

SELECT salesman_id,commission From salesman WHERE salesman_name = 'Paul Adam';

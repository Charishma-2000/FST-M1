SELECT SUM(purchase_amount) as purchase_amt FROM orders;

SELECT AVG(purchase_amount) as avg_purchase_amt FROM orders;

SELECT MAX(purchase_amount) as max_purchase_amt FROM orders;

SELECT MIN(purchase_amount) as min_purchase_amt FROM orders;

SELECT COUNT(DISTINCT salesman_id) as Num_of_salesman FROM orders;

REM   Script: Activity7
REM   Performing aggregate functions

select sum(purchase_amount) as "Total Sum" from orders;

select avg(purchase_amount) as "Average" from orders;

select max(purchase_amount) as "Maximum" from orders;

select min(purchase_amount) as "Minimum" from orders;

select count(distinct salesman_id) as "Total Count" from orders;


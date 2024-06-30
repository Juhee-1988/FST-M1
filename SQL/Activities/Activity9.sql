REM   Script: Activity9
REM   Joining tables

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

insert all 
    into customers values (3002, 'Nick Rimando', 'New York', 100, 5001) 
    into customers values (3007, 'Brad Davis', 'New York', 200, 5001) 
    into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
    into customers values (3008, 'Julian Green', 'London', 300, 5002) 
    into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    into customers values (3001, 'Brad Guzan', 'London', 300, 5005) 
select 1 from DUAL;

select a.customer_name, a.city, b.salesman_name, b.commission from customers a inner join salesman b on a.salesman_id=b.salesman_id;

select a.customer_name, a.city, a.grade, b.salesman_name, b.salesman_city from customers a left outer join salesman b on a.salesman_id=b.salesman_id where a.grade < 300 order by a.customer_id;

select a.customer_name as "Customer Name", a.city, b.salesman_name as "Salesman Name", b.commission from customers a inner join salesman b on a.salesman_id=b.salesman_id where b.commission>12;

select a.order_no, a.order_date, a.purchase_amount, b.customer_name as "Customer Name", b.grade,  
    c.salesman_name as "Salesman Name", c.commission from orders a  
    inner join customers b on a.customer_id=b.customer_id 
    inner join salesman c on a.salesman_id=c.salesman_id;


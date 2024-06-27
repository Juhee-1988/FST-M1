REM   Script: Activity5
REM   Updating rows in table

update salesman1 set grade=200 where salesman_city='Rome';

update salesman1 set grade=300 where salesman_name='Pit Alex';

update salesman1 set salesman_name='Pierre' where salesman_name='McLyon';

select * from salesman1;


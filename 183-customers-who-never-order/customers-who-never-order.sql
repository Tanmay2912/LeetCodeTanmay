/* Write your T-SQL query statement below */
-- select c.name as Customers 
-- from Customers as c
-- left join Orders as o
--     on c.id = o.customerId
-- where o.id is null

select name as Customers 
from Customers 
where id not in (select customerId from Orders)
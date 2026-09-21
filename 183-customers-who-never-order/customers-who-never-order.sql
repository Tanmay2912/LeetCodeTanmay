/* Write your T-SQL query statement below */
select 
    c.name as Customers 
from Customers as c
left join Orders AS o
    on c.id = o.customerId
where o.id is null
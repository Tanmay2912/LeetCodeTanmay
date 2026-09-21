/* Write your T-SQL query statement below */
-- I want all data of table person and city and state from table address hence person becomes left table and address becomes right table and if no match then null

SELECT 
    p.firstName, p.lastName, a.city, a.state
FROM Person AS p
LEFT JOIN Address as a
ON p.personId = a.personId;
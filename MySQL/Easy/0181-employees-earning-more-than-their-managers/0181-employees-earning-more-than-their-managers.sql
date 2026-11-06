# Write your MySQL query statement below
SELECT e.name as Employee FROM 
EMPLOYEE e JOIN EMPLOYEE m
ON e.managerId = m.id 
WHERE e.salary > m.salary
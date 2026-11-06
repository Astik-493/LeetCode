# Write your MySQL query statement below
SELECT e.name as name,b.bonus as bonus 
FROM EMPLOYEE e LEFT JOIN BONUS b ON e.empId =b.empId
WHERE b.bonus<1000 OR b.bonus IS NULL
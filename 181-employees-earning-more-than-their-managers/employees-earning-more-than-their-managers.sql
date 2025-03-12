# Write your MySQL query statement below
-- SELECT e.name AS Employee
-- FROM Employee e
-- JOIN Employee m ON e.managerId = m.id
-- WHERE e.salary > m.salary;

SELECT name AS Employee
FROM Employee
WHERE managerId IS NOT NULL 
AND salary > (SELECT salary FROM Employee m WHERE m.id = Employee.managerId);

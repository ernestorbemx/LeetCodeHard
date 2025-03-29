/* Write your PL/SQL query statement below */

SELECT Department, Employee, Salary--, rank
FROM (
    SELECT d.name Department, e.name Employee, e.salary Salary
        , DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY salary DESC ) AS rank
    FROM Employee e
    INNER JOIN Department d
        ON e.departmentId = d.id
    ORDER BY 3 desc
    )
where rank <= 3
order by 1,3 desc


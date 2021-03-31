 
select
    d.Name as Department,
    e.Name as  Employee,
    e.Salary Salary
from Employee e, Department d
where e.DepartmentId = d.Id
    and (e.Salary,e.DepartmentId) in(select max(Salary), DepartmentId from Employee group by DepartmentId);

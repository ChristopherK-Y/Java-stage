-- SQL 10
SELECT
    e.emp_no
FROM employees e
WHERE NOT EXISTS (SELECT * FROM dept_manager d WHERE e.emp_no = d.emp_no);

-- SQL 11
SELECT
    e.emp_no emp_no,
    m.emp_no manager
FROM dept_emp e
JOIN dept_manager m
ON e.dept_no = m.dept_no
WHERE e.emp_no != m.emp_no;

-- SQL 12
SELECT 
    d1.dept_no, d1.emp_no, s1.salary
FROM
    dept_emp AS d1
	INNER JOIN salaries AS s1 
		ON d1.emp_no = s1.emp_no
			AND d1.to_date = '9999-01-01'
			AND s1.to_date = '9999-01-01'
WHERE
    s1.salary IN (
		SELECT 
            MAX(s2.salary)
        FROM
            dept_emp AS d2
			INNER JOIN salaries AS s2 
				ON d2.emp_no = s2.emp_no
					AND d2.to_date = '9999-01-01'
					AND s2.to_date = '9999-01-01'
			WHERE d2.dept_no = d1.dept_no
	)
ORDER BY d1.dept_no;

-- SQL 15
select
    emp_no,
    birth_date,
    first_name,
    last_name,
    gender,
    hire_date
from employees
where emp_no % 2 != 0 and last_name != 'Mary'
order by hire_date desc;

-- SQL 16
select
    t1.title,
    avg(s1.salary)
from titles t1
    join salaries s1
        on t1.emp_no = s1.emp_no
group by title
order by avg(s1.salary);

-- SQL 17
select
    emp_no,
    salary
from salaries
order by salary desc
limit 1 offset 1;

-- SQL 18
select 
	s.emp_no, salary, last_name, first_name
from salaries s
join employees e
	on s.emp_no = e.emp_no
where
	s.salary =
	(
		select max(salary) from salaries
		where salary <
		(
			select max(salary) from salaries
		)
	);

-- SQL 19
select
    last_name,
    first_name,
    dept_name
from employees e
left join dept_emp de
    on e.emp_no = de.emp_no and de.to_date = '9999-01-01'
left join departments d
    on de.dept_no = d.dept_no;
    
-- SQL 21
select
    t1.emp_no, (t2.salary - t1.salary) growth
from
(
    select
        e.emp_no, s.salary
    from salaries s
    join employees e
        on s.emp_no = e.emp_no
            and s.from_date = e.hire_date
) t1
join
(
    select emp_no, salary from salaries
    where to_date = '9999-01-01'
) t2
on t1.emp_no = t2.emp_no
order by growth;

-- SQL 22
select
    d.dept_no, dept_name, count(*) sum
from departments d
join dept_emp de
    on d.dept_no = de.dept_no
join salaries s
    on de.emp_no = s.emp_no
group by d.dept_no, dept_name
order by dept_no;

-- SQL 23
select
    emp_no, salary, t_rank
from
(
    select
        emp_no, salary,
        @dense_rank := if(@last_salary = salary, @dense_rank, @dense_rank + 1) t_rank,
        @last_salary := salary
    from salaries,
        (select @row_number := 0, @dense_rank := 0, @last_salary = null) t
    where to_date = '9999-01-01'
    order by salary desc
) s
order by t_rank, emp_no;

-- SQL 24
select
    de1.dept_no, e.emp_no, s.salary
from employees e
join dept_emp de1
    on e.emp_no = de1.emp_no and to_date = '9999-01-01'
join salaries s
    on e.emp_no = s.emp_no and s.to_date = '9999-01-01'
where not exists (
    select * from dept_emp de2
    join dept_manager dm
        on de2.dept_no = dm.dept_no
    WHERE dm.emp_no = e.emp_no and de1.dept_no = de2.dept_no
);
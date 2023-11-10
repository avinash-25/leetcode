# Write your MySQL query statement below
Select s.user_id, Round(avg(case when c.action='confirmed' then 1 else 0 end), 2) as confirmation_rate
From Signups s
left join
Confirmations c
on s.user_id = c.user_id
group by s.user_id;
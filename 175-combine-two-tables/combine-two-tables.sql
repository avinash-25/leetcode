# Write your MySQL query statement below
select firstName ,lastName,city,state from Person left outer join address on person.personId=address.personId;
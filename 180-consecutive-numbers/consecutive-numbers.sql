SELECT DISTINCT num AS ConsecutiveNums
FROM (
  SELECT num,
         LEAD(num) OVER (ORDER BY id) AS next_num,
         LAG(num) OVER (ORDER BY id) AS prev_num
  FROM Logs
) AS t
WHERE num = next_num AND num = prev_num;

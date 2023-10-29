# Write your MySQL query statement below
select tweet_id 
from Tweets
where CHAR_LENGTH(content) > 15

# CHAR_LENGTH is a function through which we can cont the no. of words 
# of a sentence
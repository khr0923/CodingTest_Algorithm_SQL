-- 코드를 입력하세요
SELECT ri.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address, round(avg(rr.review_score), 2) as score
from rest_info ri inner join rest_review rr
on ri.rest_id = rr.rest_id
where address like ('서울%')
group by ri.rest_id
order by avg(rr.review_score) desc, ri.favorites desc;


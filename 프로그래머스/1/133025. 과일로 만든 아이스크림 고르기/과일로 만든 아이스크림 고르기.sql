-- 코드를 입력하세요

SELECT i.flavor
from first_half a inner join icecream_info i
on a.flavor = i.flavor
where a.total_order > 3000 and i.ingredient_type = 'fruit_based'

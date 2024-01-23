-- 코드를 입력하세요
# select * from food_product;
SELECT category, max(price) as max_price, product_name
from food_product
where category in ('과자', '국', '김치', '식용유') and price in (select max(price) from food_product group by category)
group by category
having max(price)
order by price desc;
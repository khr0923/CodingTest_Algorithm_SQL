-- 코드를 입력하세요
SELECT category, sum(sales) as total_sales
from book b inner join book_sales bs
on b.book_id = bs.book_id
where bs.sales_date like ('2022-01%')
group by category
order by category;
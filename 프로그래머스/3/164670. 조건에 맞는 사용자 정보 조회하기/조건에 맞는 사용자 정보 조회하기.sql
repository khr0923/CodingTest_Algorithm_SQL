-- 코드를 입력하세요
SELECT user_id, nickname, concat(city, ' ', street_address1, ' ', street_address2) as '전체주소',
concat(substr(u.tlno, 1, 3), '-', substr(u.tlno, 4, 4), '-', substr(u.tlno, 8, 4)) as '전화번호'
from used_goods_board b inner join used_goods_user u
on b.writer_id = u.user_id
group by u.user_id
having count(*) >= 3
order by u.user_id desc;
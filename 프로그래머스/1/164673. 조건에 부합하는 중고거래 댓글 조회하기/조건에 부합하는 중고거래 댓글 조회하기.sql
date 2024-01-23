-- 코드를 입력하세요
# select * from used_goods_board;
SELECT ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, date_format(ugr.created_date, '%Y-%m-%d') as created_date
from used_goods_board ugb join used_goods_reply ugr
on ugb.board_id = ugr.board_id
WHERE ugb.CREATED_DATE BETWEEN "2022-10-01" AND "2022-10-31"
order by ugr.created_date, ugb.title;
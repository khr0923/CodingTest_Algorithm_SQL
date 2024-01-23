-- 코드를 입력하세요
SELECT mcdp_cd as '진료과코드', count(APNT_NO) as '5월예약건수'
from appointment
where apnt_ymd like '2022-05%'
group by MCDP_CD
order by count(APNT_NO), MCDP_CD;
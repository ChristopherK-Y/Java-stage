set @a := 1;
select @a;

select @a := "陈沛鑫";	-- 这里必须是 :=

select if(1 = 2, "相等", "不等"); 

SET @row_number := 0;


SELECT 
	id, name, score, 
	@row_number := @row_number + 1 row_number
FROM scores, 
	(SELECT @row_number := 0) t
ORDER BY score DESC;

SELECT 
	id, name, score, 
	@dense_rank := if(score = @last_score, @dense_rank, @dense_rank + 1) dense_rank,
    @last_score := score
FROM scores, 
	(SELECT @dense_rank := 0, @last_score := null) t
ORDER BY score DESC;


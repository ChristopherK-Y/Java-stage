-- 学生：根据书名做模糊查询，分页功能（每页 20 条记录，取第 3 页）
SELECT 
    name, stock
FROM
    books
WHERE
    name LIKE '%红楼梦%'
ORDER BY id DESC
LIMIT 20 OFFSET 40;

-- 学生：根据书名做模糊查询，不要没有存量的，分页功能（每页 20 条记录，取第 3 页）
SELECT 
    name, stock
FROM
    books
WHERE
    name LIKE '%?%'
    AND stock > 0
ORDER BY id DESC
LIMIT 20 OFFSET 40;

-- 学生：借书
UPDATE books SET stock = stock - 1 WHERE bid = ?;
INSERT INTO borrow_records (sid, bid) VALUES (?, ?);

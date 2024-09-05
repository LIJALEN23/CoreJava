CREATE TABLE IF NOT EXISTS webinfo(
num INT NOT NULL,
name VARCHAR(20) NOT NULL,
url VARCHAR(20) NOT NULL,
PRIMARY KEY(num)
);

INSERT INTO webinfo VALUES(2, 'leetcode', 'www.leetcode.cn');
INSERT INTO webinfo VALUES(3, 'swu', 'www.swu.edu.cn');
INSERT INTO webinfo VALUES(4, 'google', 'www.google.com');
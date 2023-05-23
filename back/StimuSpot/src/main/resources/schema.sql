DROP DATABASE IF EXISTS project;
create database if not exists project;
use project;

CREATE TABLE IF NOT EXISTS users (
 user_num     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 user_id       VARCHAR(20),
 user_pw       VARCHAR(20),
 user_nickname VARCHAR(20),
 user_email    VARCHAR(45),  
 user_age      INT,
 user_selfie   VARCHAR(50)
); 

INSERT INTO users 
(user_id, user_pw, user_email, user_age)
VALUES
('ssafy', '1234', 'ssafy@naver.com', 27),
('song', '1234', 'adam1229@naver.com', 28);

CREATE TABLE friends (
user_num      INT,
friend_num    INT,
friend_date   DATETIME,
FOREIGN KEY (user_num) REFERENCES users(user_num),
FOREIGN KEY (friend_num) REFERENCES users(user_num)
);

INSERT INTO friends
VALUES
(1,2,"2023-05-21");

CREATE TABLE loginlog (
user_num       INT,
logdate        DATETIME,
FOREIGN KEY (user_num) REFERENCES users(user_num)
);

CREATE TABLE achievements (
achv_id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
achv_title     VARCHAR(30), 
achv_content   VARCHAR(50)
);

INSERT INTO achievements
(achv_title, achv_content)
VALUES
('시작이 반이다', '첫 운동 다이어리 작성과 함께 꾸준히 운동해봐요!'),
('상체충', '하체 운동 없이 상체 운동만 10번 연속 시행한 당신, 아주 대단해요!');

CREATE TABLE user_achieve(
user_num       INT,
achv_id        INT,
achieved_date      Date,
FOREIGN KEY(user_num) REFERENCES users(user_num),
FOREIGN KEY(achv_id) REFERENCES achievements(achv_id)
);

INSERT INTO user_achieve
VALUES
(1,1,"2023-04-21"),
(1,2,"2023-05-21"),
(2,1,"2023-05-21");

CREATE TABLE streak (
streak_id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_num         INT,
streak_start_date DATE,
streak_passed    INT,
FOREIGN KEY(user_num) REFERENCES users(user_num)
); 

CREATE TABLE diaries (
diary_id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_num         INT,
diary_title     VARCHAR(30),
diary_regdate   DATE,
diary_rating    INT,
diary_content   VARCHAR(100),
FOREIGN KEY(user_num) REFERENCES users(user_num)
);

INSERT INTO diaries
(user_num, diary_regdate, diary_rating, diary_content)
VALUES
(1,'2023-05-12', 2, '세상은 날씨였지만 운동 사실 별로 안했어요 ㅠㅜㅠ'),
(2,'2023-05-14', 1, '세상동 사실 별로 안했어요 ㅠㅜㅠ'),
(1,'2023-05-15', 4, '기 딱 좋은 날씨였지만 운동 사실 별로 안했어요 ㅠㅜㅠ'),
(1,'2023-05-16', 5, '만 운동 사실 별로 안했어요 ㅠㅜㅠ');

CREATE TABLE parts (
part_id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
part_name        VARCHAR(20),
part_content     VARCHAR(100),
part_icon        VARCHAR(50)
);

INSERT INTO parts
(part_name, part_content)
VALUES
('가슴', '가슴 운동입니다'),('전완근', '전완근 운동입니다'),('엉덩이', '엉덩이 운동입니다'),
('복근', '복근 운동입니다'),
('이두', '이두 운동입니다'),
('삼두', '삼두 운동입니다'),
('어깨', '어깨 운동입니다'),
('등', '등 운동입니다'),
('종아리', '종아리 운동입니다'),
('허벅지', '허벅지 운동입니다');

CREATE TABLE diary_part (
diary_id         INT,
part_id          INT,
FOREIGN KEY(diary_id) REFERENCES diaries(diary_id),
FOREIGN KEY(part_id) REFERENCES parts(part_id)
);

INSERT INTO diary_part
VALUES
(1,2),
(1,3);



CREATE TABLE user_part (
user_num         INT,
part_id          INT,
last_workout     DATE,
FOREIGN KEY(user_num) REFERENCES users(user_num),
FOREIGN KEY(part_id) REFERENCES parts(part_id)
);

INSERT INTO user_part
VALUES
(1,1,'2023-05-10'),
(1,2,'2023-05-13'),
(1,3,'2023-05-15'),
(1,4,'2023-05-13'),
(1,5,'2023-05-11'),
(1,6,'2023-05-12'),
(1,7,'2023-05-13');

CREATE TABLE scraps (
scrap_id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_num  INT,
scrap_url VARCHAR(30),
scrap_content  VARCHAR(100),
scrap_title VARCHAR(30),
scrap_regdate DATE,
FOREIGN KEY(user_num) REFERENCES users(user_num)
);

CREATE TABLE comments (
comment_id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
scrap_id INT,
comment_content VARCHAR(100),
comment_writer VARCHAR(30),
FOREIGN KEY(scrap_id) REFERENCES scraps(scrap_id)
);


CREATE TABLE luck (
luck_id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
luck_content    VARCHAR(45)
);

INSERT INTO luck (luck_content)
-- VALUES ('오늘의 나는 두고 가'); 
VALUES ('내일의 나한테 맡기자');

INSERT INTO streak (user_num, streak_start_date, streak_passed)
VALUES (1, '2023-05-19', 4),
(1, '2023-05-06', 2),
(1, '2023-05-08', 3),
(1, '2023-05-15', 6),
(1, '2023-05-24', 1),
(1, '2023-05-28', 3);



select * from users;
select * from streak;
desc streak;

SELECT *
		FROM streak
		ORDER BY streak_start_date DESC
		LIMIT 20;
        
DELETE from streak
where streak_id = 9;

SELECT streak_passed
		FROM streak
		ORDER BY streak_passed DESC;
SELECT *
		FROM streak
		ORDER BY streak_start_date DESC
		LIMIT 1;

desc diaries;
SELECT * from diaries;
SELECT *
		FROM diaries
		WHERE diary_regdate = '2023-05-12'
			AND user_num = 1;
            
            SELECT *
		FROM diaries
		WHERE diary_regdate BETWEEN '2023-05-13' AND '2023-05-16'
        AND user_num = 2;

SELECT * from parts;
DESC parts;

SELECT * From diary_part;

SELECT * from users;
desc diaries;
SELECT * from diaries;



insert into diaries (user_num, diary_title, diary_rating, diary_regdate, diary_content)
values
(2,
 'test',
 5,
 '2023-03-15',
 'test1'
);

SELECT * from achievements;
SELECT * from user_achieve;

SELECT ua.achv_id AS achvId, ac.achv_title AS achvTitle, ac.achv_content AS achvContent, ua.achieved_date AS achievedDate
		FROM user_achieve ua
		JOIN achievements ac 
		ON ua.achv_id = ac.achv_id 
		WHERE ua.user_num = 1;
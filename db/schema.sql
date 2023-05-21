create database if not exists project;
use project;

CREATE TABLE users (
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


CREATE TABLE streaks (
streak_id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_num         INT,
streak_startdate DATE,
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
(1,'2023-05-13', 3, '세상 운동하기 딱 좋은 날씨였지만 운동 사실 별로 안했어요 ㅠㅜㅠ');

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

CREATE TABLE parts (
part_id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
part_name        VARCHAR(20),
part_content     VARCHAR(100),
part_icon        VARCHAR(50)
);

INSERT INTO parts
(part_name, part_content)
VALUES
('복근', '복근 운동입니다'),
('이두', '이두 운동입니다'),
('삼두', '삼두 운동입니다'),
('어깨', '어깨 운동입니다'),
('등', '등 운동입니다'),
('종아리', '종아리 운동입니다'),
('허벅지', '허벅지 운동입니다');

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
